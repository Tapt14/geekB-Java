package Java2.Lesson1;

public class Cat implements Competitors{

    private final String name;
    private final int runLimitDistance;
    private final double jumpLimitHeight;

    public Cat(String name, int runLimitDistance, double jumpLimitHeight) {
        this.name = name;
        this.runLimitDistance = runLimitDistance;
        this.jumpLimitHeight = jumpLimitHeight;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getRunLimitDistance() {
        return runLimitDistance;
    }

    @Override
    public double getJumpLimitHeight() {
        return jumpLimitHeight;
    }
}
