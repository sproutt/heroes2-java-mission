package lottodomain;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.*;

public class LottoTest {
    private Lotto lotto;
    private List<Integer> lottoNos = Arrays.asList(1, 2, 3, 4, 5, 6);

    @Before
    public void setUp() throws Exception {
        lotto = new Lotto(lottoNos);
    }

    @Test
    public void getLottoNos() {
        lotto.getLottoNos().stream().forEach(lottoNo -> assertThat(lottoNo, instanceOf(LottoNo.class)));
        assertEquals(6, lotto.getLottoNos().size());
    }

    @Test
    public void contains() {
        assertTrue(lotto.contains(new LottoNo(1)));
        assertTrue(lotto.contains(new LottoNo(2)));
        assertTrue(lotto.contains(new LottoNo(3)));
        assertTrue(lotto.contains(new LottoNo(4)));
        assertTrue(lotto.contains(new LottoNo(5)));
        assertTrue(lotto.contains(new LottoNo(6)));
        assertFalse(lotto.contains(new LottoNo(0)));
        assertFalse(lotto.contains(new LottoNo(7)));
    }

    @Test
    public void testEquals() {
        Lotto sameLotto = new Lotto(lottoNos);
        Lotto otherLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7));

        assertTrue(lotto.equals(sameLotto));
        assertFalse(lotto.equals(otherLotto));
    }

    @After
    public void tearDown() throws Exception {
        lotto = null;
        lottoNos = null;
    }
}