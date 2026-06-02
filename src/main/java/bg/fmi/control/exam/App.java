package bg.fmi.control.exam;

import bg.fmi.control.exam.arrival.RunningWithJumpingStrategy;
import bg.fmi.control.exam.arrival.SleepingInBusStrategy;
import bg.fmi.control.exam.arrival.TeleportationStrategy;
import bg.fmi.control.exam.decorator.FastWritingStudent;
import bg.fmi.control.exam.decorator.SuperConcentrationStudent;
import bg.fmi.control.exam.decorator.TelepathyStudent;
import bg.fmi.control.exam.domain.BaseStudent;
import bg.fmi.control.exam.domain.Student;
import bg.fmi.control.exam.domain.StudentType;
import bg.fmi.control.exam.university.ExamRecord;
import bg.fmi.control.exam.university.University;

import java.util.List;

public class App {
    public static void main(String[] args) {
        Student ivo = new SuperConcentrationStudent(
            new BaseStudent("Иво", StudentType.WONDERKID, new TeleportationStrategy())
        );

        Student martin = new FastWritingStudent(
            new BaseStudent("Мартин", StudentType.FITNESS_MANIA, new RunningWithJumpingStrategy())
        );

        Student niki = new TelepathyStudent(
            new SuperConcentrationStudent(
                new BaseStudent("Ники", StudentType.LUCKY, new SleepingInBusStrategy())
            )
        );

        University university = University.getInstance();
        List<ExamRecord> records = university.conductControlExam(List.of(ivo, martin, niki));

        System.out.println("Денят на контролното започва.");
        System.out.println("Университетът активира специалната си система.");
        System.out.println();

        for (ExamRecord record : records) {
            System.out.println(record.format());
            System.out.println("-".repeat(80));
        }
    }
}
