package Java2.Lesson2;

public class arrayString4to4 {

    private int sum = 0;

    public void check() {

        String[][] array = initializationArray();

        try {
            checkArray(array);
        } catch (MyArraySizeException myArraySizeException) {
            System.err.println("\n" + myArraySizeException);
        }
        catch (MyArrayDataException myArrayDataException) {
            System.err.println("\n" + myArrayDataException);
        }
        finally {
            System.out.printf("\nSum of cell values: %d", sum);
        }

        System.out.println("");
    }

    private String[][] initializationArray() {
        return new String[][]{{ "1", "1", "1", "1"}, {"1", "s", "1", "1"}, {"1", "1", "1", "1"}, {"1", "1", "1", "1"}};
    }

    private void checkArray(String[][] array) throws MyArraySizeException, MyArrayDataException{
        for (String[] strings : array) {
            if (array.length != 4 || array.length != strings.length) {
                throw new MyArraySizeException("Array size is not 4x4. Please, input correct size.");
            }
        }


            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array[i].length; j++) {
                    try {
                        sum += Integer.parseInt(array[i][j]);
                    }
                    catch (NumberFormatException numberFormatException) {
                        throw new MyArrayDataException("The cell " +  i + " " + j + " contains next value: " + array[i][j] +". It's not integer.");
                    }
                }
            }
    }
}
