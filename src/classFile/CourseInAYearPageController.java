package classFile;

import classFile.changePage.Page;
import classFile.subject.Subject;
import classFile.subject.SubjectIO;
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
import java.util.ArrayList;

public class CourseInAYearPageController {
    @FXML Stage stage;
    @FXML VBox displayDataSubjectVbox;

    @FXML
    public void initialize() {
        Platform.runLater(this::readJsonFile);
    }

    private void readJsonFile() {
        ArrayList<Subject> subjects = SubjectIO.readSubject("subjectData.json");
        for (Subject each: subjects) {
            displayDataSubjectVbox.getChildren().addAll(readSubjectDataStackPane(each));
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
