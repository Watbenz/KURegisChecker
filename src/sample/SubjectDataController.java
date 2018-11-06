package sample;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;

public class SubjectDataController {
    @FXML StackPane subjectDetailStackPane;
    @FXML Label iconLabel;
    @FXML Label subjectIdLabel;
    @FXML Label subjectNameLabel;
    @FXML Label difficultLevelLabel;
    @FXML Label creditLabel;
    @FXML CheckBox subjectPassedCheckbox;
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
    }

    public Label getNameLabel() {
        return subjectNameLabel;
    }

    public ObservableList<Node> getChildren() {
        return subjectDetailStackPane.getChildren();
    }
}