package bg.fmi.control.exam.decorator;

import bg.fmi.control.exam.domain.ExamResult;
import bg.fmi.control.exam.domain.Student;
import bg.fmi.control.exam.task.Task;

import java.util.ArrayList;
import java.util.List;

public class SuperConcentrationStudent extends StudentDecorator {
    public SuperConcentrationStudent(Student student) {
        super(student);
    }

    @Override
    public List<String> getSuperpowers() {
        List<String> powers = new ArrayList<>(super.getSuperpowers());
        powers.add("Свръхконцентрация");
        return powers;
    }

    @Override
    public ExamResult solve(Task task) {
        return super.solve(task).addEffect("Свръхконцентрация премахва паниката", 18);
    }
}
