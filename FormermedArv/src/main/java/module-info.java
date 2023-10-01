module com.tong3.formermedarv {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.tong3.formermedarv to javafx.fxml;
    exports com.tong3.formermedarv;
}