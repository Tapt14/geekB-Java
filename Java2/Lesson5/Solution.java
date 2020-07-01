package Java2.Lesson5;

import java.util.Arrays;

public class Solution {

    static final int size = 10000000;
    static final int h = size / 2;
    float[] arr = new float[size];

    void arrayFilling() {
        Arrays.fill(arr, 1);
    }

    void doCalculation (float[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
    }

    void methodOne() {

        long a = System.currentTimeMillis();
        arrayFilling();
        doCalculation(arr);
        System.out.println("Method1: " + (System.currentTimeMillis() - a));
        for (int i = 0; i < 5 ; i++) {
            System.out.println(arr[i]);
        }
    }

    void methodTwo() {
        float[] a1 = new float[size];
        float[] a2 = new float[size];

        arrayFilling();

        long a = System.currentTimeMillis();
        System.arraycopy(arr, 0, a1, 0, h);
        System.arraycopy(arr, h, a2, 0, h);

        new Thread(() -> doCalculation(a1)).start();
        new Thread(() -> doCalculation(a2)).start();

        System.arraycopy(a1, 0, arr, 0, h);
        System.arraycopy(a2, 0, arr, h, h);
        System.out.println("Method2: " + (System.currentTimeMillis() - a));
        for (int i = 0; i < 5 ; i++) {
            System.out.println(arr[i]);
        }
    }
}
