package app.views;

import app.Main;
import app.controllers.BorrowingController;
import app.model.Borrowing;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

import java.io.IOException;

public class BorrowingView {
    public static void show(Borrowing borrowing) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(ProfileView.class.getResource("/app/borrowing.fxml"));
            Scene scene = new Scene(fxmlLoader.load());

            BorrowingController borrowingController = fxmlLoader.getController();
            borrowingController.initData(borrowing);

            Main.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
