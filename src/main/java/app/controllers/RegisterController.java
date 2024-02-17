package app.controllers;

import app.dao.admin.AdminDAOList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import app.dao.usuario.UsuarioDAOList;
import app.model.Usuario;
import app.views.LoginView;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class RegisterController {

    @FXML TextField fnameInput;
    @FXML TextField lnameInput;
    @FXML TextField usernameInput;
    @FXML PasswordField passwordInput;
    @FXML PasswordField confirmPasswordInput;
    @FXML Label statusLabel;

    UsuarioDAOList users = new UsuarioDAOList();
    Boolean erro = false;

    @FXML
    protected void onRegisterClick() throws IOException, ClassNotFoundException {
        String fullName = fnameInput.getText() + " " + lnameInput.getText();
        String username = usernameInput.getText();
        String password = passwordInput.getText();
        users.carregarArquivo();
        List<Usuario> usuarios = users.lerTodos();
        if (username.isEmpty() || password.isEmpty()) {
            statusLabel.setText("Preencha todos os campos");
            erro = true;
        }
        if (!password.equals(confirmPasswordInput.getText())) {
            statusLabel.setText("As senhas não coincidem");
            erro = true;
        }
        for (Usuario usuario : usuarios) {
            if (usuario.getUsuario().equals(username)) {
                statusLabel.setText("Usuário já existe");
                erro = true;
            }
        }
        if (!erro) {
            users.criar(new Usuario(username, password, fullName));
            users.salvarArquivo();
            statusLabel.setText("Usuário criado com sucesso");
        }
    }

    @FXML
    protected void onLoginClick() {
        LoginView.show();
    }
}
