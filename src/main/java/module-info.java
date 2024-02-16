module app.main {
    requires javafx.controls;
    requires javafx.fxml;
    requires junit;

    opens app to javafx.fxml;
    exports app;

    opens app.controllers to javafx.fxml;
    exports app.controllers;

    opens test to junit;
    exports test;

    opens test.dao to junit;
    exports test.dao;

    opens test.model to junit;
    exports test.model;
}