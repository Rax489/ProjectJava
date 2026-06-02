package bg.fmi.control.exam.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ExamResult {
    private final int points;
    private final List<String> effects;

    public ExamResult(int points, List<String> effects) {
        this.points = Math.max(0, Math.min(100, points));
        this.effects = new ArrayList<>(effects);
    }

    public int getPoints() {
        return points;
    }

    public List<String> getEffects() {
        return Collections.unmodifiableList(effects);
    }

    public ExamResult addEffect(String effect, int bonus) {
        List<String> updatedEffects = new ArrayList<>(effects);
        updatedEffects.add(effect + " (+" + bonus + ")");
        return new ExamResult(points + bonus, updatedEffects);
    }

    public String getGrade() {
        if (points >= 90) {
            return "Отличен 6";
        }
        if (points >= 75) {
            return "Много добър 5";
        }
        if (points >= 60) {
            return "Добър 4";
        }
        if (points >= 45) {
            return "Среден 3";
        }
        return "Слаб 2";
    }

    @Override
    public String toString() {
        return points + " точки, " + getGrade() + ", ефекти: " + String.join(", ", effects);
    }
}
