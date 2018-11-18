package classFile;

import ChangePage.Page;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;

import java.io.IOException;

public class ChooseYearPageController {
    @FXML private Stage stage;

    @FXML
    private void handleChangeToMainPageOnclickStackPane() {
        try {
            FXMLLoader loader = Page.changeToPage(stage, getClass().getResource("../fxml/mainPage.fxml"));
            MainPageController controller = loader.getController();
            controller.setStage(stage);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    private void handleChangeToCourseInAYearPageOnclickStackPane() {
        try {
            FXMLLoader loader = Page.changeToPage(stage, getClass().getResource("../fxml/courseInAYearPage.fxml"));
            CourseInAYearPageController controller = loader.getController();
            controller.setStage(stage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }
}
