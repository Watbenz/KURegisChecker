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
    private SubjectIO subjectIO;
    private int year;
    private int term;

    @FXML
    public void initialize() {
        Platform.runLater(() -> {
            findYearFromStatus();
            semesterLabel.setText("ชั้นปีที่ " + year + " เทอม " + term);
            numberTermLabel.setText("" + term);
            addSubjectItems();
        });
    }

    private void findYearFromStatus() {
        for (int i=0; i<status.length(); i++) {
            if (status.charAt(i) == '_') {
                this.year = Integer.parseInt("" + status.charAt(i-1));
                this.term = Integer.parseInt("" + status.charAt(i+1));
                break;
            }
        }
    }

    private void addSubjectItems() {
        ArrayList<Subject> subjects = subjectIO.getSubjectInTerm(year, term);
        for (Subject each: subjects) {
            displayDataSubjectVbox.getChildren().addAll(loadSubjectData(each));
        }
    }

    private Parent loadSubjectData(Subject subject) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../fxml/subjectData.fxml"));
            Parent root = loader.load();
            SubjectDataController controller = loader.getController();
            controller.setStage(stage);
            controller.setSubject(subject);
            controller.setSubjectIO(subjectIO);

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

    public void setSubjectIO(SubjectIO subjectIO) {
        this.subjectIO = subjectIO;
    }
}
