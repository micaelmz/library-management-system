module app.main {
    requires javafx.controls;
    requires javafx.fxml;
    requires junit;

    opens app to javafx.fxml;
    exports app;
    exports app.controllers;
    opens app.controllers to javafx.fxml;
}