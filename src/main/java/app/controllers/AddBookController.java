package app.controllers;

import app.dao.BookDAOList;
import app.model.Book;
import app.views.DashboardView;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;

public class AddBookController {

    @FXML
    TextField titleInput;
    @FXML
    TextField authorInput;
    @FXML
    TextField categoryInput;
    @FXML
    TextField yearInput;
    @FXML
    TextField isbnInput;
    @FXML
    TextField quantityInput;
    @FXML
    TextField renewLimitInput;

    @FXML
    Label statusLabel;

    @FXML
    protected void onSaveButton() throws IOException, ClassNotFoundException {
        if (titleInput.getText().isEmpty() || authorInput.getText().isEmpty() || categoryInput.getText().isEmpty() || yearInput.getText().isEmpty() || isbnInput.getText().isEmpty() || quantityInput.getText().isEmpty() || renewLimitInput.getText().isEmpty()) {
            statusLabel.setText("Por favor preencha todos os campos");
            return;
        }
        BookDAOList bookDAO = new BookDAOList();
        bookDAO.loadDatFile();
        bookDAO.create(new Book(titleInput.getText(), authorInput.getText(), isbnInput.getText(), Integer.parseInt(yearInput.getText()), categoryInput.getText(), Integer.parseInt(quantityInput.getText()), Integer.parseInt(renewLimitInput.getText())));
        bookDAO.saveDatFile();

        DashboardView.show();
    }

    @FXML
    protected void onCloseClicked() {
        DashboardView.show();
    }
}
