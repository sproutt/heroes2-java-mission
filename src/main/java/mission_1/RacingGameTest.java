package MISSION_1;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Collections;
import java.util.Random;

import java.util.ArrayList;
import java.util.Iterator;

public class RacingGameTest {
    RacingGame game;
    String input;

    @Before
    public void setUp(){
        game = new RacingGame();
    }

    @Test
    public void setCarTest() {
        input = "Window0, KeyCat, Cloud, Grid, Asong";
        game.setCar(input);

        ArrayList<String> car = game.getCar();
        Iterator<String> itr = car.iterator();

        assertEquals("Window0", itr.next());
        assertEquals("KeyCat", itr.next());
        assertEquals("Cloud", itr.next());
        assertEquals("Grid", itr.next());
        assertEquals("Asong", itr.next());
    }

    @Test
    public void moveTest() {
        game.move();
        ArrayList<String> carPosition = game.getCarPosition();
        Iterator<String> itr = carPosition.iterator();

        Random rand = new Random();
        while(itr.hasNext()){
            int condition = rand.nextInt(10);
            if(condition>=4 && condition <=9){
                assertEquals(1, itr.next());
            }
            if(condition>=0 && condition <=3){
                assertEquals(0, itr.next());
            }
        }
    }

    @Test
    public void winnerTest(){
        input = "Window0, KeyCat, Cloud, Grid, Asong";
        game.setCar(input);
        game.move();

        ArrayList<Integer> carPosition = game.getCarPosition();
        Integer maxValue = (Integer) Collections.max(carPosition);
        assertEquals(game.getCar().get(carPosition.indexOf(maxValue)),
                game.winner().split(",")[0]);
    }
    @After
    public void cleanUp() { game = null; }
}