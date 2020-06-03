package Lesson6;

public class Dog extends Animal {

    public Dog(String name) {
        super("Dog " + name);
        super.runLimit = 500;
        this.swimLimit = 10;
        this.jumpLimit = 0.5;
    }

    public Dog(String name, int runLimit) {
        super("Dog " + name, runLimit);
        this.swimLimit = 10;
        this.jumpLimit = 0.5;
    }

}
