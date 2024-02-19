package app.controllers;

import app.dao.BaseUserDAOList;
import app.model.BaseUser;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import app.views.LoginView;

import java.io.IOException;
import java.util.List;

public class RegisterController {

    @FXML TextField fnameInput;
    @FXML TextField lnameInput;
    @FXML TextField usernameInput;
    @FXML PasswordField passwordInput;
    @FXML PasswordField confirmPasswordInput;
    @FXML Label statusLabel;

    BaseUserDAOList users = new BaseUserDAOList();
    Boolean erro = false;

    @FXML
    protected void onRegisterClick() throws IOException, ClassNotFoundException {
        String fullName = fnameInput.getText() + " " + lnameInput.getText();
        String username = usernameInput.getText();
        String password = passwordInput.getText();
        users.loadDatFile();
        List<BaseUser> baseUsers = users.getAll();
        if (username.isEmpty() || password.isEmpty()) {
            statusLabel.setText("Preencha todos os campos");
            erro = true;
        }
        if (!password.equals(confirmPasswordInput.getText())) {
            statusLabel.setText("As senhas não coincidem");
            erro = true;
        }
        for (BaseUser baseUser : baseUsers) {
            if (baseUser.getUsername().equals(username)) {
                statusLabel.setText("Usuário já existe");
                erro = true;
            }
        }
        if (!erro) {
            users.create(new BaseUser(username, password, fullName));
            users.saveDatFile();
            LoginView.show();
        }
    }

    @FXML
    protected void onLoginClick() {
        LoginView.show();
    }
}
