package app.views;

import app.controllers.FinishRegisterController;
import app.model.BaseUser;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;

import java.io.IOException;

import app.Main;

public class FinishRegisterView {
    public static void show(BaseUser user) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(RegisterView.class.getResource("/app/registerFinish.fxml"));
            Scene scene = new Scene(fxmlLoader.load());

            FinishRegisterController finishRegisterController = fxmlLoader.getController();
            finishRegisterController.initData(user);

            Main.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

