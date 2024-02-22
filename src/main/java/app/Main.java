package app;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import app.views.LoginView;

public class Main extends Application {

    public static Stage stage;
    @Override
    public void start(Stage stage) {
        Main.stage = stage;
        stage.setTitle("SGB!");
        stage.show();
        LoginView.show();
    }

    public static void main(String[] args) {
        launch();
    }

    public static void setScene(Scene scene) {
        stage.setScene(scene);
    }
}