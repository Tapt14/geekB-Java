package Java3.Lesson6.test;

import Java3.Lesson6.Task2;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Task2Test {

    private int[] in;
    private boolean out;
    private Task2 task2;


    @BeforeEach
    public void startTest() {
        task2 = new Task2();
    }

    @Test
    public void shouldCurrentOnly1And4() {
        in = new int[]{1, 1, 4, 4, 4, 1, 4, 1};
        out = true;
        Assertions.assertEquals(task2.Only1And4(in), out);
    }

}
