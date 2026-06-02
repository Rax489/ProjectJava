package bg.fmi.control.exam.task;

public class FunTask implements Task {
    @Override
    public String getName() {
        return "Забавна задача";
    }

    @Override
    public String getDescription() {
        return "Реализирай алгоритъм, който брои колко пъти студентът е казал: Ще уча утре.";
    }

    @Override
    public int getBaseDifficulty() {
        return 55;
    }
}
