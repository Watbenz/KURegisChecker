package application.chooseYearPage;

import application.courseInAYearPage.CourseInAYearPageController;
import application.changePage.OpenCourseInAYear;
import application.changePage.OpenMainPage;
import application.subject.SubjectIO;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.File;

public class ChooseYearPageController {
    @FXML private Stage stage;
    @FXML private StackPane year1, year2, year3, year4;
    @FXML private ImageView logoImageView;
    private SubjectIO subjectIO;

    @FXML
    public void initialize() {
        logoImageView.setImage(new Image("/image/logo.png"));
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
