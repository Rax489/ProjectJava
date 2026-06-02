package bg.fmi.control.exam.decorator;

import bg.fmi.control.exam.domain.ExamResult;
import bg.fmi.control.exam.domain.Student;
import bg.fmi.control.exam.domain.StudentType;
import bg.fmi.control.exam.task.Task;

import java.util.List;

public abstract class StudentDecorator implements Student {
    private final Student student;

    protected StudentDecorator(Student student) {
        this.student = student;
    }

    protected Student getStudent() {
        return student;
    }

    @Override
    public String getName() {
        return student.getName();
    }

    @Override
    public StudentType getType() {
        return student.getType();
    }

    @Override
    public String arrive() {
        return student.arrive();
    }

    @Override
    public List<String> getSuperpowers() {
        return student.getSuperpowers();
    }

    @Override
    public ExamResult solve(Task task) {
        return student.solve(task);
    }
}
