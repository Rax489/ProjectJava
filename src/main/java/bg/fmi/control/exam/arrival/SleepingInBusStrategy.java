package bg.fmi.control.exam.arrival;

public class SleepingInBusStrategy implements ArrivalStrategy {
    @Override
    public String arrive(String studentName) {
        return studentName + " пристига след спане в автобус и се събужда точно навреме.";
    }
}
