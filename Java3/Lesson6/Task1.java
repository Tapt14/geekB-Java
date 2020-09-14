package Java3.Lesson6;

import java.util.Arrays;



public class Task1 {

    public int[] AfterLast4(int[] arr) throws RuntimeException {

        int n = 0;
        String str = Arrays.toString(arr);
        if (str.contains(String.valueOf(4))) {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == 4) n = i;
            }
            int[] arr1 = new int[arr.length - n - 1];
            System.arraycopy(arr, n + 1, arr1, 0, arr1.length);
            return arr1;
        } else {
            throw new RuntimeException("4 not found");
        }
    }
}
