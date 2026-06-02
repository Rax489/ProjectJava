package bg.fmi.control.exam;

import bg.fmi.control.exam.arrival.TeleportationStrategy;
import bg.fmi.control.exam.decorator.FastWritingStudent;
import bg.fmi.control.exam.decorator.SuperConcentrationStudent;
import bg.fmi.control.exam.domain.BaseStudent;
import bg.fmi.control.exam.domain.Student;
import bg.fmi.control.exam.domain.StudentType;
import bg.fmi.control.exam.factory.TaskFactory;
import bg.fmi.control.exam.task.EasyTask;
import bg.fmi.control.exam.task.FunTask;
import bg.fmi.control.exam.task.UnclearTask;
import bg.fmi.control.exam.university.ExamRecord;
import bg.fmi.control.exam.university.University;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DesignPatternTest {
    @Test
    void universityIsSingleton() {
        University first = University.getInstance();
        University second = University.getInstance();

        assertSame(first, second);
    }

    @Test
    void factoryCreatesExpectedTaskForEveryStudentType() {
        TaskFactory factory = new TaskFactory();

        assertInstanceOf(FunTask.class, factory.createTaskFor(student(StudentType.WONDERKID)));
        assertInstanceOf(UnclearTask.class, factory.createTaskFor(student(StudentType.FITNESS_MANIA)));
        assertInstanceOf(EasyTask.class, factory.createTaskFor(student(StudentType.LUCKY)));
    }

    @Test
    void decoratorAddsMultipleSuperpowersAndImprovesResult() {
        Student decorated = new FastWritingStudent(new SuperConcentrationStudent(student(StudentType.LUCKY)));

        assertEquals(List.of("Свръхконцентрация", "Бързопис"), decorated.getSuperpowers());
        assertTrue(decorated.solve(new EasyTask()).getPoints() > student(StudentType.LUCKY).solve(new EasyTask()).getPoints());
    }

    @Test
    void strategyControlsArrivalText() {
        Student student = new BaseStudent("Тест", StudentType.WONDERKID, new TeleportationStrategy());

        assertTrue(student.arrive().contains("телепортира"));
    }

    @Test
    void universityConductsExamForEveryStudent() {
        List<Student> students = List.of(
            student(StudentType.WONDERKID),
            student(StudentType.FITNESS_MANIA),
            student(StudentType.LUCKY)
        );

        List<ExamRecord> records = University.getInstance().conductControlExam(students);

        assertEquals(3, records.size());
        assertInstanceOf(FunTask.class, records.get(0).getTask());
        assertInstanceOf(UnclearTask.class, records.get(1).getTask());
        assertInstanceOf(EasyTask.class, records.get(2).getTask());
    }

    private Student student(StudentType type) {
        return new BaseStudent("Студент", type, new TeleportationStrategy());
    }
}
