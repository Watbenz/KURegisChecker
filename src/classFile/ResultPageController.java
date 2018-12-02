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

public class ResultPageController extends CourseInAYearPageController {

    @Override
    protected void loadTermItems() {
        for (int i=1; i<=4; i++) {
            for (int j=1; j<=2; j++) {
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("../fxml/termSubjectData.fxml"));

                    TermSubjectNotFinishController controller = new TermSubjectNotFinishController();
                    loader.setController(controller);
                    Parent root = loader.load();

                    termVBox.getChildren().add(root);
                    controller.setStage(stage);
                    controller.setSubjectIO(subjectIO);
                    controller.setStatus(i + "_" + j);
                    controller.setUpdateCallback(this::update);

                    allController.add(controller);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @FXML
    private void backToPrevious() {
        try {
            FXMLLoader loader = Page.loadPage(stage, getClass().getResource("../fxml/mainPage.fxml"));
            MainPageController controller = loader.getController();
            controller.setStage(stage);
            controller.setSubjectIO(subjectIO);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
