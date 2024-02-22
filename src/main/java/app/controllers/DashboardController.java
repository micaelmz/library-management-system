package app.controllers;

import app.GlobalData;
import app.dao.UtilityAllUsers;
import app.enums.Role;
import app.model.BaseUser;
import app.views.ProfileView;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import app.views.LoginView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.shape.Rectangle;

import java.io.IOException;


public class DashboardController {

    private final Integer TABLE_MAX_WIDTH = 550;

    @FXML
    Rectangle backgroundBookBtn;
    @FXML
    Rectangle backgroundUsersBtn;
    @FXML
    Rectangle backgroundBorrowingBtn;
    @FXML
    Rectangle backgroundReservationsBtn;
    @FXML
    Rectangle backgroundStatisticsBtn;

    @FXML
    Label usernameLabel;
    @FXML
    Label roleLabel;

    @FXML
    private TableView dataTable;

    @FXML
    protected void initialize() {
        setSelectedBackgroundBtn(backgroundBookBtn);
        usernameLabel.setText(GlobalData.getLoggedUser().getUsername());
        Role userRole = GlobalData.getLoggedUser().getRole();
        if (userRole != null) {
            roleLabel.setText(userRole.toString());
        }
    }

    @FXML
    protected void onBooksClicked() {
        setSelectedBackgroundBtn(backgroundBookBtn);
    }

    @FXML
    protected void onUsersClicked() throws IOException, ClassNotFoundException {
        setSelectedBackgroundBtn(backgroundUsersBtn);
        dataTable.getColumns().clear();
        addTableColumn(dataTable, "ID", "id", columnPercentage(8));
        addTableColumn(dataTable, "Nome", "name", columnPercentage(25));
        addTableColumn(dataTable, "Username", "username", columnPercentage(25));
        addTableColumn(dataTable, "Cargo", "role", columnPercentage(25));
        addHyperlinkColumn(dataTable, "Perfil", columnPercentage(17));
        dataTable.getItems().clear();
        dataTable.getItems().addAll(UtilityAllUsers.getAll());

        sortTableBy(dataTable, 0);
    }

    @FXML
    protected void onBorrowingClicked() {
        setSelectedBackgroundBtn(backgroundBorrowingBtn);
    }

    @FXML
    protected void onReservationsClicked() {
        setSelectedBackgroundBtn(backgroundReservationsBtn);
    }

    @FXML
    protected void onStatisticsClicked() {
        setSelectedBackgroundBtn(backgroundStatisticsBtn);
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


    private void setSelectedBackgroundBtn(Rectangle target) {
        backgroundBookBtn.setFill(javafx.scene.paint.Color.web("#223a4e"));
        backgroundUsersBtn.setFill(javafx.scene.paint.Color.web("#223a4e"));
        backgroundBorrowingBtn.setFill(javafx.scene.paint.Color.web("#223a4e"));
        backgroundReservationsBtn.setFill(javafx.scene.paint.Color.web("#223a4e"));
        backgroundStatisticsBtn.setFill(javafx.scene.paint.Color.web("#223a4e"));
        target.setFill(javafx.scene.paint.Color.web("#58a1dd"));
    }

    private <S, T> void addHyperlinkColumn(TableView<S> table, String columnName, Integer width) {
        TableColumn<S, T> column = new TableColumn<>(columnName);
        column.setMinWidth(width);
        column.setMaxWidth(width);

        // Crie a fábrica de células personalizada
        column.setCellValueFactory(cellData -> (ObservableValue<T>) new ReadOnlyObjectWrapper<>(cellData.getValue()));

        // Crie a célula personalizada com Hyperlink
        column.setCellFactory(col -> {
            TableCell<S, T> cell = new TableCell<>() {
                private final Hyperlink link = new Hyperlink();

                {
                    // Adicione um listener para o clique no Hyperlink
                    link.setOnAction(event -> {
                        S rowData = getTableView().getItems().get(getIndex());
                        BaseUser user = UtilityAllUsers.findById(((app.model.BaseUser) rowData).getId());
                        ProfileView.show(user);
                    });
                }

                @Override
                protected void updateItem(T item, boolean empty) {
                    super.updateItem(item, empty);

                    if (empty || item == null) {
                        setGraphic(null);
                    } else {
                        link.setText("Ver Perfil");
                        setGraphic(link);
                    }
                }
            };

            return cell;
        });

        table.getColumns().add(column);
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

    private void sortTableBy(TableView table, Integer columnIndex) {
        table.getSortOrder().clear();
        table.getSortOrder().add(table.getColumns().get(columnIndex));
    }
}
