import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class LottoGameTest {
    private LottoGame lottoGame;
    List<List<Integer>> manualLottoNumbers;

    @Before
    public void setUp() throws Exception {
        manualLottoNumbers = new ArrayList<>();
        manualLottoNumbers.add(Arrays.asList(1, 2, 3, 4, 5, 6));
        manualLottoNumbers.add(Arrays.asList(1, 4, 11, 15, 19, 23));
        manualLottoNumbers.add(Arrays.asList(4, 10, 17, 25, 34, 42));
    }

    @Test
    public void setManualLottos() {
        lottoGame = new LottoGame(10000);
        lottoGame.setManualLottos(3, manualLottoNumbers);
        assertEquals(3, lottoGame.getAllLotto().size());
    }

    @Test
    public void issueAllAutoLottos() {
        lottoGame = new LottoGame(10000);
        assertEquals(10, lottoGame.issueAutoLottos().size());
        assertEquals(10, lottoGame.getAllLotto().size());
    }

    @Test
    public void issueAutoLottos() {
        lottoGame = new LottoGame(10000);
        lottoGame.setManualLottos(3, manualLottoNumbers);
        assertEquals(7, lottoGame.issueAutoLottos().size());
        assertEquals(10, lottoGame.getAllLotto().size());
    }

    @After
    public void tearDown() throws Exception {
        lottoGame = null;
        manualLottoNumbers = null;
    }
}