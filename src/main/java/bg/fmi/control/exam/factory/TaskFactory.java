package bg.fmi.control.exam.factory;

import bg.fmi.control.exam.domain.Student;
import bg.fmi.control.exam.domain.StudentType;
import bg.fmi.control.exam.task.EasyTask;
import bg.fmi.control.exam.task.FunTask;
import bg.fmi.control.exam.task.Task;
import bg.fmi.control.exam.task.UnclearTask;

public class TaskFactory {
    public Task createTaskFor(Student student) {
        if (student.getType() == StudentType.WONDERKID) {
            return new FunTask();
        }
        if (student.getType() == StudentType.FITNESS_MANIA) {
            return new UnclearTask();
        }
        return new EasyTask();
    }
}
