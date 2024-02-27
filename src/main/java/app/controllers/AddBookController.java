package app.controllers;

import app.views.DashboardView;
import javafx.fxml.FXML;

public class AddBookController {

    @FXML
    protected void onSaveButton() {

    }

    @FXML
    protected void onCloseClicked() {
        DashboardView.show();
    }
}
