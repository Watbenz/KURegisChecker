package application.courseInAYearPage.termSubject;

import application.courseInAYearPage.subjectData.SubjectDataController;
import application.subject.Subject;
import application.subject.SubjectIO;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class TermSubjectDataController {
    @FXML private Stage stage;
    @FXML private Label numberTermLabel;
    @FXML private Label semesterLabel;
    @FXML VBox displayDataSubjectVbox;
    String status;
    SubjectIO subjectIO;
    ArrayList<SubjectDataController> allController;
    int year;
    int term;
    Runnable updateCallback;

    @FXML
    public void initialize() {
        Platform.runLater(() -> {
            this.allController = new ArrayList<>();
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

    protected void addSubjectItems() {
        ArrayList<Subject> subjects = subjectIO.getSubjectInTerm(year, term);
        for (Subject each: subjects) {
            displayDataSubjectVbox.getChildren().addAll(loadSubjectData(each));
        }
    }

    public void update() {
        for (SubjectDataController controller: allController) {
            controller.update();
        }
    }

    Parent loadSubjectData(Subject subject) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/courseInAYearPage/subjectData/subjectData.fxml"));
            Parent root = loader.load();
            SubjectDataController controller = loader.getController();
            controller.setStage(stage);
            controller.setSubject(subject);
            controller.setSubjectIO(subjectIO);
            controller.setUpdateCallback(updateCallback);
            allController.add(controller);

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

    public void setUpdateCallback(Runnable updateCallback) {
        this.updateCallback = updateCallback;
    }
}
