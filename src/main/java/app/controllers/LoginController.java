package app.controllers;

import app.GlobalData;

import app.dao.UtilityAllUsers;
import app.model.BaseUser;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import app.views.RegisterView;
import app.views.DashboardView;

import java.io.IOException;


public class LoginController {
    @FXML
    private Label statusLabel;
    @FXML
    private TextField loginInput;
    @FXML
    private PasswordField passwordInput;


    @FXML
    protected void onLoginClick() throws IOException, ClassNotFoundException {
        String username = loginInput.getText();
        String password = passwordInput.getText();
        UtilityAllUsers.getAll();
        BaseUser user = UtilityAllUsers.findUserByUsername(username);
        if (user != null && user.getPassword().equals(password)) {
            statusLabel.setText("Login successful");
            GlobalData.setLoggedUser(user);
            DashboardView.show("books");
        } else {
            statusLabel.setText("Login failed");
        }
    }

    @FXML
    protected void onRegisterClick() {
        RegisterView.show();
    }
}