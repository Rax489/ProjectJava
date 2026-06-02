package bg.fmi.control.exam.domain;

import bg.fmi.control.exam.arrival.ArrivalStrategy;
import bg.fmi.control.exam.task.Task;

import java.util.ArrayList;
import java.util.List;

public class BaseStudent implements Student {
    private final String name;
    private final StudentType type;
    private final ArrivalStrategy arrivalStrategy;

    public BaseStudent(String name, StudentType type, ArrivalStrategy arrivalStrategy) {
        this.name = name;
        this.type = type;
        this.arrivalStrategy = arrivalStrategy;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public StudentType getType() {
        return type;
    }

    @Override
    public String arrive() {
        return arrivalStrategy.arrive(name);
    }

    @Override
    public List<String> getSuperpowers() {
        return List.of();
    }

    @Override
    public ExamResult solve(Task task) {
        int points = calculateBasePoints(task);
        List<String> effects = new ArrayList<>();
        effects.add(type.getDisplayName() + " решава задача тип " + task.getName());
        return new ExamResult(points, effects);
    }

    private int calculateBasePoints(Task task) {
        int preparedness = switch (type) {
            case WONDERKID -> 90;
            case FITNESS_MANIA -> 55;
            case LUCKY -> 65;
        };
        return preparedness - task.getBaseDifficulty() / 3;
    }
}
