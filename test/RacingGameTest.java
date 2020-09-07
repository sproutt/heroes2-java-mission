import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class RacingGameTest {
        List<Car> cars;
        RacingGame racingGame;
    @Before
    public void setUp() throws Exception {
        cars = new ArrayList<>();
        cars.add(new Car("애플"));
        cars.add(new Car("삼성"));
        cars.add(new Car("전남대"));
        racingGame = new RacingGame();
    }

    @Test
    public void race() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method goOrStay = racingGame.getClass().getDeclaredMethod("goOrStay", Car.class);
        goOrStay.setAccessible(true);
        for(Car car: cars) {
            goOrStay.invoke(racingGame, car);
        }
    }

    @Test
    public void getWinner() {
        cars.get(0).goForward();
        cars.get(1).goForward();
        List<String> expectedWinnerNames = new ArrayList<>();
        expectedWinnerNames.add("애플");
        expectedWinnerNames.add("삼성");
        List<String> actualWinnerNames = racingGame.getWinner(cars);
        assertThat(actualWinnerNames,is(expectedWinnerNames));
    }

    @After
    public void tearDown() throws Exception {
        cars = null;
    }
}