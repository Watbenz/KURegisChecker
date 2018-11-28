package classFile;

import classFile.changePage.Page;
import classFile.subject.Subject;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.shape.Ellipse;
import javafx.stage.Stage;

import java.io.IOException;

public class SubjectDataController {
    private Stage stage;
    @FXML private Label iconLabel;
    @FXML private Label subjectIdLabel;
    @FXML private Label subjectNameLabel;
    @FXML private Label difficultLevelLabel;
    @FXML private Label creditLabel;
    @FXML private Ellipse iconEllipse;
    private Subject subject;

    public void setAllNode(Subject subject) {
        this.subject = subject;
        iconLabel.setText(subject.getIcon());
        subjectIdLabel.setText(subject.getSubjectId());
        subjectNameLabel.setText(subject.getName());
        difficultLevelLabel.setText("ระดับความยาก : " + subject.getDifficultLevel().getLevel());
        creditLabel.setText(subject.getCredit() + " หน่วยกิต");
//        subjectPassedCheckbox.setAllowIndeterminate(subject.isFinish());

        iconEllipse.setFill(subject.getDifficultLevel().getLinearColor());
        iconEllipse.setStroke(subject.getDifficultLevel().getLinearColor());
        difficultLevelLabel.setTextFill(subject.getDifficultLevel().getColor());
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @FXML
    private void openDetail(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../fxml/detailsPage.fxml"));
            Stage popup = new Stage();
            Parent root = loader.load();
            popup.setScene(new Scene(root, 500, 500));
            popup.setTitle("Subject detail");

            DetailsPageController controller = loader.getController();
            controller.setStage(popup);
            controller.setSubject(subject);

            popup.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}