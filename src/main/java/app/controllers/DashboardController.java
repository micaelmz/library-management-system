package app.controllers;

import app.GlobalData;
import app.dao.BookDAOList;
import app.dao.BorrowingDAOList;
import app.dao.UtilityAllUsers;
import app.enums.Role;
import app.model.BaseUser;
import app.model.Book;
import app.model.Borrowing;
import app.views.*;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
import javafx.util.Callback;

import java.io.IOException;
import java.util.function.Consumer;


public class DashboardController {

    private final Integer TABLE_MAX_WIDTH = 550;
    private String currentMenu = "books";

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
    Label pageTitleLabel;

    @FXML
    AnchorPane addButton;

    @FXML
    private TableView dataTable;

    public void initData(String menu) throws IOException, ClassNotFoundException {
        forceClick(menu);
    }

    @FXML
    protected void initialize() {
        usernameLabel.setText(GlobalData.getLoggedUser().getUsername());
        Role userRole = GlobalData.getLoggedUser().getRole();
        if (userRole != null) {
            roleLabel.setText(userRole.toString());
        }
    }

    @FXML
    protected void onUsersClicked() throws IOException, ClassNotFoundException {

        setMenu("users");

        dataTable.getColumns().clear();
        addTableColumn(dataTable, "ID", "id", columnPercentage(8));
        addTableColumn(dataTable, "Nome", "name", columnPercentage(25));
        addTableColumn(dataTable, "Username", "username", columnPercentage(25));
        addTableColumn(dataTable, "Cargo", "role", columnPercentage(25));
        addHyperlinkColumn(dataTable, "Perfil", columnPercentage(17), this::showUserDetails);
        dataTable.getItems().clear();
        dataTable.getItems().addAll(UtilityAllUsers.getAll());

        sortTableBy(dataTable, 0);
    }

    @FXML
    protected void onBooksClicked() throws IOException, ClassNotFoundException {

        setMenu("books");

        BookDAOList bookDAO = new BookDAOList();
        bookDAO.loadDatFile();
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

    @FXML
    protected void onBorrowingClicked() throws IOException, ClassNotFoundException {

        setMenu("borrowing");

        BorrowingDAOList borrowingDAOList = new BorrowingDAOList();
        borrowingDAOList.loadDatFile();
        dataTable.getColumns().clear();

        addTableColumn(dataTable, "ID", "id", columnPercentage(6));

        // Create a custom Callback for the ID of the Reader
        Callback<TableColumn.CellDataFeatures<Borrowing, String>, ObservableValue<String>> readerNameCallback = param ->
                new ReadOnlyObjectWrapper<>(param.getValue().getReader().getName()).asString();

        addTableColumnWithCallback(dataTable, "Leitor", "readerName", columnPercentage(20), readerNameCallback);

        Callback<TableColumn.CellDataFeatures<Borrowing, String>, ObservableValue<String>> bookTitleCallback = param ->
                new ReadOnlyObjectWrapper<>(param.getValue().getBook().getTitle()).asString();

        addTableColumnWithCallback(dataTable, "Livro", "bookTitle", columnPercentage(28), bookTitleCallback);

        addTableColumn(dataTable, "Data", "loanDate", columnPercentage(15));
        addTableColumn(dataTable, "Devolução", "dueDate", columnPercentage(15));

        addHyperlinkColumn(dataTable, "Detalhes", columnPercentage(15), this::showBorrowingDetails);
        dataTable.getItems().clear();
        dataTable.getItems().addAll(borrowingDAOList.getOnlyBorrowed());

        sortTableBy(dataTable, 0);
    }

    @FXML
    protected void onReservationsClicked() throws IOException, ClassNotFoundException {

        setMenu("reservations");

        BorrowingDAOList borrowingDAOList = new BorrowingDAOList();
        borrowingDAOList.loadDatFile();
        dataTable.getColumns().clear();

        addTableColumn(dataTable, "ID", "id", columnPercentage(6));

        // Create a custom Callback for the ID of the Reader
        Callback<TableColumn.CellDataFeatures<Borrowing, String>, ObservableValue<String>> readerNameCallback = param ->
                new ReadOnlyObjectWrapper<>(param.getValue().getReader().getName()).asString();

        addTableColumnWithCallback(dataTable, "Leitor", "readerName", columnPercentage(20), readerNameCallback);

        Callback<TableColumn.CellDataFeatures<Borrowing, String>, ObservableValue<String>> bookTitleCallback = param ->
                new ReadOnlyObjectWrapper<>(param.getValue().getBook().getTitle()).asString();

        addTableColumnWithCallback(dataTable, "Livro", "bookTitle", columnPercentage(28), bookTitleCallback);

        addTableColumn(dataTable, "Data", "loanDate", columnPercentage(15));
        addTableColumn(dataTable, "Devolução", "dueDate", columnPercentage(15));

        addHyperlinkColumn(dataTable, "Cancelar", columnPercentage(15), this::cancelReservation);
        dataTable.getItems().clear();
        dataTable.getItems().addAll(borrowingDAOList.getOnlyReserved());

        sortTableBy(dataTable, 0);
    }

    @FXML
    protected void onStatisticsClicked() {
        setMenu("statistics");
    }

    @FXML
    protected void onLogoutClicked() {
        GlobalData.setLoggedUser(null);
        LoginView.show();
    }

    @FXML
    protected void onSearchClicked() {

    }

    @FXML
    protected void onAddClicked() {
        switch (currentMenu) {
            case "books" -> AddBookView.show();
            case "borrowing" -> AddBorrowingView.show();
        }
    }

    private void showUserDetails(BaseUser user) {
        ProfileView.show(user);
    }

    private void showBookDetails(Book book) {
        BooksView.show(book);
    }

    private void showBorrowingDetails(Borrowing borrowing) {
        BorrowingView.show(borrowing);
    }

    private void cancelReservation(Borrowing borrowing){

    }

    private void setMenu(String menu) {
        switch (menu) {
            case "books" -> {
                currentMenu = "books";
                setSelectedBackgroundBtn(backgroundBookBtn);
                pageTitleLabel.setText("Livros");
                boolean loggedUserIsLibrarianOrAdmin = GlobalData.getLoggedUser().getRole() == Role.LIBRARIAN || GlobalData.getLoggedUser().getRole() == Role.ADMIN;
                addButton.setVisible(loggedUserIsLibrarianOrAdmin);
                addButton.setDisable(!loggedUserIsLibrarianOrAdmin);
            }
            case "users" -> {
                currentMenu = "users";
                setSelectedBackgroundBtn(backgroundUsersBtn);
                pageTitleLabel.setText("Usuários");
                addButton.setVisible(false);
                addButton.setDisable(true);
            }
            case "borrowing" -> {
                currentMenu = "borrowing";
                setSelectedBackgroundBtn(backgroundBorrowingBtn);
                pageTitleLabel.setText("Empréstimos");
                addButton.setVisible(true);
                addButton.setDisable(false);
            }
            case "reservations" -> {
                currentMenu = "reservations";
                setSelectedBackgroundBtn(backgroundReservationsBtn);
                pageTitleLabel.setText("Reservas");
                addButton.setVisible(false);
                addButton.setDisable(true);
            }
            case "statistics" -> {
                currentMenu = "statistics";
                setSelectedBackgroundBtn(backgroundStatisticsBtn);
                pageTitleLabel.setText("Estatísticas");
                addButton.setVisible(false);
                addButton.setDisable(true);
            }
        }
    }

    private void forceClick(String where) throws IOException, ClassNotFoundException {
        switch (where) {
            case "books" -> onBooksClicked();
            case "users" -> onUsersClicked();
            case "borrowing" -> onBorrowingClicked();
            case "reservations" -> onReservationsClicked();
            case "statistics" -> onStatisticsClicked();
        }
    }

    private void setSelectedBackgroundBtn(Rectangle target) {
        backgroundBookBtn.setFill(javafx.scene.paint.Color.web("#223a4e"));
        backgroundUsersBtn.setFill(javafx.scene.paint.Color.web("#223a4e"));
        backgroundBorrowingBtn.setFill(javafx.scene.paint.Color.web("#223a4e"));
        backgroundReservationsBtn.setFill(javafx.scene.paint.Color.web("#223a4e"));
        backgroundStatisticsBtn.setFill(javafx.scene.paint.Color.web("#223a4e"));
        target.setFill(javafx.scene.paint.Color.web("#58a1dd"));
    }

    private <S, T> void addHyperlinkColumn(TableView<S> table, String columnName, Integer width, Consumer<S> onHyperlinkClicked){
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

    private <S, T> void addTableColumnWithCallback(TableView<S> table, String columnName, String property, Integer width, Callback<TableColumn.CellDataFeatures<S, T>, ObservableValue<T>> callback) {
        TableColumn<S, T> column = new TableColumn<>(columnName);
        column.setCellValueFactory(callback);
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
