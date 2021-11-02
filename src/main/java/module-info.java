module com.example.aventurasdemarcoyluis {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.aventurasdemarcoyluis to javafx.fxml;
    exports com.example.aventurasdemarcoyluis.model;
    opens com.example.aventurasdemarcoyluis.model to javafx.fxml;
    exports com.example.aventurasdemarcoyluis.model.items;
    opens com.example.aventurasdemarcoyluis.model.items to javafx.fxml;
    exports com.example.aventurasdemarcoyluis.model.players to javafx.fxml;
    exports com.example.aventurasdemarcoyluis.model.enemies;
    opens com.example.aventurasdemarcoyluis.model.enemies to javafx.fxml;
}