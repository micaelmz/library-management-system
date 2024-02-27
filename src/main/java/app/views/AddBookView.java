package app.views;

import app.Main;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

import java.io.IOException;

public class AddBookView {
    public static void show() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(RegisterView.class.getResource("/app/addBook.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Main.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
