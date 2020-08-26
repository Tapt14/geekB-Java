package Java3.Lesson1;

import java.util.ArrayList;

public class Box<T extends Fruit> {
    private ArrayList<T> boxList;

    public Box(ArrayList<T> boxList) {
        this.boxList = boxList;
    }

    public ArrayList<T> getBoxList() {
        return boxList;
    }

    public void addFruit (T fruit) {
        getBoxList().add(fruit);
    }

    public float getWeightBox () {
        if (!getBoxList().isEmpty())
        return  getBoxList().get(0).getWeight()*boxList.size();
        else return 0.0f;
    }

    public boolean compareBoxWeight(Box<? extends Fruit> box) {
        return this.getWeightBox() == box.getWeightBox();
    }

    public void putFruitInAnotherBox(Box<T> another) {
        another.getBoxList().addAll(this.boxList);
        this.boxList.clear();
    }
}
