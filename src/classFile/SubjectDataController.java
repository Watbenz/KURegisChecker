package classFile;

import classFile.subject.Subject;
import classFile.subject.SubjectIO;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.shape.Ellipse;
import javafx.stage.Stage;
import org.controlsfx.control.ToggleSwitch;

import java.io.IOException;

public class SubjectDataController {
    private Stage stage;
    @FXML private Label iconLabel;
    @FXML private Label subjectIdLabel;
    @FXML private Label subjectNameLabel;
    @FXML private Label difficultLevelLabel;
    @FXML private Label creditLabel;
    @FXML private Label passLabel;
    @FXML private Ellipse iconEllipse;
    @FXML private ToggleSwitch addToggleSwitch;
    private Subject subject;
    private SubjectIO subjectIO;

    @FXML
    public void initialize() {
        Platform.runLater(() -> {
            setAllNode();
            setToggleSwitchOnClick();
        });
    }

    private void setToggleSwitchOnClick() {
        addToggleSwitch.setOnMouseClicked(event -> {
            if (addToggleSwitch.isSelected()) {
                passLabel.setText("ไม่ผ่าน");
            }
            else {
                passLabel.setText("ผ่าน");
            }
            subject.setFinish(addToggleSwitch.isSelected());
        });
    }

    public void setAllNode() {
        iconLabel.setText(subject.getIcon());
        subjectIdLabel.setText(subject.getSubjectId());
        subjectNameLabel.setText(subject.getName());
        difficultLevelLabel.setText("ระดับความยาก : " + subject.getDifficultLevel().getLevel());
        creditLabel.setText(subject.getCredit() + " หน่วยกิต");
        checkPreviousSubject(subject);

        iconEllipse.setFill(subject.getDifficultLevel().getLinearColor());
        iconEllipse.setStroke(subject.getDifficultLevel().getLinearColor());
        difficultLevelLabel.setTextFill(subject.getDifficultLevel().getColor());
    }

    private void checkPreviousSubject(Subject subject) {
        if (subjectIO.isPreviousFinish(subject)) {
            addToggleSwitch.setSelected(subject.isFinish());
        }
        else {
            addToggleSwitch.setDisable(true);
        }
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

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public void setSubjectIO(SubjectIO subjectIO) {
        this.subjectIO = subjectIO;
    }
}