
public class Introduction {

    // task 1
    public static void main(String[] args) {

        // task 2
        byte b = 14;
        char c = 'M';
        short s = 1414;
        int i = 65243;
        long l = 18L;
        float f = 14.14F;
        double d = 57834.134;
        boolean bo = true;

        System.out.println(task3(2, 3, 4, 0));

    }

    // task 3 (т.к. в задании не сказано какой тип данных будет на входе и какой необходимо вернуть, взяли максимально вариативный)
    public static double task3(double a, double b, double c, double d) {
        return a * (b + (c / d));
    }

    // task 4
    public static boolean task4(double a, double b) {
        return !((a + b) < 10) && !((a + b) > 20);
    }

    // task 5
    public static void task5(int a) {
        if (a < 0) System.out.println("Число отрицательное");
        else System.out.println("Число положительное");
    }

    // task 6
    public static boolean task6(int a) {
        return a < 0;
    }

    // task 7
    public static void task7(String s) {
        System.out.println("Привет, " + s + "!");
    }

    // task 8
    public static void task8(int a) {
        if (((a % 4 == 0) && !(a % 100 == 0)) || (a % 400 == 0))
            System.out.println("Год - високосный!");
        else
            System.out.println("Год - не високосный");
    }

    // task 9 Две разные сигнатуры одного метода.

}

