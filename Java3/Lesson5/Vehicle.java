package Java3.Lesson5;

abstract public class Vehicle {

    String name;
    float fuelVolume;
    float fuelConsumption;

    public void startMoving () {
        System.out.printf("%s %s - started moving \n", getClass().getSimpleName(), name);
        while (fuelVolume > 3) {
            fuelVolume -= fuelConsumption;
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.printf("The fuel is almost out, %s %s need to refuel.\n", getClass().getSimpleName(), name);
        FuelStation.refueling(this);
    }

}
