package lottodomain;

import org.junit.Test;

import static org.junit.Assert.*;

public class RankTest {
    @Test
    public void valueOf() {
        assertEquals(Rank.FIRST, Rank.valueOf(6, false));
        assertEquals(Rank.SECOND, Rank.valueOf(5, true));
        assertEquals(Rank.THIRD, Rank.valueOf(5, false));
        assertEquals(Rank.FOURTH, Rank.valueOf(4, false));
        assertEquals(Rank.FIFTH, Rank.valueOf(3, false));
        assertEquals(Rank.MISS, Rank.valueOf(1, false));
    }
}