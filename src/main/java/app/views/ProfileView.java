package app.views;

import app.Main;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

import java.io.IOException;

public class ProfileView {
    public static void show() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(ProfileView.class.getResource("/app/profile.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Main.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
