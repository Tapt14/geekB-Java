package Java3.Lesson5;

public class Car extends Vehicle implements Runnable {

    public Car(String name){
        this.name = name;
        this.fuelVolume = 20f;
        this.fuelConsumption = 2.5f;
    }

    @Override
    public void run() {
        startMoving();
    }
}
