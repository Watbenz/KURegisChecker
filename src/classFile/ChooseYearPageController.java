package classFile;

import classFile.changePage.OpenCourseInAYear;
import classFile.changePage.OpenMainPage;
import classFile.subject.SubjectIO;
import javafx.fxml.FXML;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class ChooseYearPageController {
    @FXML private Stage stage;
    @FXML private StackPane year1, year2, year3, year4;
    private SubjectIO subjectIO;

    @FXML
    public void initialize() {
        setOnClickStackPane(year1);
        setOnClickStackPane(year2);
        setOnClickStackPane(year3);
        setOnClickStackPane(year4);
    }

    private void setOnClickStackPane(StackPane stackPane) {
        stackPane.setOnMouseClicked(event -> openCourseInAYear(stackPane.getId()));
    }

    private void openCourseInAYear(String status) {
        OpenCourseInAYear chooseYearPage = new OpenCourseInAYear(new CourseInAYearPageController(), status);
        chooseYearPage.open(stage, subjectIO);
    }

    @FXML
    private void backToPrevious() {
        new OpenMainPage().open(stage, subjectIO);
    }

    public void setSubjectIO(SubjectIO subjectIO) {
        this.subjectIO = subjectIO;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }
}
