module com.example.formermedarv {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.formermedarv to javafx.fxml;
    exports com.example.formermedarv;
}