package sample;

import javafx.scene.paint.Color;

public class Subject {
    private String icon;
    private String subjectId;
    private String name;
    private DifficultLevel difficultLevel;
    private int credit;
    private boolean finish;

    public Subject(String icon, String subjectId, String name, DifficultLevel difficultLevel, int weight, boolean finish) {
        this.icon = icon;
        this.subjectId = subjectId;
        this.name = name;
        this.difficultLevel = difficultLevel;
        this.credit = weight;
        this.finish = finish;
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

    public Color getDifficlutLevelColor() {
        return difficultLevel.getColor();
    }

    public int getCredit() {
        return credit;
    }

    public boolean isFinish() {
        return finish;
    }

    public void setFinish(boolean finish) {
        this.finish = finish;
    }
}
