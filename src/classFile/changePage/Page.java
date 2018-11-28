package classFile.changePage;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class Page {
    public static FXMLLoader changeToPage(Stage stage, URL url) throws IOException {
        FXMLLoader loader = new FXMLLoader(url);
        Parent root = loader.load();
        stage.setScene(new Scene(root, 800, 600));
        return loader;
    }
}
