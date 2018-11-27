package classFile;

import ChangePage.Page;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Ellipse;
import javafx.stage.Stage;

import java.io.IOException;

public class DetailsPageController {
    @FXML private Stage stage;
    @FXML private Ellipse iconEllipse;
    @FXML private Label semisterLabel;
    @FXML private Label subjectNameLabel;
    @FXML private Label iconLabel;
    @FXML private Label detailLabel;
    @FXML private Label difficultLevelLabel;
    @FXML private Label creditLabel;
    @FXML private ImageView subjectMapImageView;
    private Subject subject;

    @FXML
    public void initialize() {
        Platform.runLater(this::setAllNode);
    }

    private void setAllNode() {
        iconEllipse.setFill(subject.getDifficultLevel().getLinearColor());
        iconEllipse.setStroke(subject.getDifficultLevel().getColor());

        subjectNameLabel.setText(subject.getName());
        iconLabel.setText(subject.getIcon());
        detailLabel.setText(subject.getDetail());
        difficultLevelLabel.setText("ระดับความยาก : " + subject.getDifficultLevel().getLevel());
        creditLabel.setText(subject.getCredit() + " หน่วยกิต");
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    @FXML
    public void goToPrevious() {
        try {
            FXMLLoader loader = Page.changeToPage(stage, getClass().getResource("../fxml/courseInAYearPage.fxml"));
            CourseInAYearPageController controller = loader.getController();
            controller.setStage(stage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
