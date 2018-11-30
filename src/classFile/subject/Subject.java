package classFile.subject;

import java.util.ArrayList;

public class Subject {
    private String icon;
    private String subjectId;
    private String name;
    private DifficultLevel difficultLevel;
    private int credit;
    private boolean finish;
    private String detail;
    private ArrayList<Subject> previous;
    private ArrayList<Subject> next;

    public Subject(String icon, String subjectId, String name, DifficultLevel difficultLevel, int credit, String detail) {
        this.icon = icon;
        this.subjectId = subjectId;
        this.name = name;
        this.difficultLevel = difficultLevel;
        this.credit = credit;
        this.finish = false;
        this.detail = detail;
        this.previous = new ArrayList<>();
        this.next = new ArrayList<>();
    }

    public void addNext(Subject subject) {
        next.add(subject);
        subject.addPrevious(this);
    }

    public void addPrevious(Subject subject) {
        previous.add(subject);
    }

    public ArrayList<Subject> getPrevious() {
        return previous;
    }

    public ArrayList<Subject> getNext() {
        return next;
    }

    public String getIcon() {
        return icon;
    }

    public String getSubjectId() {
        return subjectId;
    }

    public String getName() {
        return name;
    }

    public DifficultLevel getDifficultLevel() {
        return difficultLevel;
    }

    public int getCredit() {
        return credit;
    }

    public String getDetail() {
        return detail;
    }

    public boolean isFinish() {
        return finish;
    }

    public void setFinish(boolean finish) {
        this.finish = finish;
    }
}
