package sample;

import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Ellipse;

public class SubjectDataController {
    @FXML StackPane subjectDetailStackPane;
    @FXML Label iconLabel;
    @FXML Label subjectIdLabel;
    @FXML Label subjectNameLabel;
    @FXML Label difficultLevelLabel;
    @FXML Label creditLabel;
    @FXML CheckBox subjectPassedCheckbox;
    @FXML Ellipse iconEllipse;
    private Subject subject;

    @FXML
    public void initialize() {
    }

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
}