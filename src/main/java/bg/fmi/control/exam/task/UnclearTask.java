package bg.fmi.control.exam.task;

public class UnclearTask implements Task {
    @Override
    public String getName() {
        return "Непонятна задача";
    }

    @Override
    public String getDescription() {
        return "Докажи програмно, че компилаторът разбира условието по-добре от студента.";
    }

    @Override
    public int getBaseDifficulty() {
        return 85;
    }
}
