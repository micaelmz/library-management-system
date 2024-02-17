package app.controllers;

import app.GlobalData;
import app.dao.baseuser.BaseUserDAOList;
import app.model.BaseUser;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ProfileController implements Initializable {
    @FXML TextField nameInput;
    @FXML TextField usernameInput;
    @FXML PasswordField passwordInput;

    BaseUserDAOList allUsers = new BaseUserDAOList();

    BaseUser loggedUser = GlobalData.getLoggedUser();

    Boolean erro = false;

    @FXML
    protected void onSaveButton() throws IOException, ClassNotFoundException{
        allUsers.loadDatFile();
        BaseUser oldUserData = allUsers.findByUsername(loggedUser.getUsername());
        String fullName = nameInput.getText();
        String username = usernameInput.getText();
        String password = passwordInput.getText();
        loggedUser.setName(fullName);
        loggedUser.setUsername(username);
        loggedUser.setPassword(password);
        allUsers.update(oldUserData, loggedUser);
        allUsers.saveDatFile();
    }

    @FXML
    protected void nameField(){
        nameInput.setText(loggedUser.getName());
        nameInput.setFocusTraversable(false);
    }

    @FXML
    protected void usernameField(){
        usernameInput.setText(loggedUser.getUsername());
        usernameInput.setFocusTraversable(false);
    }

    @FXML
    protected void passwordField(){
        passwordInput.setText(loggedUser.getPassword());
        passwordInput.setFocusTraversable(false);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        nameField();
        usernameField();
        passwordField();
    }
}
