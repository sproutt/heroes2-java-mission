import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.InputMismatchException;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.*;

public class InputCountTest {
    InputCount inputCount1;
    InputCount inputCount2;
    InputCount inputCount3;

    @Before
    public void setUp() throws Exception {
        ByteArrayInputStream properInput = new ByteArrayInputStream("5".getBytes());
        ByteArrayInputStream notNumberInput = new ByteArrayInputStream("notnumber".getBytes());
        ByteArrayInputStream negativeInput = new ByteArrayInputStream("-1".getBytes());
        inputCount1 = new InputCount(properInput);
        inputCount2 = new InputCount(notNumberInput);
        inputCount3 = new InputCount(negativeInput);
    }

    @Test
    public void answerProperCount() {
        try {
            Method askCount = inputCount1.getClass().getDeclaredMethod("askCount");
            askCount.setAccessible(true);
            int count = (int) askCount.invoke(inputCount1);
            assertEquals(5, count);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void answerNotNumberCount() {
        try {
            Method askCount = inputCount2.getClass().getDeclaredMethod("askCount");
            askCount.setAccessible(true);
            askCount.invoke(inputCount2);
        } catch (InvocationTargetException e) {
            assertThat(e.getCause(), instanceOf(InputMismatchException.class));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void answerNegativeCount() {
        String negativeMessage = "[Error] 시도 회수는 0보다 커야 합니다";
        try {
            Method askCount = inputCount3.getClass().getDeclaredMethod("askCount");
            askCount.setAccessible(true);
            askCount.invoke(inputCount3);
        } catch (InvocationTargetException e) {
            assertThat(e.getCause(), instanceOf(InputViewException.class));
            assertEquals(negativeMessage, e.getCause().getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @After
    public void tearDown() throws Exception {
        inputCount1 = null;
        inputCount2 = null;
        inputCount3 = null;
    }
}