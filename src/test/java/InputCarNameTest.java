import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class InputCarNameTest {
    InputCarName inputCarName;

    @Before
    public void setUp() throws Exception {
        inputCarName = new InputCarName(System.in);
    }

    @Test
    public void checkLengthLimit() {
        int maxLength = 5;
        String message = "[Error] 자동차의 이름은 " + maxLength + "자 이하여야 합니다.";
        try {
            Method checkLengthLimit = inputCarName.getClass().getDeclaredMethod("checkLengthLimit", String.class);
            checkLengthLimit.setAccessible(true);
            checkLengthLimit.invoke(inputCarName, "thisismorethanlimit");
        } catch (InvocationTargetException e) {
            assertThat(e.getCause(), instanceOf(InputViewException.class));
            assertEquals(message, e.getCause().getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void parseProperString() {
        try {
            Method parseString = inputCarName.getClass().getDeclaredMethod("parseString", String.class);
            parseString.setAccessible(true);
            List<String> carNames = (ArrayList<String>) parseString.invoke(inputCarName, "aaa,bbb,ccc");
            String[] expected = {"aaa", "bbb", "ccc"};
            assertArrayEquals(expected, carNames.toArray());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void parseEmptyString() {
        String message = "[Error] 자동차의 이름을 하나 이상 입력하세요";
        try {
            Method parseString = inputCarName.getClass().getDeclaredMethod("parseString", String.class);
            parseString.setAccessible(true);
            parseString.invoke(inputCarName, "");
        } catch (InvocationTargetException e) {
            assertThat(e.getCause(), instanceOf(InputViewException.class));
            assertEquals(message, e.getCause().getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @After
    public void tearDown() throws Exception {
        inputCarName = null;
    }
}