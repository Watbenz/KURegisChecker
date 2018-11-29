package classFile;

import classFile.subject.Subject;
import classFile.subject.SubjectIO;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class TermSubjectDataController {
    @FXML private Stage stage;
    @FXML private Label numberTermLabel;
    @FXML private Label semesterLabel;
    @FXML private VBox displayDataSubjectVbox;
    private String status;

    @FXML
    public void initialize() {
        Platform.runLater(() -> {
            semesterLabel.setText(formatSemesterLabel(status));
            numberTermLabel.setText("" + status.charAt(status.length()-1));
            addSubjectItems();
        });
    }

    private String formatSemesterLabel(String status) {
        StringBuilder builder = new StringBuilder();
        builder.append("ชั้นปีที่ ");

        for (int i=0; i<status.length(); i++) {
            if (status.charAt(i) == '_') {
                builder.append(status.charAt(i-1));
                builder.append(" เทอม ");
                builder.append(status.charAt(i+1));
                break;
            }
        }
        return builder.toString();
    }

    private void addSubjectItems() {
        ArrayList<Subject> subjects = SubjectIO.readSubject("subjectData.json");
        for (Subject each: subjects) {
            displayDataSubjectVbox.getChildren().addAll(loadSubjectData(each));
        }
    }

    private Parent loadSubjectData(Subject subject) {
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

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
