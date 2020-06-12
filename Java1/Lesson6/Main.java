package Lesson6;

public class Main {

    public static void main(String[] args) {
        Animal[] animals = new Animal[3];

        animals[0] = new Dog("Sharik");
        animals[1] = new Cat("Barsik");
        animals[2] = new Dog("Martin", 600);

    }

    static void printAnimal(Animal[] animals) {
        for (int i = 0; i < animals.length; i++) {
            animals[i].run(550);
            animals[i].jump(1.5);
            animals[i].swim(3);
        }
    }
}
