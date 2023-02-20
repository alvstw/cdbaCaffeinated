module com.CDBA.Caffeinated {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.CDBA.Caffeinated to javafx.fxml;
    exports com.CDBA.Caffeinated;
}