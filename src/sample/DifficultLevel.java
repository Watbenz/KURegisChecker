package sample;

public enum DifficultLevel {
    NONE("ไม่มี"),
    EASY("ง่าย"),
    QUITE_EASY("ค่อนข้างง่าย"),
    MEDIUM("ปานกลาง"),
    QUITE_HARD("ค่อนข้างยาก"),
    HARD("ยาก");

    private String value;

    DifficultLevel(String level) {
        this.value = level;
    }

    public String getAsString() {
        return value;
    }


}
