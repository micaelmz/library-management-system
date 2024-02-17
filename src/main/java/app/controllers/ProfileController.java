package app.controllers;

import app.GlobalData;
import app.dao.baseuser.BaseUserDAOList;
import app.model.BaseUser;
import app.views.LoginView;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;

public class ProfileController {
    @FXML TextField fnameInput;
    @FXML TextField lnameInput;
    @FXML TextField usernameInput;
    @FXML PasswordField passwordInput;
    @FXML PasswordField confirmPasswordInput;

    BaseUserDAOList allUsers = new BaseUserDAOList();

    BaseUser loggedUser = GlobalData.getLoggedUser();

    Boolean erro = false;

    @FXML
    protected void onSaveButton() throws IOException, ClassNotFoundException{
        allUsers.loadDatFile();
        BaseUser oldUserData = allUsers.findByUsername(loggedUser.getUsername());
        String fullName = fnameInput.getText() + ' ' + lnameInput.getText();
        String username = usernameInput.getText();
        String password = passwordInput.getText();
        loggedUser.setName(fullName);
        loggedUser.setUsername(username);
        loggedUser.setPassword(password);
        allUsers.update(oldUserData, loggedUser);
        allUsers.saveDatFile();
    }
}
