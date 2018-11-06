package sample;

public class Subject {
    private String icon;
    private String subjectId;
    private String name;
    private DifficultLevel difficultLevel;
    private int credit;
    private boolean isFinish;

    public Subject() {
        this.icon = "";
        this.subjectId = "";
        this.name = "";
        this.difficultLevel = DifficultLevel.NONE;
        this.credit = 0;
        this.isFinish = false;
    }

    public Subject(String icon, String subjectId, String name, DifficultLevel difficultLevel, int weight, boolean isFinish) {
        this.icon = icon;
        this.subjectId = subjectId;
        this.name = name;
        this.difficultLevel = difficultLevel;
        this.credit = weight;
        this.isFinish = isFinish;
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

    public String getDifficultLevel() {
        return difficultLevel.getAsString();
    }

    public int getCredit() {
        return credit;
    }

    public boolean isFinish() {
        return isFinish;
    }

    public void setFinish(boolean finish) {
        isFinish = finish;
    }
}
