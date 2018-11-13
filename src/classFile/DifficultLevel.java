package classFile;

import javafx.scene.paint.Color;

public enum DifficultLevel {
    ANY("ขึ้นกับวิชา", Color.web("#707070")),
    EASY("ง่าย", Color.web("#7BC043")),
    QUITE_EASY("ค่อนข้างง่าย", Color.web("#00cc7a")),
    MEDIUM("ปานกลาง", Color.web("#0492CF")),
    QUITE_HARD("ค่อนข้างยาก", Color.web("#EB6841")),
    HARD("ยาก", Color.web("#CC2A36"));

    private String value;
    private Color color;

    DifficultLevel(String level, Color color) {
        this.value = level;
        this.color = color;
    }

    public String getAsString() {
        return value;
    }

    public Color getColor() { return color; }

}
