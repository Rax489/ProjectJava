package bg.fmi.control.exam.domain;

import bg.fmi.control.exam.task.Task;

import java.util.List;

public interface Student {
    String getName();

    StudentType getType();

    String arrive();

    List<String> getSuperpowers();

    ExamResult solve(Task task);
}
