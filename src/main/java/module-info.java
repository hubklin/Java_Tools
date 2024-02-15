module org.example.tools {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;


    opens org.example.tools to javafx.fxml;
    exports org.example.tools;
}