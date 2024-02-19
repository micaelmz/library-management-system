package app.controllers;

import app.GlobalData;
import app.dao.BaseUserDAOList;
import app.dao.CRUD;
import app.dao.AdminDAOList;
import app.dao.UsersDaoList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import app.views.LoginView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.util.List;


public class DashboardController {

    private final Integer TABLE_MAX_WIDTH = 550;

    private <T> void loadTableData(CRUD<T> dao) throws IOException, ClassNotFoundException {
        dao.loadDatFile();
        List<T> dataList = dao.getAll();
        dataTable.getItems().clear();
        dataTable.getItems().addAll(dataList);
    }

    private <S, T> void addTableColumn(TableView<S> table, String columnName, String property, Integer width) {
        TableColumn<S, T> column = new TableColumn<>(columnName);
        column.setCellValueFactory(new PropertyValueFactory<>(property));
        column.setMinWidth(width);
        column.setMaxWidth(width);
        table.getColumns().add(column);
    }

    private Integer columnPercentage(Integer percentage) {
        return (percentage * TABLE_MAX_WIDTH) / 100;
    }

    @FXML
    private TableView dataTable;

    @FXML
    protected void onBooksClicked() {
        System.out.println("Books clicked");
    }

    @FXML
    protected void onUsersClicked() throws IOException, ClassNotFoundException {
        dataTable.getColumns().clear();
        addTableColumn(dataTable, "ID", "id", columnPercentage(10));
        addTableColumn(dataTable, "Nome", "name", columnPercentage(30));
        addTableColumn(dataTable, "Username", "username", columnPercentage(30));
        addTableColumn(dataTable, "Cargo", "role", columnPercentage(30));
        loadTableData(new UsersDaoList());
    }

    @FXML
    protected void onBorrowingClicked() {
        System.out.println("Borrowing clicked");
    }

    @FXML
    protected void onReservationsClicked() {
        System.out.println("Reservations clicked");
    }

    @FXML
    protected void onStatisticsClicked() {
        System.out.println("Statistics clicked");
    }

    @FXML
    protected void onLogoutClicked() {
        GlobalData.setLoggedUser(null);
        LoginView.show();
    }

    @FXML
    protected void onSearchClicked() {
        System.out.println("Search clicked");
    }
}
