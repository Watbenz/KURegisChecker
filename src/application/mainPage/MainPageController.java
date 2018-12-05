package application;

import application.changePage.OpenChooseYearPage;
import application.changePage.OpenCourseInAYear;
import application.subject.SubjectIO;
import javafx.fxml.FXML;
import javafx.stage.Stage;

public class MainPageController {
    @FXML private Stage stage;
    private SubjectIO subjectIO;

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void setSubjectIO(SubjectIO subjectIO) {
        this.subjectIO = subjectIO;
    }

    @FXML
    public void goToChooseYearPage() {
        new OpenChooseYearPage().open(stage, subjectIO);
    }

    @FXML
    public void goToResultPage() {
        OpenCourseInAYear courseInAYear = new OpenCourseInAYear(new ResultPageController(), "NONE");
        courseInAYear.open(stage, subjectIO);
    }
}
