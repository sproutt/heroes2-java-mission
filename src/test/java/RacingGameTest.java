import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class RacingGameTest {
    private static final int TIME_LIMIT = 10;
    List<Car> racingCars;
    RacingGame game;

    public boolean isInRange(int number, int start, int end) {
        return (start <= number && number <= end);
    }

    public void setCarsZero(List<Car> cars) {
        for (int i = 0; i < cars.size(); i++) {
            cars.get(i).setPosition(0);
        }
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
        racingCars = new ArrayList<>();
        racingCars.add(new Car("one"));
        racingCars.add(new Car("two"));
        racingCars.add(new Car("three"));
        game = new RacingGame(TIME_LIMIT, racingCars);
    }

    @Test
    public void moveCars() {
        try {
            Method moveCars = game.getClass().getDeclaredMethod("moveCars");
            moveCars.setAccessible(true);
            setCarsZero(racingCars);
            moveCars.invoke(game);
            for (int i = 0; i < racingCars.size(); i++) {
                assertTrue(isInRange(racingCars.get(i).getPosition(), 0, 1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void race() {
        try {
            Method race = game.getClass().getDeclaredMethod("race");
            race.setAccessible(true);
            setCarsZero(racingCars);
            race.invoke(game);
            for (int i = 0; i < racingCars.size(); i++) {
                assertTrue(isInRange(racingCars.get(i).getPosition(), 0, TIME_LIMIT));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void findOneCarByPosition() {
        try {
            Method findCarsByPosition = game.getClass().getDeclaredMethod("findCarsByPosition", int.class, List.class);
            findCarsByPosition.setAccessible(true);
            racingCars.get(0).setPosition(1);
            racingCars.get(1).setPosition(3);
            racingCars.get(2).setPosition(5);
            List<Car> foundCar = (ArrayList<Car>) findCarsByPosition.invoke(game, 5, racingCars);
            assertEquals("three", foundCar.get(0).getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void findCarsByPosition() {
        try {
            Method findCarsByPosition = game.getClass().getDeclaredMethod("findCarsByPosition", int.class, List.class);
            findCarsByPosition.setAccessible(true);
            racingCars.get(0).setPosition(1);
            racingCars.get(1).setPosition(5);
            racingCars.get(2).setPosition(5);
            List<Car> foundCar = (ArrayList<Car>) findCarsByPosition.invoke(game, 5, racingCars);
            List<Integer> foundCarPosition = getPositionFromCars(foundCar);
            assertThat(foundCarPosition, everyItem(is(5)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void findWinner() {
        try {
            Method findWinner = game.getClass().getDeclaredMethod("findWinner");
            findWinner.setAccessible(true);
            setCarsZero(racingCars);
            racingCars.get(1).setPosition(3);
            List<Car> winners = (ArrayList<Car>) findWinner.invoke(game);
            assertEquals("two", winners.get(0).getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @After
    public void tearDown() throws Exception {
        racingCars = null;
        game = null;
    }
}