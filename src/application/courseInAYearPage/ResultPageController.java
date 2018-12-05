package application;

import application.changePage.OpenMainPage;
import javafx.fxml.FXML;

public class ResultPageController extends CourseInAYearPageController {

    @Override
    protected void loadTermItems() {
        for (int i=1; i<=4; i++) {
            for (int j=1; j<=2; j++) {
                loadItemFromFile(new TermSubjectNotFinishController(), i + "_" + j);
            }
        }
    }

    @FXML
    private void backToPrevious() {
        new OpenMainPage().open(stage, subjectIO);
    }
}
