module interfaz.mobimedline_sistema {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens interfaz.mobimedlinesistema.controller to javafx.fxml;
    exports interfaz.mobimedlinesistema.app;

}
