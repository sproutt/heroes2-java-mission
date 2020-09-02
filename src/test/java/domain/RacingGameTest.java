package domain;

import domain.Car;
import domain.RacingGame;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RacingGameTest {
    private static final int TIME_LIMIT = 10;
    RacingGame game;

    public boolean isInRange(int number, int start, int end) {
        return (start <= number && number <= end);
    }


    public List<Integer> getPositionFromCars(List<Car> cars) {
        List<Integer> positions = new ArrayList<>();
        for (int i = 0; i < cars.size(); i++) {
            positions.add(cars.get(i).getPosition());
        }
        return positions;
    }

    @Before
    public void setUp() throws Exception {
        List<String> carNames = Arrays.asList("one", "two", "three");
        game = new RacingGame(TIME_LIMIT, carNames);
    }

    @Test
    public void findWinner() {

    }

    @After
    public void tearDown() throws Exception {
        game = null;
    }
}