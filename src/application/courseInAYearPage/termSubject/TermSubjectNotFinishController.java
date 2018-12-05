package application;

import application.subject.Subject;

import java.util.ArrayList;

public class TermSubjectNotFinishController extends TermSubjectDataController {

    @Override
    protected void addSubjectItems() {
        ArrayList<Subject> subjects = subjectIO.getSubjectInTerm(year, term);
        for (Subject each: subjects) {
            if (!each.isFinish()) {
                displayDataSubjectVbox.getChildren().addAll(loadSubjectData(each));
            }
        }
    }
}
