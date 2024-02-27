package app.controllers;

import app.GlobalData;
import app.dao.BookDAOList;
import app.enums.Role;
import app.model.Book;
import app.views.DashboardView;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class BookController {

    Book book;

    @FXML
    Label titleLabel;
    @FXML
    Label authorLabel;
    @FXML
    Label quantityAvailableLabel;
    @FXML
    Label isbnLabel;
    @FXML
    Label categoryLabel;
    @FXML
    Label booksAvaliableLabel;

    @FXML
    Pane moderatorPane;

    @FXML
    TextField addQuantityInput;

    @FXML
    protected void initialize() {
        Role currentUserRole = GlobalData.getLoggedUser().getRole();
        if (currentUserRole == Role.ADMIN || currentUserRole == Role.LIBRARIAN ) {
            moderatorPane.setDisable(false);
        }
    }

    public void initData(Book book) {
        this.book = book;
        titleLabel.setText(book.getTitle());
        authorLabel.setText("@"+book.getAuthor());
        booksAvaliableLabel.setText(book.getQuantity() + " livros restantes");
        isbnLabel.setText("ISBN: " + book.getISBN());
        categoryLabel.setText("Gênero: " + book.getCategory());
        quantityAvailableLabel.setText(book.isAvailable() ? "Disponível" : "Esgotado");
    }

    @FXML
    private void onCloseClicked(){
        DashboardView.show("books");
    }

    @FXML
    private void onAddClick() throws IOException, ClassNotFoundException {
        BookDAOList bookDAOList = new BookDAOList();
        bookDAOList.loadDatFile();
        int quantity = Integer.parseInt(addQuantityInput.getText());
        book.setQuantity(book.getQuantity() + quantity);
        booksAvaliableLabel.setText(book.getQuantity() + " livros restantes");
        addQuantityInput.clear();
        bookDAOList.update(book);
        bookDAOList.saveDatFile();
    }

    @FXML
    private void onOptionChange() {
        //
    }
}
