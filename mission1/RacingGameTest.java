import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

public class RacingGameTest {
    RacingGame r;
    ResultView v;

    @Before
    public void setUp() {
        r = new RacingGame();
        v = new ResultView();
    }

    @Test
    public void carNamesInputTest() {
        String input = "아송, 윈도우, 구름, 그리즈, 키캣";
        assertEquals("아송 윈도우 구름 그리즈 키캣", r.getInputNames(input));
    }

    @Test
    public void winnerTest() {
        ArrayList<Car> cars = new ArrayList<>();
        String input = "아송, 윈도우, 구름, 그리즈, 키캣";
        int number = 1;
        int[] randomNumbers = {1, 3, 5, 8, 2};
        cars = r.registerCarNames(cars, r.nameSet(input));
        assertEquals(" 구름  그리즈 ", r.getWinner(cars, randomNumbers));
    }

    @After
    public void tearDown() {
        r = null;
    }
}