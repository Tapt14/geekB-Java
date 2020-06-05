package Lesson6;

public class Cat extends Animal {

    public Cat(String name) {
        super("Cat " + name);
        super.runLimit = 200;
        this.jumpLimit = 2.0;
    }

    @Override
    public void swim(int swimDistance) {
        System.out.println(name + " can't swim");
    }

}
