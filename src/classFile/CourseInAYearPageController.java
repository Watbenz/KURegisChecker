package classFile;

import classFile.changePage.Page;
import classFile.subject.SubjectIO;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class CourseInAYearPageController {
    @FXML private Stage stage;
    @FXML private VBox termVBox;
    private String status;
    private SubjectIO subjectIO;

    @FXML
    public void initialize() {
        Platform.runLater(this::loadTermItems);
    }

    private void loadTermItems() {
        for (int i=1; i<=2; i++) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("../fxml/termSubjectData.fxml"));
                Parent root = loader.load();
                termVBox.getChildren().add(root);
                TermSubjectDataController controller = loader.getController();
                controller.setStage(stage);
                controller.setSubjectIO(subjectIO);
                controller.setStatus(status + "_" + i);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    private void backToPrevious() {
        try {
            FXMLLoader loader = Page.loadPage(stage, getClass().getResource("../fxml/chooseYearPage.fxml"));
            ChooseYearPageController controller = loader.getController();
            controller.setStage(stage);
            controller.setSubjectIO(subjectIO);
        } catch (IOException e) {
            e.printStackTrace();
        }
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
