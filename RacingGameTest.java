import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class RacingGameTest {
    RacingGame r;
    ResultView v;
    @Before
    public void setUp() {
        r = new RacingGame();
        v= new ResultView();
    }

    @Test
    public void carNamesInputTest() {
        String input="아송, 윈도우, 구름, 그리즈, 키캣";
        assertEquals("아송 윈도우 구름 그리즈 키캣",r.getInputNames(input));
    }

    @Test
    public void randomToNumberTest() {
        int[] randomNumbers={1,3,5,8};
        assertEquals("0 0 1 1 ", r.getRandomToNumber(randomNumbers));
    }

    @Test
    public void winnerTest() {
        String input="아송, 윈도우, 구름, 그리즈, 키캣";
        String[] carNames = r.nameSet(input);
        int[] randomNumbers={1,3,5,8,2};
        assertEquals(" 구름  그리즈 ", r.getWinner(input,carNames,randomNumbers));
    }

    @After
    public void tearDown() {
        r = null;
    }
}