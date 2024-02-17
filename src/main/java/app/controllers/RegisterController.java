package app.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class RegisterController {

    @FXML
    protected void onRegisterClick() {
        System.out.println("RegisterController.register");
    }

    @FXML
    protected void onLoginClick() {
        System.out.println("RegisterController.login");
    }
}
