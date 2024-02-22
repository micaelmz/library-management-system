package app.controllers;

import app.GlobalData;
import app.dao.BookDAOList;
import app.dao.UtilityAllUsers;
import app.enums.Role;
import app.model.BaseUser;
import app.model.Book;
import app.views.BooksView;
import app.views.ProfileView;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import app.views.LoginView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.shape.Rectangle;

import java.io.IOException;
import java.util.function.Consumer;


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
    protected void onUsersClicked() throws IOException, ClassNotFoundException {
        setSelectedBackgroundBtn(backgroundUsersBtn);
        dataTable.getColumns().clear();
        addTableColumn(dataTable, "ID", "id", columnPercentage(8));
        addTableColumn(dataTable, "Nome", "name", columnPercentage(25));
        addTableColumn(dataTable, "Username", "username", columnPercentage(25));
        addTableColumn(dataTable, "Cargo", "role", columnPercentage(25));
        addHyperlinkColumn(dataTable, "Perfil", columnPercentage(17), this::showUserProfile);
        dataTable.getItems().clear();
        dataTable.getItems().addAll(UtilityAllUsers.getAll());

        sortTableBy(dataTable, 0);
    }

    @FXML
    protected void onBooksClicked() throws IOException, ClassNotFoundException {
        BookDAOList bookDAO = new BookDAOList();
        bookDAO.loadDatFile();
        setSelectedBackgroundBtn(backgroundBookBtn);
        dataTable.getColumns().clear();
        addTableColumn(dataTable, "ID", "id", columnPercentage(6));
        addTableColumn(dataTable, "Título", "title", columnPercentage(30));
        addTableColumn(dataTable, "Autor", "author", columnPercentage(20));
        addTableColumn(dataTable, "Categoria", "category", columnPercentage(13));
        addTableColumn(dataTable, "Quantidade", "quantity", columnPercentage(6));
        addTableColumn(dataTable, "Ano", "publicationYear", columnPercentage(9));
        addHyperlinkColumn(dataTable, "Detalhes", columnPercentage(16), this::showBookDetails);
        dataTable.getItems().clear();
        dataTable.getItems().addAll(bookDAO.getAll());

        sortTableBy(dataTable, 0);
    }

    private void showUserProfile(BaseUser user) {
        ProfileView.show(user);
    }

    private void showBookDetails(Book book) {
        BooksView.show(book);
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

    }


    private void setSelectedBackgroundBtn(Rectangle target) {
        backgroundBookBtn.setFill(javafx.scene.paint.Color.web("#223a4e"));
        backgroundUsersBtn.setFill(javafx.scene.paint.Color.web("#223a4e"));
        backgroundBorrowingBtn.setFill(javafx.scene.paint.Color.web("#223a4e"));
        backgroundReservationsBtn.setFill(javafx.scene.paint.Color.web("#223a4e"));
        backgroundStatisticsBtn.setFill(javafx.scene.paint.Color.web("#223a4e"));
        target.setFill(javafx.scene.paint.Color.web("#58a1dd"));
    }

    private <S, T> void addHyperlinkColumn(TableView<S> table, String columnName, Integer width, Consumer<S> onHyperlinkClicked) {
        TableColumn<S, T> column = new TableColumn<>(columnName);
        column.setMinWidth(width);
        column.setMaxWidth(width);

        // Define a fábrica de células personalizada
        column.setCellValueFactory(cellData -> (ObservableValue<T>) new ReadOnlyObjectWrapper<>(cellData.getValue()));

        // Crie a célula personalizada com Hyperlink
        column.setCellFactory(col -> {
            TableCell<S, T> cell = new TableCell<>() {
                private final Hyperlink link = new Hyperlink();

                {
                    // Adicione um listener para o clique no Hyperlink
                    link.setOnAction(event -> {
                        S rowData = getTableView().getItems().get(getIndex());
                        onHyperlinkClicked.accept(rowData); // Execute a ação definida
                    });
                }

                @Override
                protected void updateItem(T item, boolean empty) {
                    super.updateItem(item, empty);

                    if (empty || item == null) {
                        setGraphic(null);
                    } else {
                        link.setText("Detalhes");
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
