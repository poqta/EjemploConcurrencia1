module ni.edu.uam.ejemploconcurrencia1 {
    requires javafx.controls;
    requires javafx.fxml;


    opens ni.edu.uam.ejemploconcurrencia1 to javafx.fxml;
    exports ni.edu.uam.ejemploconcurrencia1;
}