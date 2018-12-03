package classFile.changePage;

import classFile.DetailsPageController;
import classFile.subject.Subject;
import classFile.subject.SubjectIO;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class OpenDetailPopup implements Page {
    private Subject subject;

    public OpenDetailPopup(Subject subject) {
        this.subject = subject;
    }

    @Override
    public void open(Stage stage, SubjectIO subjectIO) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../../fxml/detailsPage.fxml"));
            Parent root = loader.load();
            stage.setScene(new Scene(root, 500, 500));
            stage.setTitle("Subject detail");

            DetailsPageController controller = loader.getController();
            controller.setStage(stage);
            controller.setSubject(subject);
            controller.setSubjectIO(subjectIO);

            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
