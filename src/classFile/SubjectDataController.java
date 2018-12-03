package classFile;

import classFile.changePage.OpenDetailPopup;
import classFile.subject.Subject;
import classFile.subject.SubjectIO;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.stage.Stage;
import org.controlsfx.control.ToggleSwitch;

import java.io.IOException;

public class SubjectDataController {
    @FXML private Stage stage;
    @FXML private Label iconLabel;
    @FXML private Label subjectIdLabel;
    @FXML private Label subjectNameLabel;
    @FXML private Label difficultLevelLabel;
    @FXML private Label creditLabel;
    @FXML private Label passLabel;
    @FXML private Label statusLabel;
    @FXML private Ellipse iconEllipse;
    @FXML private ToggleSwitch addToggleSwitch;
    private Subject subject;
    private SubjectIO subjectIO;
    private Runnable updateCallback;

    @FXML
    public void initialize() {
        Platform.runLater(() -> {
            update();
            setToggleSwitchOnClick();
        });
    }

    private void setToggleSwitchOnClick() {
        addToggleSwitch.setOnMouseClicked(event -> {
            if (!addToggleSwitch.isSelected()) {
                passLabel.setText("ไม่ผ่าน");
                subject.setFinish(false);
            }
            else {
                passLabel.setText("ผ่าน");
                subject.setFinish(true);
            }
            passLabel.setTextFill(Color.BLACK);
            setStatusLabelProperty(subject.isFinish());
            updateCallback.run();
            new Thread(() -> subjectIO.update()).start();
        });
    }

    public void update() {
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

    private void setStatusLabelProperty(boolean isSubjectFinish) {
        if (isSubjectFinish) {
            statusLabel.setText("(ผ่านแล้ว)");
            statusLabel.setTextFill(Color.web("#007D47"));
        }
        else {
            statusLabel.setText("(ยังไม่ผ่าน)");
            statusLabel.setTextFill(Color.web("#A10719"));
        }
    }

    private void checkPreviousSubject(Subject subject) {
        addToggleSwitch.setSelected(subject.isFinish());
        if (subjectIO.isPreviousFinish(subject)) {
            addToggleSwitch.setDisable(false);
            passLabel.setText(subject.isFinish()? "ผ่าน": "ไม่ผ่าน");
            passLabel.setTextFill(Color.BLACK);
            setStatusLabelProperty(subject.isFinish());
        }
        else {
            subjectIO.setPreviousToFalse(subject);
            addToggleSwitch.setDisable(true);
            statusLabel.setText("(กรุณาลงตัวก่อนหน้า)");
            statusLabel.setTextFill(Color.BLACK);
            passLabel.setText("กรุณาลงตัวก่อนหน้า");
            passLabel.setTextFill(Color.web("#A10719"));
        }
    }

    @FXML
    private void openDetail(){
        new OpenDetailPopup(subject).open(new Stage(), subjectIO);
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

    public void setUpdateCallback(Runnable updateCallback) {
        this.updateCallback = updateCallback;
    }
}