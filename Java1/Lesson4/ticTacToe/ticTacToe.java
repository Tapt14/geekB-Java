package Lesson4.ticTacToe;

import java.util.Random;
import java.util.Scanner;

public class ticTacToe {

    static char[][] map;
    static int level = 2;
    static int SIZE = 3;
    static int numberCellsWin = 3;
    static int ACTION_SUM = SIZE * SIZE;
    static char DOT_EMPTY = '.';
    static char DOT_X = 'X';
    static char DOT_O = 'O';
    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();
    static boolean isGameOver = false;
    static char currentPlayerSign = DOT_X;
    static String currentPlayerName = "Player";

    static int actionCounter = 0;
    static int numberFoundLine;

    public static void main(String[] args) {

        playTicTacToe();

    }

    static void playTicTacToe() {
        selectLevel();
        initMap();
        printMap();

        do {
            turn();
            printMap();
            checkWin(currentPlayerSign);
            checkDraw();
            changeTurn();
        } while (!isGameOver);

        resetGame();
    }

    private static void initMap() {
        map = new char[SIZE][SIZE];

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }

    private static void printMap() {
        System.out.println();
        System.out.print("   ");
        for (int i = 0; i < SIZE; i++) {
            System.out.printf("%2d ", i + 1);
        }
        System.out.println();

        for (int i = 0; i < SIZE; i++) {
            System.out.printf("%2d ", i + 1);
            for (int j = 0; j < SIZE; j++) {
                System.out.printf("%2c ", map[i][j]);
            }
            System.out.println();
        }
    }

    private static void selectLevel() {
        System.out.println("\n Pleas select level: 1 - easy, 2 - normal");
        level = scanner.nextInt() == 2 ? 2 : 1;
        String s = level == 2 ? "Normal" : "Easy";
        System.out.println("\nYou selected level: " + s);
    }

    private static boolean isMapFull() {
        return actionCounter >= ACTION_SUM;
    }

    private static void checkDraw() {
        if (!isGameOver && isMapFull()) {
            isGameOver = true;
            System.out.println();
            System.out.println("No more cells to move. Draw!");
            System.out.println();
        }
    }

    private static void changeTurn() {
        if (!isGameOver) {
            currentPlayerSign = currentPlayerSign == DOT_X ? DOT_O : DOT_X;
            currentPlayerName = currentPlayerSign == DOT_X ? "Player" : "Computer";
        }
    }

    private static void turn() {
        if (!isGameOver) {
            if (currentPlayerSign == DOT_X) {
                humanTurn();
            } else {
                compTurn();
            }
        }
    }

    private static void resetGame() {
        System.out.println("Do you want to play again? Yes - press 1, No - press 2");
        if (scanner.nextInt() == 1) {
            isGameOver = false;
            currentPlayerSign = DOT_X;
            actionCounter = 0;
            playTicTacToe();
        }
    }

    private static void humanTurn() {
        int x, y;

        do {
            System.out.println();
            System.out.printf("Please enter cell X-coordinates from 1 to %d\n", SIZE);
            x = scanner.nextInt() - 1;
            System.out.printf("Please enter cell Y-coordinates from 1 to %d\n", SIZE);
            y = scanner.nextInt() - 1;

            if (isCellNotValid(x, y))
                System.out.printf("\n Cell of coordinates [%d, %d] is already occupied.\n", x + 1, y + 1);

        } while (isCellNotValid(x, y));

        map[x][y] = DOT_X;
        actionCounter++;

    }

    private static void compTurn() {
        int x = -1, y = -1;

        do {


            if (checkCentralCell(DOT_O) && level > 1) {
                x = SIZE / 2;
                y = SIZE / 2;
                break;
            }

            if (checkRowToSameChar(map, DOT_O) && level > 1) {
                for (int i = 0; i < SIZE; i++) {
                    if (map[numberFoundLine][i] == DOT_EMPTY) {
                        x = numberFoundLine;
                        y = i;
                        break;
                    }
                }
            } else if (checkColumnToSameChar(map, DOT_O) && level > 1) {
                for (int i = 0; i < SIZE; i++) {
                    if (map[i][numberFoundLine] == DOT_EMPTY) {
                        x = i;
                        y = numberFoundLine;
                        break;
                    }
                }
            } else if (checkDiagonalToSameChar(map, DOT_O) && level > 1) {
                for (int i = 0; i < SIZE; i++, i++) {
                    if (map[i][i] == DOT_EMPTY) {
                        x = i;
                        y = i;
                        break;
                    }
                }
            } else if (checkReverseDiagonalToSameChar(map, DOT_O) && level > 1) {
                for (int i = 0; i < SIZE; i++) {
                    if (map[i][SIZE - 1 - i] == DOT_EMPTY) {
                        x = i;
                        y = SIZE - 1 - i;
                        break;
                    }
                }
            } else if (checkRowToSameChar(map, DOT_X) && level > 1) {
                for (int i = 0; i < SIZE; i++) {
                    if (map[numberFoundLine][i] == DOT_EMPTY) {
                        x = numberFoundLine;
                        y = i;
                        break;
                    }

                }
            } else if (checkColumnToSameChar(map, DOT_X) && level > 1) {
                for (int i = 0; i < SIZE; i++) {
                    if (map[i][numberFoundLine] == DOT_EMPTY) {
                        x = i;
                        y = numberFoundLine;
                        break;
                    }
                }
            } else if (checkDiagonalToSameChar(map, DOT_X) && level > 1) {
                for (int i = 0; i < SIZE; i++) {
                    if (map[i][i] == DOT_EMPTY) {
                        x = i;
                        y = i;
                        break;
                    }
                }
            } else if (checkReverseDiagonalToSameChar(map, DOT_X) && level > 1) {
                for (int i = 0; i < SIZE; i++) {
                    if (map[i][SIZE - 1 - i] == DOT_EMPTY) {
                        x = i;
                        y = SIZE - 1 - i;
                        break;
                    }
                }
            } else {
                x = random.nextInt(SIZE);
                y = random.nextInt(SIZE);
            }

        } while (isCellNotValid(x, y));

        map[x][y] = DOT_O;
        actionCounter++;
        System.out.println();
        System.out.println("Computer decided to choose coordinates " + (x + 1) + " " + (y + 1));

    }

    private static boolean isCellNotValid(int x, int y) {
        if (x < 0 || x >= SIZE || y < 0 || y >= SIZE) {
            return false;
        }
        return map[x][y] != DOT_EMPTY;
    }

    private static boolean checkCentralCell(char dot) {
        return (checkDotOnMap(map, dot) && map[SIZE / 2][SIZE / 2] == DOT_EMPTY);
    }

    private static void checkWin(char dot) {

        for (int i = 0, countCellRowContainDot = 0, countCellColumnContainDot = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == dot) countCellRowContainDot++;
                if (map[j][i] == dot) countCellColumnContainDot++;
            }
            if (countCellRowContainDot == numberCellsWin || countCellColumnContainDot == numberCellsWin) {
                isGameOver = true;
                printWinMessage();
                break;
            } else {
                countCellRowContainDot = 0;
                countCellColumnContainDot = 0;
            }
        }

        for (int i = 0, countCellDiagonalContainDot = 0, countCellReverseDiagonalContainDot = 0; i < SIZE; i++) {
            if (map[i][i] == dot) countCellDiagonalContainDot++;
            if (map[i][SIZE - 1 - i] == dot) countCellReverseDiagonalContainDot++;
            if (countCellDiagonalContainDot == numberCellsWin || countCellReverseDiagonalContainDot == numberCellsWin) {
                isGameOver = true;
                printWinMessage();
                break;
            }
        }

    }

    private static void printWinMessage() {
        System.out.println();
        System.out.printf("The game is over! Winner %s! \n", currentPlayerName);
        System.out.println();
    }

    private static boolean checkDotOnMap(char[][] map, char dot) {
        boolean check = true;

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == dot) {
                    check = false;
                    break;
                }

            }
        }
        return check;
    }

    private static boolean checkRowToSameChar(char[][] map, char dot) {

        boolean check = false;
        for (int i = 0; i < SIZE; i++) {
            int countDot = 0;
            int countAll = 0;

            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] != DOT_EMPTY) countAll++;
            }

            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == dot) countDot++;
                if (countDot == numberCellsWin - 1 && countAll != SIZE) {
                    check = true;
                    numberFoundLine = i;
                }
            }
        }
        return check;
    }

    private static boolean checkColumnToSameChar(char[][] map, char dot) {

        boolean check = false;
        for (int i = 0; i < SIZE; i++) {
            int countDot = 0;
            int countAll = 0;

            for (int j = 0; j < SIZE; j++) {
                if (map[j][i] != DOT_EMPTY) countAll++;
            }

            for (int j = 0; j < SIZE; j++) {
                if (map[j][i] == dot) countDot++;
                if (countDot == numberCellsWin - 1 && countAll != SIZE) {
                    check = true;
                    numberFoundLine = i;
                }
            }
        }
        return check;
    }

    private static boolean checkDiagonalToSameChar(char[][] map, char dot) {

        boolean check = false;
        int countAll = 0;
        int countDot = 0;

        for (int i = 0, j = 0; i < SIZE; i++, j++) {
            if (map[i][j] != DOT_EMPTY) countAll++;
        }

        for (int i = 0; i < SIZE; i++) {
            if (map[i][i] == dot) countDot++;
            if (countDot == numberCellsWin - 1 && countAll != SIZE) check = true;
        }

        return check;
    }

    private static boolean checkReverseDiagonalToSameChar(char[][] map, char dot) {

        boolean check = false;
        int countAll = 0;
        int countDot = 0;

        for (int i = 0, j = SIZE - 1; i < SIZE; i++, j--) {
            if (map[i][j] != DOT_EMPTY) countAll++;
        }

        for (int i = 0, j = SIZE - 1; i < SIZE; i++, j--) {
            if (map[i][j] == dot) countDot++;
            if (countDot == numberCellsWin - 1 && countAll != SIZE) check = true;
        }

        return check;
    }
}
