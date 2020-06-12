package Lesson7;

public class Cat {

    private final String name;
    private int appetite;
    private boolean isFull = false;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
    }

    public String getName() {
        return name;
    }

    public int getAppetite() {
        return appetite;
    }

    public boolean isFull() {
        return isFull;
    }

    public void setIsFull(boolean isFull) {
        this.isFull = isFull;
    }

    public void eat(Bowl bowl) {

        System.out.println("\nFeed in bowl: " + bowl.getFeedInBowl());
        if (bowl.getFeedInBowl() > 0 && bowl.getFeedInBowl() < getAppetite() && !isFull()) {
            System.out.println("Not enough feed! " + getName() + " is hungry!");

        } else if(!isFull()) {
            System.out.println(getName() + " eating");
            bowl.setFeedInBowl(bowl.getFeedInBowl() - appetite);
            setIsFull(true);
            System.out.println(getName() + " is full!");
        }
    }
}
