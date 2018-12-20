package application.mainPage;

import application.courseInAYearPage.ResultPageController;
import application.changePage.OpenChooseYearPage;
import application.changePage.OpenCourseInAYear;
import application.subject.SubjectIO;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class MainPageController {
    @FXML private Stage stage;
    @FXML private ImageView logoImageView;
    private SubjectIO subjectIO;

    @FXML
    public void initialize() {
        logoImageView.setImage(new Image("/image/logo.png"));
    }

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
