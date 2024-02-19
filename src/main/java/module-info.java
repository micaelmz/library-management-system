module app.main {
    requires javafx.controls;
    requires javafx.fxml;
    requires junit;
    requires org.kordamp.bootstrapfx.core;

    opens app to javafx.fxml;
    exports app;

    opens app.controllers to javafx.fxml;
    exports app.controllers;

    opens app.model to javafx.fxml;
    exports app.model;

    opens app.views to javafx.fxml;
    exports app.views;

    opens test to junit;
    exports test;

    opens test.dao to junit;
    exports test.dao;

    opens test.model to junit;
    exports test.model;
}