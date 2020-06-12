package Lesson3.task1;

import java.util.Scanner;

public class task1 {
    public static void main(String[] args) {
        boolean continueGame = false;
        boolean isWin = false;
        System.out.println();
        System.out.println("Правила игры: компьютер загадывает число от 0 до 9 включительно. " +
                "Ваша задача отгадать это число с 3 попыток.");

        do {
            int random = generateRandomInt(0, 9);
            Scanner scanner = new Scanner(System.in);

            for (int i = 0; i < 3; i++) {
                System.out.println();
                System.out.println("Введите любое целое число от 0 до 9 включительно");
                int move = scanner.nextInt();
                if (move == random) {
                    System.out.println("Ура! Вы угадали!");
                    isWin = true;
                    break;
                } else if (move > random) {
                    System.out.println("Вы указали число больше загаданного.");
                } else System.out.println("Вы указали число меньше загаданного");
            }

            if (!isWin) System.out.println("Попытки израсходованы, вы не угадали. Было загадано число: " + random);

            System.out.println("Повторить игру еще раз? 1 – да / 0 – нет");
            if (scanner.nextInt() == 1) {
                continueGame = true;
                isWin = false;
            }
            
        } while (continueGame);
    }

    private static int generateRandomInt(int min, int max) {
        return (int) (Math.random() * (max - min + 1) + min);

    }

}
