package lottodomain;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class LottoAnalyzerTest {
    private static final double DELTA = 1e-15;

    private List<Lotto> lottos;
    private LottoAnalyzer lottoAnalyzer;
    private WinningNos winningNos;

    @Before
    public void setUp() throws Exception {
        lottos = new ArrayList<>();
        lottos.add(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6))); // FIRST
        lottos.add(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7))); // SECOND
        lottos.add(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 8))); // THIRD
        lottos.add(new Lotto(Arrays.asList(1, 2, 3, 4, 7, 8))); // FOURTH
        lottos.add(new Lotto(Arrays.asList(1, 2, 3, 7, 8, 9))); // FIFTH
        lottos.add(new Lotto(Arrays.asList(1, 2, 7, 8, 9, 10))); // MISS
        winningNos = new WinningNos(Arrays.asList(1, 2, 3, 4, 5, 6), 7);
        lottoAnalyzer = new LottoAnalyzer(lottos, winningNos);
    }

    @Test
    public void calculateRankOfLotto() {
        List<Rank> ranks = Arrays.asList(Rank.values());
        for (int i = 0; i < lottos.size(); i++) {
            assertEquals(ranks.get(i), lottoAnalyzer.calculateRankOfLotto(lottos.get(i), winningNos));
        }
    }

    @Test
    public void calculateEarnedMoney() {
        assertEquals(2031555000, lottoAnalyzer.calculateEarnedMoney());
    }

    @Test
    public void calculateEarningRate() {
        assertEquals(33859250.0, lottoAnalyzer.calculateEarningRate(), DELTA);
    }

    @Test
    public void countRank() {
        List<Rank> ranks = Arrays.asList(Rank.values());
        for (int i = 0; i < ranks.size(); i++) {
            assertEquals(1, lottoAnalyzer.countRank(ranks.get(i)));
        }
    }

    @After
    public void tearDown() throws Exception {
        lottos = null;
    }
}