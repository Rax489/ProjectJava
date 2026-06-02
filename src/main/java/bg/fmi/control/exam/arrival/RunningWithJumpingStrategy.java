package bg.fmi.control.exam.arrival;

public class RunningWithJumpingStrategy implements ArrivalStrategy {
    @Override
    public String arrive(String studentName) {
        return studentName + " пристига с тичане и подскачане, като загрява за контролното.";
    }
}
