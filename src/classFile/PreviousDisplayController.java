package classFile;

import classFile.subject.Subject;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;

public class PreviousDisplayController {
    @FXML private Ellipse iconEllipse;
    @FXML private Label iconLabel;
    @FXML private Label subjectIdLabel;
    @FXML private Label statusLabel;
    private Subject subject;

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
}
