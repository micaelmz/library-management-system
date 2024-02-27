package app.views;

import app.controllers.DashboardController;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;

import java.io.IOException;
import app.Main;

public class DashboardView {
    public static void show(String menu) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(RegisterView.class.getResource("/app/dashboard.fxml"));
            Scene scene = new Scene(fxmlLoader.load());

            DashboardController dashboardController = fxmlLoader.getController();
            dashboardController.initData(menu);

            Main.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}

