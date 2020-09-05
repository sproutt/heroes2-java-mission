package lottodomain;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.instanceOf;

public class LottoGeneratorTest {
    private List<Integer> numbers;

    @Before
    public void setUp() throws Exception {
        numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
    }

    @Test
    public void generateLottoWithNos() {
        assertThat(LottoGenerator.generateLottoWithNos(numbers), instanceOf(Lotto.class));
        Lotto lotto = LottoGenerator.generateLottoWithNos(numbers);
        assertEquals(6, lotto.getLottoNos().size());
    }

    @After
    public void tearDown() throws Exception {
        numbers = null;
    }
}