package classFile;

import classFile.subject.Subject;
import classFile.subject.SubjectIO;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.stage.Stage;

import java.io.IOException;

public class PreviousDisplayController {
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
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../fxml/detailsPage.fxml"));
            Stage popup = new Stage();
            Parent root = loader.load();
            popup.setScene(new Scene(root, 500, 500));
            popup.setTitle("Subject detail");

            DetailsPageController controller = loader.getController();
            controller.setStage(popup);
            controller.setSubject(subject);
            controller.setSubjectIO(subjectIO);

            popup.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
