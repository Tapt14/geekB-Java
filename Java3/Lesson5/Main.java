package Java3.Lesson5;

public class Main {
    public static void main(String[] args) {
        new Thread(new Bus("#1")).start();
        new Thread(new Car("#1")).start();
        new Thread(new Truck("#1")).start();
        new Thread(new Bus("#2")).start();
        new Thread(new Car("#2")).start();
        new Thread(new Car("#3")).start();
        new Thread(new Truck("#2")).start();
        new Thread(new Bus("#3")).start();
        new Thread(new Car("#4")).start();
        new Thread(new Truck("#3")).start();
    }
}
