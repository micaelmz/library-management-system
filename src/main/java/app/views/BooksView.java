package app.views;

import app.Main;
import app.controllers.BookController;
import app.model.Book;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

import java.io.IOException;

public class BooksView {
    public static void show(Book book) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(ProfileView.class.getResource("/app/book.fxml"));
            Scene scene = new Scene(fxmlLoader.load());

            BookController bookController = fxmlLoader.getController();
            bookController.initData(book);

            Main.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
