package classFile.changePage;

import classFile.CourseInAYearPageController;
import classFile.subject.SubjectIO;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class OpenCourseInAYear implements Page {
    private CourseInAYearPageController controller;
    private String status;

    public OpenCourseInAYear(CourseInAYearPageController controller, String status) {
        this.controller = controller;
        this.status = status;
    }

    @Override
    public void open(Stage stage, SubjectIO subjectIO) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../../fxml/courseInAYearPage.fxml"));
            loader.setController(controller);

            Parent root = loader.load();
            stage.setScene(new Scene(root, 800, 600));

            controller = loader.getController();
            controller.setStage(stage);
            controller.setSubjectIO(subjectIO);
            controller.setStatus(status);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setController(CourseInAYearPageController controller) {
        this.controller = controller;
    }
}
