module com.champlain.oop2a1 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.champlain.oop2a1 to javafx.fxml;
    exports com.champlain.oop2a1;
}