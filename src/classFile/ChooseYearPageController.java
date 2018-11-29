package classFile;

import classFile.changePage.Page;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;

public class ChooseYearPageController {
    @FXML private Stage stage;
    @FXML private StackPane year1, year2, year3, year4;

    @FXML
    public void initialize() {
        setOnClickStackPane(year1);
        setOnClickStackPane(year2);
        setOnClickStackPane(year3);
        setOnClickStackPane(year4);
    }

    private void setOnClickStackPane(StackPane stackPane) {
        stackPane.setOnMouseClicked(event -> openNextPage(stackPane.getId()));
    }

    private void openNextPage(String status) {
        try {
            FXMLLoader loader = Page.loadPage(stage, getClass().getResource("../fxml/courseInAYearPage.fxml"));
            CourseInAYearPageController controller = loader.getController();
            controller.setStage(stage);
            controller.setStatus(status);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void backToPrevious() {
        try {
            FXMLLoader loader = Page.loadPage(stage, getClass().getResource("../fxml/mainPage.fxml"));
            MainPageController controller = loader.getController();
            controller.setStage(stage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }
}
