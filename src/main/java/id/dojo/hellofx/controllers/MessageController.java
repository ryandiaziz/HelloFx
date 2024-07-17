package id.dojo.hellofx.controllers;

import id.dojo.hellofx.HelloApplication;
import id.dojo.hellofx.models.Data;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MessageController implements Initializable {
    @FXML
    private Label bmiResult;
    @FXML
    private Button backButton;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        bmiResult.setText(Data.res);
        backButton.setOnAction(event -> {
            goToHomeView(event);
        });
    }

    private void goToHomeView(ActionEvent event){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("fxml/hello-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setTitle("Home Page");
            stage.setScene(scene);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
