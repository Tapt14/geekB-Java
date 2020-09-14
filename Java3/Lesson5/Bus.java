package Java3.Lesson5;

public class Bus extends Vehicle implements Runnable {

    public Bus(String name) {
        this.name = name;
        this.fuelVolume = 40f;
        this.fuelConsumption = 7.5f;
    }

    @Override
    public void run() {
        startMoving();
    }
}
