package app.controllers;

import app.views.DashboardView;
import javafx.fxml.FXML;

public class AddBorrowingController {

    @FXML
    protected void onSaveButton() {

    }

    @FXML
    protected void onCloseClicked() {
        DashboardView.show();
    }
}
