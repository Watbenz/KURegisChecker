package application.detailPage;

import application.changePage.OpenDetailPopup;
import application.subject.Subject;
import application.subject.SubjectIO;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.stage.Stage;

public class PreviousDisplayController {
    private Stage stage;
    @FXML private Ellipse iconEllipse;
    @FXML private Label iconLabel;
    @FXML private Label subjectIdLabel;
    @FXML private Label statusLabel;
    private Subject subject;
    private SubjectIO subjectIO;

    @FXML
    public void initialize() {
        Platform.runLater(this::update);
    }

    private void update() {
        Platform.runLater(() -> {
            iconEllipse.setFill(subject.getDifficultLevel().getLinearColor());
        });
        iconLabel.setText(subject.getIcon());
        subjectIdLabel.setText(subject.getSubjectId());

        if (subject.isFinish()) {
            statusLabel.setText("✓");
            statusLabel.setTextFill(Color.web("#007D47"));
        }
        else {
            statusLabel.setText("X");
            statusLabel.setTextFill(Color.web("#A10719"));
        }
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public void setSubjectIO(SubjectIO subjectIO) {
        this.subjectIO = subjectIO;
    }

    @FXML
    private void openDetail(){
        new OpenDetailPopup(subject).open(stage, subjectIO);
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }
}
