package lottodomain;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class LottoGameTest {
    private LottoGame lottoGame;
    List<List<Integer>> manualLottoNumbers;

    private void assertArrayEquals(List<Lotto> expectedLottos, List<Lotto> subList) {
        for (int i = 0; i < expectedLottos.size(); i++) {
            assertEquals(expectedLottos.get(i), subList.get(i));
        }
    }

    @Before
    public void setUp() throws Exception {
        manualLottoNumbers = new ArrayList<>();
        manualLottoNumbers.add(Arrays.asList(1, 2, 3, 4, 5, 6));
        manualLottoNumbers.add(Arrays.asList(1, 4, 11, 15, 19, 23));
        manualLottoNumbers.add(Arrays.asList(4, 10, 17, 25, 34, 42));
    }

    @Test
    public void setManualLottos() {
        lottoGame = new LottoGame(10000, manualLottoNumbers);
        assertEquals(10, lottoGame.getAllLotto().size());

        List<Lotto> expectedLottos = manualLottoNumbers.stream().map(numbers -> LottoGenerator.generateLottoWithNos(numbers))
                .collect(Collectors.toList());
        assertArrayEquals(expectedLottos, lottoGame.getAllLotto().subList(0, 3));
    }

    @After
    public void tearDown() throws Exception {
        lottoGame = null;
        manualLottoNumbers = null;
    }
}