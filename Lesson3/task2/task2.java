package Lesson3.task2;

import java.util.Scanner;

public class task2 {

    static char[] hiddenChar = {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#',};

    public static void main(String[] args) {
        boolean continueGame = false;
        String[] words = {"apple", "orange", "lemon", "banana", "apricot",
                "avocado", "broccoli", "carrot", "cherry",
                "garlic", "grape", "melon", "leak", "kiwi", "mango",
                "mushroom", "nut", "olive", "pea", "peanut", "pear",
                "pepper", "pineapple", "pumpkin", "potato"};

        Scanner scanner = new Scanner(System.in);
        String randomWord = words[generateRandomIndexArray(words)];
        System.out.println();
        System.out.println("Вам необходимо отгадать загаданный овощ или фрукт. Колличество попыток не ограничено. ");

        do {
            while (true) {

                System.out.println();
                System.out.println("Введите слово");
                String typedWord = scanner.nextLine().toLowerCase();

                if (typedWord.equals(randomWord)) {
                    System.out.println("Поздравляем, вы угадали слово!");
                    break;
                } else {
                    compares2Words(typedWord, randomWord);
                    System.out.println(hiddenChar);
                }
            }

            System.out.println("Повторить игру еще раз? 1 – да / 0 – нет");
            if (scanner.nextInt() == 1) {
                continueGame = true;
                doDefaultArray(hiddenChar);
            }

        } while (continueGame);
    }

    private static int generateRandomIndexArray(String[] array) {
        return (int) (Math.random() * (array.length));
    }

    private static void compares2Words(String s1, String s2) {
        // сравниваем длинны строк, чтобы не получить ошибку при сравнении символов в цикле
        int min = Math.min(s1.length(), s2.length());
        for (int i = 0; i < min; i++) {
            if (s1.charAt(i) == s2.charAt(i)) hiddenChar[i] = s1.charAt(i);
        }
    }

    //приведение массива к начальному, если игра начинается заново
    private static void doDefaultArray (char[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = '#';
        }
    }
}
