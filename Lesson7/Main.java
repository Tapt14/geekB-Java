package Lesson7;

public class Main {
    public static void main(String[] args) {
        Bowl bowl = new Bowl(100, 55);
        Cat[] cats = new Cat[5];
        cats[0] = new Cat("Vaska", 10);
        cats[1] = new Cat("Barsik", 12);
        cats[2] = new Cat("Boris", 20);
        cats[3] = new Cat("Black", 15);
        cats[4] = new Cat("Martin", 20);

        for (int i = 0; i < cats.length; i++) {
            cats[i].eat(bowl);
        }
        
    }
}
