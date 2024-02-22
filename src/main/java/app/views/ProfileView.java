package app.views;

import app.Main;
import app.model.BaseUser;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import app.controllers.ProfileController;

import java.io.IOException;

public class ProfileView {
    public static void show(BaseUser user) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(ProfileView.class.getResource("/app/profile.fxml"));
            Scene scene = new Scene(fxmlLoader.load());

            ProfileController profileController = fxmlLoader.getController();
            profileController.initData(user);

            Main.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
