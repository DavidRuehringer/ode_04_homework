module com.example.ode_04_homework {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.ode_04_homework to javafx.fxml;
    exports com.example.ode_04_homework;
}