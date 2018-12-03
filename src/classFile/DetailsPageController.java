package classFile;

import classFile.subject.Subject;
import classFile.subject.SubjectIO;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;

public class DetailsPageController {
    @FXML private Stage stage;
    @FXML private Ellipse iconEllipse;
    @FXML private Label subjectNameLabel;
    @FXML private Label iconLabel;
    @FXML private Label detailLabel;
    @FXML private Label creditLabel;
    @FXML private HBox displayPreviousHBox;
//    @FXML private VBox displayPreviousVBox;
    private Subject subject;
    private SubjectIO subjectIO;

    @FXML
    public void initialize() {
        Platform.runLater(this::update);
    }

    private void update() {
        iconEllipse.setFill(subject.getDifficultLevel().getLinearColor());
        iconEllipse.setStroke(subject.getDifficultLevel().getColor());

        subjectNameLabel.setText(subject.getName());
        iconLabel.setText(subject.getIcon());
        detailLabel.setText(subject.getDetail());
        creditLabel.setText(subject.getCredit() + " หน่วยกิต");
        addSubjectItems();

    }

    private ArrayList<Subject> getPrevious() {
        ArrayList<Subject> allSubjectPrevious = subjectIO.getPreviousAsArrayList(subject);
        Collections.reverse(allSubjectPrevious);

        return allSubjectPrevious;
    }

    private void addSubjectItems() {
        VBox previousBox = new VBox();
        for (Subject eachPrevious: getPrevious()) {
            previousBox.getChildren().add(loadDisplayPrevious(eachPrevious));
        }
        displayPreviousHBox.getChildren().add(previousBox);

        displayPreviousHBox.getChildren().add(new VBox(loadDisplayPrevious(subject)));
    }

    private Parent loadDisplayPrevious(Subject subject) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../fxml/previousDisplay.fxml"));
            Parent root = loader.load();
            PreviousDisplayController controller = loader.getController();
            controller.setSubject(subject);
            controller.setSubjectIO(subjectIO);

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
