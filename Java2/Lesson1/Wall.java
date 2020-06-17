package Java2.Lesson1;

public class Wall implements Obstacles{

    private final double height;

    public Wall(double height) {
        this.height = height;
    }

    public double getHeight() {
        return height;
    }
}
