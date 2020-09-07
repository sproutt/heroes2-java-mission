import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

public class InputViewTest {
    List<Car> cars;
    @Before
    public void setUp() throws Exception {
        cars = new ArrayList<>();
        cars.add(new Car("애플"));
        cars.add(new Car("삼성"));
        cars.add(new Car("전남대"));
    }

    @Test
    public void inputCarName() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        String carName = "애플, 삼성, 전남대";
        InputView inputView = new InputView();
        try {
            Method methodsplit = inputView.getClass().getDeclaredMethod("splitInputCarName", String.class);
            methodsplit.setAccessible(true);
            Method methodtrim = inputView.getClass().getDeclaredMethod("trimInputCarName", String[].class);
            methodtrim.setAccessible(true);
            String[] name = (String[]) methodsplit.invoke(inputView, carName);
            String[] name1 = (String[]) methodtrim.invoke(inputView, (Object) name);
            assertThat("애플", is(name1[0]));
            assertThat("삼성", is(name1[1]));
            assertThat("전남대", is(name1[2]));
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void inputTrial() {

    }

    @After
    public void tearDown() throws Exception {
        cars = null;
    }
}