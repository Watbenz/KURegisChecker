package application.detailPage;

import application.detailPage.previousDisplay.PreviousDisplayController;
import application.subject.Subject;
import application.subject.SubjectIO;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Ellipse;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class DetailsPageController {
    @FXML private Stage stage;
    @FXML private Ellipse iconEllipse;
    @FXML private Label subjectNameLabel;
    @FXML private Label iconLabel;
    @FXML private Label detailLabel;
    @FXML private Label creditLabel;
    @FXML private Label yearAndTermLabel;
    @FXML private Label subjectIDLabel;
    @FXML private HBox displayHBox;
    @FXML private ImageView logoImageView;
    private Subject subject;
    private SubjectIO subjectIO;

    @FXML
    public void initialize() {
        logoImageView.setImage(new Image("/image/logo.png"));
        Platform.runLater(this::update);
    }

    private void update() {

        iconEllipse.setFill(subject.getDifficultLevel().getLinearColor());
        iconEllipse.setStroke(subject.getDifficultLevel().getColor());

        yearAndTermLabel.setText("(ปี " + subject.getYear() + " เทอม " + subject.getTerm() +")");
        subjectNameLabel.setText(subject.getName());
        subjectIDLabel.setText(subject.getSubjectId());
        iconLabel.setText(subject.getIcon());
        detailLabel.setText(subject.getDetail());
        creditLabel.setText(subject.getCredit() + " หน่วยกิต");
        addSubjectItems();

    }

    private void addPreviousSubjectItems() {
        loadSubjectItem(subjectIO.getPreviousAsArrayList(subject), "วิชาก่อนหน้า");
    }

    private void addNextSubjectItems() {
        loadSubjectItem(subjectIO.getNextAsArrayList(subject), "วิชาถัดไป");
    }

    private void loadSubjectItem(ArrayList<Subject> arrayList, String labelText) {
        VBox vBox = new VBox();

        if (!arrayList.isEmpty()) {
            vBox.getChildren().addAll(new Label(labelText));
        }
        for (Subject eachNext: arrayList) {
            vBox.getChildren().add(loadDisplay(eachNext));
        }
        displayHBox.getChildren().addAll(vBox);
    }

    private void addSubjectItems() {
        addPreviousSubjectItems();
        addNextSubjectItems();
    }

    private Parent loadDisplay(Subject subject) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/detailPage/previousDisplay/previousDisplay.fxml"));
            Parent root = loader.load();
            PreviousDisplayController controller = loader.getController();
            controller.setSubject(subject);
            controller.setSubjectIO(subjectIO);
            controller.setStage(stage);

            return root;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
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

    @FXML
    public void closePopup() {
        stage.close();
    }
}
