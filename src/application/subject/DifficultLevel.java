package classFile.subject;

import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;

public enum DifficultLevel {
    ANY("ขึ้นกับวิชา", Color.web("#707070"), new String[]{"#868f96", "#596164"}),
    EASY("ง่าย", Color.web("#7BC043"), new String[]{"#D6EF36", "#72FF00"}),
    QUITE_EASY("ค่อนข้างง่าย", Color.web("#00cc7a"), new String[] {"#34EFB1", "#01FE01"}),
    MEDIUM("ปานกลาง", Color.web("#0492CF"), new String[] {"#008C79", "#0020FF"}),
    QUITE_HARD("ค่อนข้างยาก", Color.web("#EB6841"), new String[] {"#FFE95A", "#FF9900"}),
    HARD("ยาก", Color.web("#CC2A36"), new String[] {"#C9445D", "#FF0022"});

    private String level;
    private Color color;
    private LinearGradient linearColor;

    DifficultLevel(String level, Color color, String[] colorStyle) {
        this.level = level;
        this.color = color;

        Stop[] stops = new Stop[] { new Stop(0, Color.web(colorStyle[0])), new Stop(1, Color.web(colorStyle[1]))};
        this.linearColor = new LinearGradient(0.5, 0, 0.5, 1, true, CycleMethod.NO_CYCLE, stops);
    }

    public String getLevel() {
        return level;
    }

    public Color getColor() { return color; }

    public LinearGradient getLinearColor() {
        return linearColor;
    }
}
