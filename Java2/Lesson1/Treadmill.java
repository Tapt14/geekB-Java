package Java2.Lesson1;

public class Treadmill implements Obstacles{

    private final int distance;

    public Treadmill(int distance) {
        this.distance = distance;
    }

    public int getDistance() {
        return distance;
    }
}
