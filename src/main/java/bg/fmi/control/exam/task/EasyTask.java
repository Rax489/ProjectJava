package bg.fmi.control.exam.task;

public class EasyTask implements Task {
    @Override
    public String getName() {
        return "Лесна задача";
    }

    @Override
    public String getDescription() {
        return "Създай клас Student и отпечатай мотивационно съобщение преди контролното.";
    }

    @Override
    public int getBaseDifficulty() {
        return 25;
    }
}
