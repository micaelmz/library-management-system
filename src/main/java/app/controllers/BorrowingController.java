package app.controllers;

import app.dao.BookDAOList;
import app.dao.BorrowingDAOList;
import app.dao.ReaderDAOList;
import app.enums.BorrowingStatus;
import app.model.Borrowing;
import app.views.DashboardView;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.io.IOException;

public class BorrowingController {

    @FXML
    Label nameLabel;
    @FXML
    Label statusLabel;
    @FXML
    Label sinceLabel;
    @FXML
    Label untilLabel;
    @FXML
    Label usernameLabel;
    @FXML
    Label renewalsLabel;

    Borrowing borrowing;
    public void initData(Borrowing borrowing) {
        this.borrowing = borrowing;
        nameLabel.setText(borrowing.getBook().getTitle());
        usernameLabel.setText("com " + borrowing.getReader().getName() + "(" + borrowing.getReader().getUsername() + ")");
        statusLabel.setText(borrowing.isOverdue() ? "ATRASADO" : "EM DIA");
        sinceLabel.setText("desde " + borrowing.getLoanDate().toString());
        untilLabel.setText("até " + borrowing.getDueDate().toString());
        renewalsLabel.setText(borrowing.getRenewals().toString() + " renovações restantes.");
    }

    @FXML
    protected void onCloseClicked() {
        DashboardView.show("borrowing");
    }

    @FXML
    protected void onRenewClicked() throws IOException, ClassNotFoundException {
        BorrowingDAOList borrowingDAO = new BorrowingDAOList();
        borrowingDAO.loadDatFile();
        boolean success = borrowing.renew();
        if (success) {
            borrowingDAO.update(borrowing);
            borrowingDAO.saveDatFile();
            initData(borrowingDAO.findById(borrowing.getId()));
        }
        else{
            renewalsLabel.setText("Não foi possível renovar o empréstimo.");
        }
    }

    @FXML
    protected void onReturnBookClicked() throws IOException, ClassNotFoundException {
        BorrowingDAOList borrowingDAO = new BorrowingDAOList();
        borrowingDAO.loadDatFile();

        BookDAOList bookDAO = new BookDAOList();
        bookDAO.loadDatFile();

        borrowing.setBook(bookDAO.findById(borrowing.getBook().getId()));
        Integer oldId = null;
        if (!borrowing.getBook().getReservations().isEmpty()){
            oldId = borrowing.getBook().getReservations().getFirst().getId();
        }

        Borrowing result = borrowing.returnBook();
        borrowingDAO.update(result);
        borrowingDAO.saveDatFile();

        if (result.getReader().isBanned()){
            ReaderDAOList readerDAO = new ReaderDAOList();
            readerDAO.loadDatFile();
            readerDAO.update(result.getReader());
            readerDAO.saveDatFile();
        }
        if (oldId != null){
            borrowingDAO.delete(borrowingDAO.findById(oldId));
        }
        borrowingDAO.saveDatFile();
        bookDAO.update(result.getBook());
        bookDAO.saveDatFile();
        DashboardView.show("borrowing");
    }
}
