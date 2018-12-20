package application.courseInAYearPage;

import application.courseInAYearPage.termSubject.TermSubjectDataController;
import application.changePage.OpenChooseYearPage;
import application.subject.SubjectIO;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;

public class CourseInAYearPageController {
    @FXML Stage stage;
    @FXML VBox termVBox;
    @FXML private ImageView logoImageView;
    String status;
    SubjectIO subjectIO;
    ArrayList<TermSubjectDataController> allController;

    @FXML
    public void initialize() {
        logoImageView.setImage(new Image("/image/logo.png"));
        this.allController = new ArrayList<>();
        Platform.runLater(this::loadTermItems);
    }

    public void resetData() {
        ButtonType yesButton = new ButtonType("ใช่", ButtonBar.ButtonData.YES);
        ButtonType noButton = new ButtonType("ไม่", ButtonBar.ButtonData.NO);
        Alert alert = new Alert(Alert.AlertType.WARNING,
                "คุณต้องการที่จะรีเซ็ตข้อมูลทั้งหมดหรือไม่",
                yesButton, noButton);

        alert.setTitle("รีเซ็ตข้อมูลทั้งหมด");

        Optional<ButtonType> result = alert.showAndWait();

        if (result.orElse(noButton) == yesButton) {
            subjectIO.resetData();
            update();
        }



    }

    protected void update() {
        for (TermSubjectDataController controller: allController) {
            controller.update();
        }
    }

    protected void loadTermItems() {
        for (int i=1; i<=2; i++) {
            loadItemFromFile(new TermSubjectDataController(), status + "_" + i);
        }
    }

    protected void loadItemFromFile(TermSubjectDataController controller, String status) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/courseInAYearPage/termSubject/termSubjectData.fxml"));

            loader.setController(controller);
            Parent node = loader.load();

            termVBox.getChildren().add(node);
            controller.setStage(stage);
            controller.setSubjectIO(subjectIO);
            controller.setStatus(status);
            controller.setUpdateCallback(this::update);

            allController.add(controller);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void backToPrevious() {
        new OpenChooseYearPage().open(stage, subjectIO);
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setSubjectIO(SubjectIO subjectIO) {
        this.subjectIO = subjectIO;
    }
}
