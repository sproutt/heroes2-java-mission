import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;


public class RacingGameTest {

    Car[] car;

    @Before
    public void setUp() throws Exception {
        car = new Car[3];
    }

    @After
    public void tearDown() throws Exception {
        car = null;
    }

    @Test
    public void inputValidName() {
        InputView inputView = new InputView();
        List<Car> cars = inputView.registerCar("pobi,crong,honux");

        assertThat(cars.get(0).name, is(equalTo("pobi")));
        assertThat(cars.get(1).name, is(equalTo("crong")));
        assertThat(cars.get(2).name, is(equalTo("honux")));
    }

    @Test
    public void playRacingGame() {
        InputView inputView = new InputView();
        RacingGame racingGame = new RacingGame();

        List<Car> cars = inputView.registerCar("pobi,crong,honux");
        racingGame.raceByTime(cars);

        int time = 5;

        for (int i = 0; i < time; i++) {
            racingGame.raceByTime(cars);
        }

        assertThat(cars.get(0).position, instanceOf(int.class));
        assertThat(cars.get(1).position, instanceOf(int.class));
        assertThat(cars.get(2).position, instanceOf(int.class));
    }

    @Test
    public void findGameWinner() {
        InputView inputView = new InputView();
        RacingGame racingGame = new RacingGame();
        GameWinner gameWinner = new GameWinner();

        List<Car> cars = inputView.registerCar("pobi,crong,honux");
        racingGame.raceByTime(cars);

        int time = 5;
        for (int i = 0; i < time; i++) {
            racingGame.raceByTime(cars);
        }

        assertThat(gameWinner.findWinner(cars), is(notNullValue()));
        assertThat(gameWinner.findWinner(cars), instanceOf(List.class));
    }
}