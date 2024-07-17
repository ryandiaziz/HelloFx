module id.dojo.hellofx {
    requires javafx.controls;
    requires javafx.fxml;


    opens id.dojo.hellofx to javafx.fxml;
    exports id.dojo.hellofx;
    exports id.dojo.hellofx.controllers;
    opens id.dojo.hellofx.controllers to javafx.fxml;
}