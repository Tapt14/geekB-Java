package Java3.Lesson5;

public class Truck extends Vehicle implements Runnable{

    public Truck(String name) {
        this.name = name;
        this.fuelVolume = 60f;
        this.fuelConsumption = 15f;
    }

    @Override
    public void run() {
        startMoving();
    }
}
