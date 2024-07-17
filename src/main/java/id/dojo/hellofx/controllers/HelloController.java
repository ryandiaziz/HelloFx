package id.dojo.hellofx.controllers;

import id.dojo.hellofx.HelloApplication;
import id.dojo.hellofx.models.Data;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    @FXML
    private TextField weightTextField;
    @FXML
    private TextField heighText;
    @FXML
    private Button listButton;

    @FXML
    protected void onHelloButtonClick(ActionEvent event) {
        if (weightTextField.getText().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Warning");
            alert.setContentText("Isi bagian weight");
            alert.show();
            return;
        }

        if (heighText.getText().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Warning");
            alert.setContentText("Isi bagian height");
            alert.show();
            return;
        }

        int weight = Integer.parseInt(weightTextField.getText());
        int height = Integer.parseInt(heighText.getText());
        String res = "";

        float tinggiMeter = (float) height/100;

        float bmi = (weight / (tinggiMeter*tinggiMeter));

        if(bmi<18.5){
            Data.res = "BMI kamu adalah " + bmi + ". Berat badan kurang.";
        }else if(bmi <25){
            Data.res = "BMI kamu adalah " + bmi + ". Berat badan normal.";
        }else if(bmi<30){
            Data.res = "BMI kamu adalah " + bmi + ". Berat badan berlebih.";
        }else{
            Data.res = "BMI kamu adalah " + bmi + ". Berat badan obesitas!.";
        }

        goToMessageView(event);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        listButton.setOnAction(event -> {
            goToListView(event);
        });
    }

    private void goToMessageView(ActionEvent event){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("fxml/message-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setTitle("Message Page");
            stage.setScene(scene);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void goToListView(ActionEvent event){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("fxml/list-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setTitle("List Page");
            stage.setScene(scene);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}