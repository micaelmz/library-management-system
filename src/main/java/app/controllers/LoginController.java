package app.controllers;

import app.GlobalData;
import app.dao.baseuser.BaseUserDAOList;
import app.model.BaseUser;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import app.views.RegisterView;

import java.io.IOException;


public class LoginController {
    @FXML
    private Label statusLabel;
    @FXML
    private TextField loginInput;
    @FXML
    private PasswordField passwordInput;

    BaseUserDAOList users = new BaseUserDAOList();

    @FXML
    protected void onLoginClick() throws IOException, ClassNotFoundException {
        String username = loginInput.getText();
        String password = passwordInput.getText();
        users.loadDatFile();
        BaseUser user = users.findByUsername(username);
        if (user != null && user.getPassword().equals(password)) {
            statusLabel.setText("Login successful");
            GlobalData.setLoggedUser(user);
        } else {
            statusLabel.setText("Login failed");
        }
    }

    @FXML
    protected void onRegisterClick() {
        RegisterView.show();
    }
}