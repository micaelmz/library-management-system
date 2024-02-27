package app.controllers;

import app.GlobalData;
import app.dao.ReaderDAOList;
import app.dao.UtilityAllUsers;
import app.enums.Role;
import app.model.Admin;
import app.model.BaseUser;
import app.model.Reader;
import app.views.DashboardView;
import app.views.FinishRegisterView;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class ProfileController {

    @FXML
    Label nameLabel;
    @FXML
    Label roleLabel;
    @FXML
    Label usernameLabel;
    @FXML
    Label addressLabel;
    @FXML
    Label phoneLabel;
    @FXML
    Label bannedUntilLabel;

    @FXML
    TextField banDaysInput;

    @FXML
    Pane adminPane;

    @FXML
    ComboBox roleComboBox;

    BaseUser currentUser;

    @FXML
    protected void initialize() {
        if (GlobalData.getLoggedUser().getRole() == Role.ADMIN) {
            adminPane.setDisable(false);
        }
    }

    public void initData(BaseUser user) {
        currentUser = user;
        nameLabel.setText(user.getName());
        usernameLabel.setText("@" + user.getUsername());
        Role userRole = user.getRole();


        if (userRole != null) {
            roleLabel.setText(userRole.toString());
        }

        if (user.getRole() == Role.READER) {
            Reader reader = (Reader) user;
            addressLabel.setText(reader.getAddress());
            phoneLabel.setText(reader.getPhoneNumber());

            if (reader.isBanned()) {
                bannedUntilLabel.setText("Banido até " + reader.getBannedUntil());
            }
        }

    }

    @FXML
    protected void onCloseClicked() {
        DashboardView.show("users");
    }

    @FXML
    protected void onBanClicked() throws IOException, ClassNotFoundException {
        BaseUser loggedUser = GlobalData.getLoggedUser();
        if (loggedUser.getRole() == Role.ADMIN) {
            Admin admin = (Admin) loggedUser;
            admin.banReader((Reader) currentUser, Integer.parseInt(banDaysInput.getText()));
            bannedUntilLabel.setText("Banido até " + ((Reader) currentUser).getBannedUntil());
            banDaysInput.clear();
        }
        UtilityAllUsers.saveAll();
    }

    @FXML
    protected void onRoleChange() throws IOException {
        String selectedRole = (String) roleComboBox.getSelectionModel().getSelectedItem();
        switch (selectedRole) {
            case "ADMINISTRADOR" -> {
                currentUser.setRole(Role.ADMIN);
                roleLabel.setText(Role.ADMIN.toString());
            }
            case "BIBLIOTECÁRIO" -> {
                currentUser.setRole(Role.LIBRARIAN);
                roleLabel.setText(Role.LIBRARIAN.toString());
            }
            case "LEITOR" -> {
//                currentUser.setRole(Role.READER);
                roleLabel.setText(Role.READER.toString());
                FinishRegisterView.show(currentUser);
            }
            case "VISITANTE" -> {
                currentUser.setRole(null);
                roleLabel.setText("VISITANTE");
            }
        }
        UtilityAllUsers.saveAll();
    }
}
