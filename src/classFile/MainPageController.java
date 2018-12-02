package classFile;

import classFile.changePage.Page;
import classFile.subject.Subject;
import classFile.subject.SubjectIO;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

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
        try {
            FXMLLoader loader = Page.loadPage(stage, getClass().getResource("../fxml/chooseYearPage.fxml"));
            ChooseYearPageController controller = loader.getController();
            controller.setStage(stage);
            controller.setSubjectIO(subjectIO);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void goToResultPage() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../fxml/courseInAYearPage.fxml"));

            ResultPageController controller = new ResultPageController();
            loader.setController(controller);
            Parent root = loader.load();

            stage.setScene(new Scene(root, 800, 600));

            controller = loader.getController();
            controller.setStage(stage);
            controller.setSubjectIO(subjectIO);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
