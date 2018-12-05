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
    private ArrayList<String> previous;
    private ArrayList<String> next;
    private int year;
    private int term;

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

    private void addNext(Subject subject) {
        String format = formatSubjectId(subject);
        next.add(format);
    }

    public void addPrevious(Subject subject) {
        String format = formatSubjectId(subject);
        previous.add(format);
        subject.addNext(this);
    }

    private String formatSubjectId(Subject subject) {
        return subject.getYear() + "" +  subject.getTerm() + "_" + subject.getSubjectId();
    }

    public ArrayList<String> getPrevious() {
        return previous;
    }

    public ArrayList<String> getNext() {
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

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getTerm() {
        return term;
    }

    public void setTerm(int term) {
        this.term = term;
    }
}
