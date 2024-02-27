package app.controllers;

import app.dao.BaseUserDAOList;
import app.dao.ReaderDAOList;
import app.dao.UtilityAllUsers;
import app.model.BaseUser;
import app.model.Reader;
import app.views.DashboardView;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.util.List;

public class FinishRegisterController {

    private BaseUser user;

    @FXML
    TextField cityInput;
    @FXML
    TextField streetInput;
    @FXML
    TextField numberInput;
    @FXML
    TextField telephoneInput;

    @FXML
    ComboBox stateInput;

    @FXML
    Label statusLabel;


    public void initData(BaseUser user) {
        this.user = user;
    }

    @FXML
    private void onRegisterClick() throws IOException, ClassNotFoundException {
        String address = streetInput.getText() + ", " + numberInput.getText() + ", " + cityInput.getText() + " - " + stateInput.getValue();

        Reader reader = new Reader(user.getUsername(), user.getPassword(), user.getName(), address, telephoneInput.getText());

        int id = user.getId();
        BaseUserDAOList usersDAO = new BaseUserDAOList();
        usersDAO.loadDatFile();
        usersDAO.delete(user);
        usersDAO.saveDatFile();

        ReaderDAOList readerDAO = new ReaderDAOList();
        readerDAO.loadDatFile();
        readerDAO.create(reader).setId(id);
        readerDAO.saveDatFile();

        DashboardView.show("users");
    }
}
