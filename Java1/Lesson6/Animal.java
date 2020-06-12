package Lesson6;

public abstract class Animal {

    protected String name;
    protected int runLimit;
    protected int swimLimit;
    protected double jumpLimit;

    public Animal(String name) {
        this.name = name;
    }

    public Animal(String name, int runLimit) {
        this.name = name;
        this.runLimit = runLimit;
    }

    public void run(int runDistance) {

        if (runLimit > 0 && runLimit >= runDistance) {
            System.out.printf("%s ran %d meters.\n", this.name, runDistance);
        } else {
            System.out.printf("%s can't run %d meters. Maximum distance: %d meters.\n", name, runDistance, runLimit);
        }
    }

    public void swim(int swimDistance) {
        if (swimLimit > 0 && swimLimit >= swimDistance) {
            System.out.printf("%s swam %d meters.\n", name, swimDistance);
        } else {
            System.out.printf("%s can't swim %d meters. Maximum distance: %d meters.\n", name, swimDistance, swimLimit);
        }
    }

    public void jump(double jumpHeight) {
        if (jumpLimit > 0 && jumpLimit >= jumpHeight) {
            System.out.printf("%s jumped %.1f meters.\n", name, jumpHeight);
        } else {
            System.out.printf("%s can't jump %.1f meters. Maximum obstacle height %.1f meters.\n", name, jumpHeight, jumpLimit);
        }
    }
}
