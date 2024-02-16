package app.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;


public class LoginController {
    @FXML
    private Label statusLabel;
    @FXML
    private TextField loginInput;
    @FXML
    private PasswordField passwordInput;

    @FXML
    protected void onLoginClick() {
        if (loginInput.getText().equals("admin") && passwordInput.getText().equals("admin")) {
            statusLabel.setText("Login successful!");
        } else {
            statusLabel.setText("Login failed!");
        }
    }
}