package Java3.Lesson6.test;

import Java3.Lesson6.Task1;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

public class Task1Test {

    private Task1 task1;

    private int[] in;
    private int[] out;


    @BeforeEach
    public void setUp() {
        task1 = new Task1();
    }



    @Test
    public void shouldRetrieveCurrentArrAfterLast4() {
        in = new int[]{5, 3, 4, 1, 2};
        out = new int[]{1, 2};
        Assertions.assertNotNull(in);
        Assertions.assertArrayEquals(out, task1.AfterLast4(in), "34");
    }


    @Test
    void shouldThrowExceptionAfterLast4() {

        Assertions.assertThrows(RuntimeException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                in = new int[]{5, 3, 6, 1, 2};
                task1.AfterLast4(in);
            }
        });
    }


}