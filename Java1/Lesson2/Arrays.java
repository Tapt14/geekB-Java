
public class Arrays {

    public static void main(String[] args) {

        // task 1: 1 to 0 or 0 to 1
        int[] arrZeroOne = {0, 1, 1, 0, 1, 0, 1, 0, 0, 1, 1};
        zeroToOne(arrZeroOne);

        // task 2: add value to array
        int[] arrTask2 = new int[8];
        addValuePlus3(arrTask2);

        // task 3 change value less 6
        int[] arrTask3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        changeValueless6(arrTask3);

        // task 4 add value to diagonal
        int[][] arrTask4 = new int[11][11];
        addValueToDiagonal(arrTask4);

        // task 5 min and max
        int[] arrTask5 = {-5, 7, 19, 4, 8, 14, 0, 32, 4, -3, -2, 17, 22, -4};
        minAndMax(arrTask5);

        // task 6 comparing the sum of the parts of the array
        int[] arrTask6 = {2, 2, 1, 1, 1, 3, 4};
        System.out.println(compareSumParts(arrTask6));
        System.out.println();

        // task 7 move value
        int[] arrTask7 = {1, 2, 3, 4, 5, 6, 7};
        moveValue(arrTask7, 10);
    }

    // method task 1
    public static void zeroToOne(int[] x) {
        System.out.println("task 1");
        for (int i : x) {
            i = (i == 0) ? 1 : 0;
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.println();
    }

    // method task 2
    public static void addValuePlus3(int[] x) {
        System.out.println("task 2");
        for (int i = 0; i < x.length; i++) {
            x[i] = i * 3;
            System.out.print(x[i] + " ");
        }
        System.out.println();
        System.out.println();
    }

    // method task 3
    public static void changeValueless6(int[] x) {
        System.out.println("task 3");
        for (int i : x) {
            if (i < 6) i *= 2;
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.println();
    }

    // method task 4
    public static void addValueToDiagonal(int[][] x) {
        System.out.println("task 4");

        for (int i = 0; i < x.length; i++) {

            // проверка на условия задачи (значения меньше 1 и exceptions не рассматривались)
            if (x.length != x[i].length) {
                System.out.println("Это не прямоугольный двумерный массив");
                System.out.println();
                return;
            }
            // продолжение цикла, если условия задачи выполнены
            else {
                for (int j = 0; j < x[i].length; j++) {
                    if (i == j) {
                        x[i][j] = 1;
                        x[i][(x[i].length - j) - 1] = 1;
                    }
                }
            }
        }
        // вывод на консоль
        for (int i = 0; i < x.length; i++) {
            for (int j = 0; j < x[i].length; j++) {
                System.out.print(" " + x[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    // method task 5
    public static void minAndMax(int[] x) {
        System.out.println("task 5");
        int min = x[0], max = x[0];
        for (int i = 1; i < x.length; i++) {
            if (x[i] < min) min = x[i];
            if (x[i] > max) max = x[i];
        }
        System.out.println("Минимальное занчение массива = " + min + "; " + "Максимальное значение массива = " + max + ";");
        System.out.println();
    }

    // method task 6
    public static boolean compareSumParts(int[] x) {
        System.out.println("task 6");
        int sumLeft, sumRight;
        for (int i = 0; i < x.length - 1; i++) {
            sumLeft = 0;
            sumRight = 0;
            for (int j = 0; j <= i; j++) {
                sumLeft += x[j];
            }
            for (int k = i + 1; k < x.length; k++) {
                sumRight += x[k];
            }
            if (sumLeft == sumRight)
                return true;
        }
        return false;
    }

    public static void moveValue(int[] x, int y) {
        System.out.println("task 7");
        int repeat;
        if (y > x.length)
            repeat = y % x.length;
        else
            repeat = y;

        if (y > 0) {
            for (int i = 0; i < repeat; i++) {
                int temp1 = x[x.length - 1], temp2;
                for (int j = 0; j < x.length; j++) {
                    temp2 = x[j];
                    x[j] = temp1;
                    temp1 = temp2;
                }
            }
        }

        if (y < 0) {
            repeat *= -1;
            for (int i = 0; i < repeat; i++) {
                int temp1 = x[0], temp2;
                for (int j = x.length - 1; j >= 0; j--) {
                    temp2 = x[j];
                    x[j] = temp1;
                    temp1 = temp2;
                }
            }
        }

        for (int i : x) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
