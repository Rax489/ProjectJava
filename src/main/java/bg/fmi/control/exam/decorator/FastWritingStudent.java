package bg.fmi.control.exam.decorator;

import bg.fmi.control.exam.domain.ExamResult;
import bg.fmi.control.exam.domain.Student;
import bg.fmi.control.exam.task.Task;

import java.util.ArrayList;
import java.util.List;

public class FastWritingStudent extends StudentDecorator {
    public FastWritingStudent(Student student) {
        super(student);
    }

    @Override
    public List<String> getSuperpowers() {
        List<String> powers = new ArrayList<>(super.getSuperpowers());
        powers.add("Бързопис");
        return powers;
    }

    @Override
    public ExamResult solve(Task task) {
        return super.solve(task).addEffect("Бързопис увеличава броя предадени редове", 12);
    }
}
