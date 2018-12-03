package classFile;

import classFile.changePage.OpenChooseYearPage;
import classFile.subject.SubjectIO;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
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
            loadItemFromFile(new TermSubjectDataController(), status + "_" + i);
        }
    }

    protected void loadItemFromFile(TermSubjectDataController controller, String status) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../fxml/termSubjectData.fxml"));

            loader.setController(controller);
            Parent root = loader.load();

            termVBox.getChildren().add(root);
            controller.setStage(stage);
            controller.setSubjectIO(subjectIO);
            controller.setStatus(status);
            controller.setUpdateCallback(this::update);

            allController.add(controller);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void backToPrevious() {
        new OpenChooseYearPage().open(stage, subjectIO);
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
