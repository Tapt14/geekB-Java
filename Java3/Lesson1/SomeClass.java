package Java3.Lesson1;

import java.util.ArrayList;
import java.util.Collections;

public class SomeClass<T> {

    public void swapArrayElements(T[] someArray, int someObjectIndex1, int someObjectIndex2) {
        T temp = someArray[someObjectIndex1];
        someArray[someObjectIndex1] = someArray[someObjectIndex2];
        someArray[someObjectIndex2] = temp;
    }

    public void arrayToArrayList(T[] someArray, ArrayList<T> someArrayList) {
        Collections.addAll(someArrayList, someArray);

        /*or
        for (T type: someArray) {
            someArrayList.add(type);
        }*/
    }
}
