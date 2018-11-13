package classFile;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;

public class ChooseYearPageController {
    @FXML private Stage stage;
    @FXML private StackPane backToHomePageStackPane;
    @FXML private StackPane firstYearStackPane;

    public ChooseYearPageController() {

    }

    @FXML
    public void initialize() {
        handleChangeToMainPageOnclickStackPane();
        handleChangeToCourseInAYearPageOnclickStackPane();
    }

    private void handleChangeToMainPageOnclickStackPane() {
        backToHomePageStackPane.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("../fxml/mainPage.fxml"));
                    Parent root = loader.load();
                    stage.setScene(new Scene(root, 800, 600));

                    MainPageController controller = loader.getController();
                    controller.setStage(stage);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private void handleChangeToCourseInAYearPageOnclickStackPane() {
        firstYearStackPane.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("../fxml/courseInAYearPage.fxml"));
                    Parent root = loader.load();
                    stage.setScene(new Scene(root, 800, 600));

                    CourseInAYearPageController controller = loader.getController();
                    controller.setStage(stage);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }
}
