import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

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
        Car[] car = inputView.registerCar("pobi,crong,honux");

        assertThat(car[0].name, is(equalTo("pobi")));
        assertThat(car[1].name, is(equalTo("crong")));
        assertThat(car[2].name, is(equalTo("honux")));
    }

    @Test
    public void playRacingGame() {
        InputView inputView = new InputView();
        RacingGame racingGame = new RacingGame();

        Car[] car = inputView.registerCar("pobi,crong,honux");
        racingGame.raceByTime(car);

        int time = 5;

        for (int i = 0; i < time; i++) {
            racingGame.raceByTime(car);
        }

        assertThat(car[0].position, instanceOf(int.class));
        assertThat(car[1].position, instanceOf(int.class));
        assertThat(car[2].position, instanceOf(int.class));
    }

    @Test
    public void findGameWinner() {
        InputView inputView = new InputView();
        RacingGame racingGame = new RacingGame();
        GameWinner gameWinner = new GameWinner();

        Car[] car = inputView.registerCar("pobi,crong,honux");
        racingGame.raceByTime(car);

        int time = 5;
        for (int i = 0; i < time; i++) {
            racingGame.raceByTime(car);
        }

        assertThat(gameWinner.findWinner(car), is(notNullValue()));
        assertThat(gameWinner.findWinner(car), instanceOf(ArrayList.class));
    }
}