package MISSION_1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

public class RacingGameTest {
    RacingGame game;
    String input;

    @Before
    public void setUp(){
        game = new RacingGame();
    }

    @Test
    public void readyForStart() {
        input = "Window0, KeyCat, Cloud, Grid, Asong";
        game.readyForStart(input);
        Map<String, Integer> carInfo = game.getCarInfo();
        Set<String> carNames = carInfo.keySet();
        Set<String> expectedCarNames = new HashSet<String>(Arrays.asList(new String[]{"Window0", "KeyCat", "Cloud", "Grid", "Asong"}));

        assertEquals(expectedCarNames, carNames);
    }

    @Test
    public void moveTest() {
        input = "Window0, KeyCat, Cloud, Grid, Asong";
        game.readyForStart(input);

        int lower = 4;
        int upper = 9;
        String car = "Window0";

        Random rand = new Random();
        int condition = rand.nextInt(10);
        game.moveOneCar(condition, car);
        Map<String, Integer> carInfo = game.getCarInfo();

        if(condition>=lower && condition <=upper){
            assertEquals(1, (int) carInfo.get(car));
        }
        if(condition>=0 && condition <=3){
            assertEquals(0, (int) carInfo.get(car));
        }
    }

    @Test
    public void winnerTest(){
        input = "Window0, KeyCat, Cloud, Grid, Asong";
        game.readyForStart(input);
        game.move();

        Map<String, Integer> carInfo = game.getCarInfo();
        int maxValue = (int) Collections.max(carInfo.values());
        String key = getKey(carInfo, maxValue);

        assertEquals(key, game.winner().split(",")[0]);
    }

    @After
    public void cleanUp() { game = null; }

    public <K, V> K getKey(Map<K, V> map, V value) {

        for (K key : map.keySet()) {
            if (value.equals(map.get(key))) {
                return key;
            }
        }
        return null;
    }
}