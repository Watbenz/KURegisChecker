package classFile;

import classFile.changePage.Page;
import classFile.subject.Subject;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
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
    public void initialize() {
        Platform.runLater(this::readJsonFile);
    }
    private void readJsonFile() {
        Gson gson = new Gson();
        try {
            BufferedReader reader = new BufferedReader(new FileReader("subjectData.json"));
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
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../fxml/subjectData.fxml"));
            Parent root = loader.load();
            SubjectDataController subjectDataController = loader.getController();
            subjectDataController.setStage(stage);
            subjectDataController.setAllNode(subject);
            return root;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @FXML
    private void backToPrevious() {
        try {
            FXMLLoader loader = Page.changeToPage(stage, getClass().getResource("../fxml/chooseYearPage.fxml"));
            ChooseYearPageController controller = loader.getController();
            controller.setStage(stage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }
}
