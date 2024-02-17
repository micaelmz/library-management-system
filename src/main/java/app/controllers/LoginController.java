package app.controllers;

import app.dao.usuario.UsuarioDAOList;
import app.model.Usuario;
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

    UsuarioDAOList users = new UsuarioDAOList();

    @FXML
    protected void onLoginClick() throws IOException, ClassNotFoundException {
        String username = loginInput.getText();
        String password = passwordInput.getText();
        users.carregarArquivo();
        Usuario user = users.encontrarPorUsuario(username);
        if (user != null && user.getSenha().equals(password)) {
            statusLabel.setText("Login successful");
        } else {
            statusLabel.setText("Login failed");
        }
    }

    @FXML
    protected void onRegisterClick() {
        RegisterView.show();
    }
}