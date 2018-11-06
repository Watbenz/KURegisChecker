package sample;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;

public class CourseInAYearPageController {
    @FXML Stage stage;
    @FXML VBox displayDataSubjectVbox;
    @FXML AnchorPane dataSubjectAnchorPane;
    @FXML Label iconLabel;
    @FXML Label subjectIdLabel;
    @FXML Label subjectNameLabel;
    @FXML Label difficultLevelLabel;
    @FXML Label creditLabel;

    public CourseInAYearPageController() {
    }

    @FXML
    public void initialize() {
        readJsonFile();
    }

    private void readJsonFile() {
        Gson gson = new Gson();
        try {
            BufferedReader reader = new BufferedReader(new FileReader("subjectData.json"));
            JsonArray jsonArray = gson.fromJson(reader, JsonArray.class);

            for (int i=0; i<jsonArray.size(); i++) {
                JsonElement jsonElement = jsonArray.get(i);
                Subject subject = gson.fromJson(jsonElement, Subject.class);

                iconLabel.setText(subject.getIcon());
                subjectIdLabel.setText(subject.getSubjectId());
                subjectNameLabel.setText(subject.getName());
                difficultLevelLabel.setText("ระดับความยาก : " + subject.getDifficultLevel());
                creditLabel.setText(subject.getCredit() + " หน่วยกิต");

                AnchorPane anchorPane = new AnchorPane();
                anchorPane.getChildren().addAll(dataSubjectAnchorPane.getChildren());

                displayDataSubjectVbox.getChildren().addAll(anchorPane);
                System.out.println(subject.getName());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }
}
