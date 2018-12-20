package application.main;

import application.mainPage.MainPageController;
import application.subject.SubjectIO;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/mainPage/mainPage.fxml"));
        Parent root = loader.load();
        primaryStage.setTitle("KU Regis Checker");
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.setResizable(false);

        MainPageController mainPageController = loader.getController();
        mainPageController.setStage(primaryStage);
        mainPageController.setSubjectIO(new SubjectIO());                   // Init subject data
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
