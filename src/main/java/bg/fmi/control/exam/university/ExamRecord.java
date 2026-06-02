package bg.fmi.control.exam.university;

import bg.fmi.control.exam.domain.ExamResult;
import bg.fmi.control.exam.domain.Student;
import bg.fmi.control.exam.task.Task;

public class ExamRecord {
    private final Student student;
    private final Task task;
    private final ExamResult result;
    private final String arrivalMessage;

    public ExamRecord(Student student, Task task, ExamResult result, String arrivalMessage) {
        this.student = student;
        this.task = task;
        this.result = result;
        this.arrivalMessage = arrivalMessage;
    }

    public Student getStudent() {
        return student;
    }

    public Task getTask() {
        return task;
    }

    public ExamResult getResult() {
        return result;
    }

    public String getArrivalMessage() {
        return arrivalMessage;
    }

    public String format() {
        return String.join(System.lineSeparator(),
            arrivalMessage,
            "Студент: " + student.getName() + " (" + student.getType().getDisplayName() + ")",
            "Суперсили: " + (student.getSuperpowers().isEmpty() ? "няма" : String.join(", ", student.getSuperpowers())),
            "Получена задача: " + task.getName(),
            "Условие: " + task.getDescription(),
            "Резултат: " + result
        );
    }
}
