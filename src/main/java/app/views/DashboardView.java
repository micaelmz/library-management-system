package app.views;

import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;

import java.io.IOException;
import app.Main;

public class DashboardView {
    public static void show() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(RegisterView.class.getResource("/app/dashboard.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Main.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

