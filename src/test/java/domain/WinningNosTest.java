package domain;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class WinningNosTest {
    private WinningNos winningNos;

    @Before
    public void setUp() throws Exception {
        winningNos = new WinningNos(Arrays.asList(1, 2, 3, 4, 5, 6), 7);
    }

    @Test
    public void countMatchOf() {
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(Arrays.asList(8, 9, 10, 11, 12, 13)));
        lottos.add(new Lotto(Arrays.asList(1, 8, 9, 10, 11, 12)));
        lottos.add(new Lotto(Arrays.asList(1, 2, 9, 10, 11, 12)));
        lottos.add(new Lotto(Arrays.asList(1, 2, 3, 10, 11, 12)));
        lottos.add(new Lotto(Arrays.asList(1, 2, 3, 4, 11, 12)));
        lottos.add(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 12)));
        lottos.add(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)));

        for (int i = 0; i < lottos.size(); i++) {
            assertEquals(i, winningNos.countMatchOf(lottos.get(i)));
        }
    }

    @Test
    public void isBonus() {
        Lotto trueLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
        Lotto falseLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6, 8));

        assertTrue(winningNos.isBonus(trueLotto));
        assertFalse(winningNos.isBonus(falseLotto));
    }

    @After
    public void tearDown() throws Exception {
        winningNos = null;
    }
}