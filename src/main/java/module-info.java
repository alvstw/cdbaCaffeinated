module com.alvstw.mousemover {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.alvstw.mousemover to javafx.fxml;
    exports com.alvstw.mousemover;
}