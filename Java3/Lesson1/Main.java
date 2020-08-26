package Java3.Lesson1;

import java.util.ArrayList;


public class Main {

    public static void main(String[] args) {

        //Task1
        System.out.println("\nTask1");
        Integer[] array = {1,2,3,4,5};
        SomeClass<Integer> someClassInstance = new SomeClass<>();

        for (Integer i: array) {
            System.out.print(i);
        }
        System.out.println();
        someClassInstance.swapArrayElements(array,1, 2);
        for (Integer i: array) {
            System.out.print(i);
        }

        //Task2
        System.out.println("\n\nTask2");
        ArrayList<Integer> arrayList = new ArrayList<>();
        someClassInstance.arrayToArrayList(array, arrayList);
        System.out.println(arrayList);

        //Task3
        System.out.println("\nTask3");
        Box<Apple> boxApple = new Box<>(new ArrayList<>());
        for (int i = 0; i < 6; i++) {
            boxApple.addFruit(new Apple());
        }
        Box<Orange> boxOrange = new Box<>(new ArrayList<>());
        for (int i = 0; i < 4; i++) {
            boxOrange.addFruit(new Orange());
        }
        System.out.println("Apple box weight: " + boxApple.getWeightBox());
        System.out.println("Orange box weight: " + boxOrange.getWeightBox());
        System.out.println(boxApple.compareBoxWeight(boxOrange));

        Box<Apple> anotherBoxApple = new Box<>(new ArrayList<>());
        Box<Orange> anotherBoxOrange = new Box<>(new ArrayList<>());

        boxApple.putFruitInAnotherBox(anotherBoxApple);
        boxOrange.putFruitInAnotherBox(anotherBoxOrange);

        System.out.println("Apple box weight: " + boxApple.getWeightBox());
        System.out.println("Another Apple box weight: " + anotherBoxApple.getWeightBox());
        System.out.println("Orange box weight: " + boxOrange.getWeightBox());
        System.out.println("Another Orange box weight: " + anotherBoxOrange.getWeightBox());

    }
}
