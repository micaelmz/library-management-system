package app.controllers;

import app.GlobalData;
import app.dao.BookDAOList;
import app.dao.BorrowingDAOList;
import app.dao.ReaderDAOList;
import app.enums.Role;
import app.model.Book;
import app.model.Borrowing;
import app.model.Librarian;
import app.model.Reader;
import app.views.DashboardView;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;

public class AddBorrowingController {

    @FXML
    Label statusLabel;

    @FXML
    TextField userIdInput;
    @FXML
    TextField bookIdInput;

    @FXML
    PasswordField passwordInput;

    @FXML
    DatePicker untilInput;

    Reader targetReader = null;

    ReaderDAOList readerDAO = new ReaderDAOList();

    @FXML
    protected void initialize() throws IOException, ClassNotFoundException {
        readerDAO.loadDatFile();
        if (GlobalData.getLoggedUser().getRole() == Role.READER) {
            userIdInput.setDisable(true);
            userIdInput.setText(GlobalData.getLoggedUser().getId().toString());
            untilInput.setDisable(true);
            untilInput.setValue(LocalDate.now().plusWeeks(1));
            targetReader = (Reader)GlobalData.getLoggedUser();
        }
    }

    @FXML
    protected void onCloseClicked() {
        DashboardView.show("borrowing");
    }

    @FXML
    protected void onSaveButton() throws IOException, ClassNotFoundException {

        if (targetReader == null) {
            targetReader = readerDAO.findById(Integer.parseInt(userIdInput.getText()));
        }

        BookDAOList bookDAO = new BookDAOList();
        BorrowingDAOList borrowingDAO = new BorrowingDAOList();
        bookDAO.loadDatFile();
        borrowingDAO.loadDatFile();
        Book targetBook = bookDAO.findById(Integer.parseInt(bookIdInput.getText()));

        if (userIdInput.getText().isEmpty() || bookIdInput.getText().isEmpty() || passwordInput.getText().isEmpty() || untilInput.getValue() == null) {
            statusLabel.setText("Por favor, preencha todos os campos");
            return;
        }

        if (!GlobalData.checkCredentials(passwordInput.getText())) {
            statusLabel.setText("Senha incorreta");
            return;
        }

        if (targetReader == null) {
            statusLabel.setText("Leitor não encontrado");
            return;
        }

        if (targetBook == null) {
            statusLabel.setText("Livro não encontrado");
            return;
        }

        if (targetReader.isBanned()) {
            statusLabel.setText("Leitor banido");
            return;
        }

        LocalDate today = LocalDate.now();
        Borrowing newBorrowing = new Borrowing(targetReader, targetBook, today.until(untilInput.getValue()).getDays(), targetBook.getRenewalLimit());

        if (targetBook.isAvailable()){
            targetBook.addBorrowing(newBorrowing);
            targetBook.setQuantity(targetBook.getQuantity() - 1);
        }
        else{
            newBorrowing.setAsReserved();
            targetBook.addReservation(newBorrowing);
        }

        targetReader.addToBorrowingHistory(newBorrowing);

        bookDAO.update(targetBook);
        readerDAO.update(targetReader);
        borrowingDAO.create(newBorrowing);

        bookDAO.saveDatFile();
        readerDAO.saveDatFile();
        borrowingDAO.saveDatFile();

        DashboardView.show("borrowing");
    }
}
