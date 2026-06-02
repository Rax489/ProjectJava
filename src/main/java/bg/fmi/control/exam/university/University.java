package bg.fmi.control.exam.university;

import bg.fmi.control.exam.domain.ExamResult;
import bg.fmi.control.exam.domain.Student;
import bg.fmi.control.exam.factory.TaskFactory;
import bg.fmi.control.exam.task.Task;

import java.util.ArrayList;
import java.util.List;

public class University {
    private static final University INSTANCE = new University();

    private final TaskFactory taskFactory;

    private University() {
        taskFactory = new TaskFactory();
    }

    public static University getInstance() {
        return INSTANCE;
    }

    public List<ExamRecord> conductControlExam(List<Student> students) {
        List<ExamRecord> records = new ArrayList<>();
        for (Student student : students) {
            String arrivalMessage = student.arrive();
            Task task = taskFactory.createTaskFor(student);
            ExamResult result = student.solve(task);
            records.add(new ExamRecord(student, task, result, arrivalMessage));
        }
        return records;
    }
}
