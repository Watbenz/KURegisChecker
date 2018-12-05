package classFile.changePage;

import classFile.MainPageController;
import classFile.subject.SubjectIO;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;

import java.io.IOException;

public class OpenMainPage implements Page {
    @Override
    public void open(Stage stage, SubjectIO subjectIO) {
        try {
            FXMLLoader loader = Page.loadPage(stage, getClass().getResource("../../fxml/mainPage.fxml"));
            MainPageController controller = loader.getController();
            controller.setStage(stage);
            controller.setSubjectIO(subjectIO);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
