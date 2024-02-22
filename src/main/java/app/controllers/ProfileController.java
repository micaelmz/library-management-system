package app.controllers;

import app.GlobalData;
import app.dao.UtilityAllUsers;
import app.enums.Role;
import app.model.BaseUser;
import app.model.Reader;
import app.views.DashboardView;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
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
        }

    }

    @FXML
    protected void onCloseClicked() {
        DashboardView.show();
    }

    @FXML
    protected void onBanClicked() {
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
                currentUser.setRole(Role.READER);
                roleLabel.setText(Role.READER.toString());
                // todo: chamar a tela de edição de leitor
            }
            case "VISITANTE" -> {
                currentUser.setRole(null);
                roleLabel.setText("VISITANTE");
            }
        }
        UtilityAllUsers.saveAll();
    }
}
