package sample;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CourseInAYearPageController {
    @FXML Stage stage;
    @FXML VBox displayDataSubjectVbox;
    @FXML
    StackPane backTo;

    @FXML
    public void initialize() {
        backToPage();
        readJsonFile();
    }

    private void readJsonFile() {
        Gson gson = new Gson();
        try {
            BufferedReader reader = new BufferedReader(new FileReader("SubjectData.json"));
            JsonArray jsonArray = gson.fromJson(reader, JsonArray.class);

            for (int i=0; i<jsonArray.size(); i++) {
                JsonElement jsonElement = jsonArray.get(i);
                Subject subject = gson.fromJson(jsonElement, Subject.class);

                displayDataSubjectVbox.getChildren().addAll(readSubjectDataStackPane(subject));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private Parent readSubjectDataStackPane(Subject subject) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("subjectData.fxml"));
            Parent root = loader.load();
            SubjectDataController subjectDataController = loader.getController();
            subjectDataController.setAllNode(subject);
            return root;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private void backToPage(){
        backTo.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("chooseYearPage.fxml"));
                    Parent root = loader.load();
                    stage.setScene(new Scene(root, 800, 600));

                    ChooseYearPageController controller = loader.getController();
                    controller.setStage(stage);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }
}
