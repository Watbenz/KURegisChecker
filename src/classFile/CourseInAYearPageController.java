package classFile;

import classFile.changePage.Page;
import classFile.subject.SubjectIO;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class CourseInAYearPageController {
    @FXML Stage stage;
    @FXML VBox termVBox;
    String status;
    SubjectIO subjectIO;
    ArrayList<TermSubjectDataController> allController;

    @FXML
    public void initialize() {
        this.allController = new ArrayList<>();
        Platform.runLater(this::loadTermItems);
    }

    @FXML
    public void resetData() {
        subjectIO.resetData();
        subjectIO.update();
        update();
    }

    protected void update() {
        for (TermSubjectDataController controller: allController) {
            controller.update();
        }
    }

    protected void loadTermItems() {
        for (int i=1; i<=2; i++) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("../fxml/termSubjectData.fxml"));

                TermSubjectDataController controller = new TermSubjectDataController();
                loader.setController(controller);
                Parent root = loader.load();

                termVBox.getChildren().add(root);
                controller.setStage(stage);
                controller.setSubjectIO(subjectIO);
                controller.setStatus(status + "_" + i);
                controller.setUpdateCallback(this::update);

                allController.add(controller);
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
