package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class MainPageController {
    @FXML private Stage stage;
    @FXML private StackPane chooseYearStackPane;
    @FXML private StackPane chooseCourseStackPane;
    @FXML private StackPane goTodetail;

    public MainPageController() {
    }

    @FXML
    public void initialize() {
        handleChangeToChooseYearPageOnclickStackPane();
        goToDetail();
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    private void handleChangeToChooseYearPageOnclickStackPane() {
        chooseYearStackPane.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("chooseYearPage.fxml"));
                    Parent root = loader.load();
                    stage.setScene(new Scene(root, 800, 600));

                    ChooseYearPageController controller = loader.getController();
                    controller.setStage(stage);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
    private void goToDetail(){
        goTodetail.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("detailsPage.fxml"));
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
