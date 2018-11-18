package classFile;

import ChangePage.Page;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
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
    @FXML private CheckBox subjectPassedCheckbox;
    @FXML private Ellipse iconEllipse;
    private Subject subject;

    public void setAllNode(Subject subject) {
        this.subject = subject;
        iconLabel.setText(subject.getIcon());
        subjectIdLabel.setText(subject.getSubjectId());
        subjectNameLabel.setText(subject.getName());
        difficultLevelLabel.setText("ระดับความยาก : " + subject.getDifficultLevel());
        creditLabel.setText(subject.getCredit() + " หน่วยกิต");
        subjectPassedCheckbox.setAllowIndeterminate(subject.isFinish());

        iconEllipse.setFill(subject.getDifficlutLevelColor());
        iconEllipse.setStroke(subject.getDifficlutLevelColor());
        difficultLevelLabel.setTextFill(subject.getDifficlutLevelColor());
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @FXML
    private void goToDetail(){
        try {
            FXMLLoader loader = Page.changeToPage(stage, getClass().getResource("../fxml/detailsPage.fxml"));
            DetailsPageController controller = loader.getController();
            controller.setStage(stage);
            controller.setSubject(subject);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}