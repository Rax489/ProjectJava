package bg.fmi.control.exam.domain;

public enum StudentType {
    WONDERKID("Вундеркинд"),
    FITNESS_MANIA("Фитнес маниак"),
    LUCKY("Калитко");

    private final String displayName;

    StudentType(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
