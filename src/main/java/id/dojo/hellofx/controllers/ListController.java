package id.dojo.hellofx.controllers;

import id.dojo.hellofx.HelloApplication;
import id.dojo.hellofx.models.Todo;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ListController implements Initializable{
    @FXML
    private Button backButtonList;
    @FXML
    private TableView<Todo> todoTable;
    @FXML
    private TableColumn<Todo, String> activityColumn;

    private ObservableList<Todo> todoData = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        todoData.add(new Todo("Bangun"));
        todoData.add(new Todo("Sarapan"));
        todoData.add(new Todo("Ngopi"));

        todoTable.setItems(todoData);
        activityColumn.setCellValueFactory(cellData -> cellData.getValue().getActivity());


        backButtonList.setOnAction(event -> {
            goToHomeView(event);
        });
    }

    private void goToHomeView(ActionEvent event){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("fxml/hello-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setTitle("Hello!");
            stage.setScene(scene);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
