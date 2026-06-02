package bg.fmi.control.exam.arrival;

public class TeleportationStrategy implements ArrivalStrategy {
    @Override
    public String arrive(String studentName) {
        return studentName + " се телепортира директно пред аудиторията.";
    }
}
