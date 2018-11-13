package classFile;

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
    @FXML private StackPane subjectDetailStackPane;
    @FXML private Label iconLabel;
    @FXML private Label subjectIdLabel;
    @FXML private Label subjectNameLabel;
    @FXML private Label difficultLevelLabel;
    @FXML private Label creditLabel;
    @FXML private CheckBox subjectPassedCheckbox;
    @FXML private Ellipse iconEllipse;
    private Subject subject;

    @FXML
    public void initialize() {
        goToDetail();
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

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    private void goToDetail(){
        subjectDetailStackPane.setOnMouseClicked(new EventHandler<>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("../fxml/detailsPage.fxml"));
                    Parent root = loader.load();

                    stage.setScene(new Scene(root, 800, 600));
                    DetailsPageController controller = loader.getController();
                    controller.setStage(stage);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

}