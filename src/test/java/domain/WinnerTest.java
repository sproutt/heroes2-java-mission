package domain;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class WinnerTest {
    private Winner winner;
    private List<Car> candidates;
    private Car car1, car2, car3;

    private void initCandidates() {
        car1 = new Car("one");
        car2 = new Car("two");
        car3 = new Car("three");
        candidates = new ArrayList<>();
        candidates.add(car1);
        candidates.add(car2);
        candidates.add(car3);
    }

    private void repeatCarMove(Car car, int times) {
        for (int i = 0; i < times; i++) {
            car.moveForward();
        }
    }

    @Test
    public void getWinner() {
        initCandidates();
        repeatCarMove(candidates.get(0), 0);
        repeatCarMove(candidates.get(1), 20);
        repeatCarMove(candidates.get(2), 100);
        String expectedWinnerName = candidates.get(2).getName();
        winner = new Winner(candidates);
        assertEquals(expectedWinnerName, winner.getWinners().get(0).getName());
    }

    @Test
    public void getWinners() {
        initCandidates();
        String[] expectedWinnerNames = {"one", "two", "three"};
        winner = new Winner(candidates);
        List<String> resultWinnerNames = winner.getWinners().stream().map(winner -> winner.getName()).collect(Collectors.toList());
        assertArrayEquals(expectedWinnerNames, resultWinnerNames.toArray());
    }

    @After
    public void tearDown() throws Exception {
        winner = null;
        car1 = null;
        car2 = null;
        car3 = null;
        candidates = null;
    }
}