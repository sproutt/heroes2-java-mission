import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WinningLottoTest {
    WinningLotto winning;

    @Before
    public void setUp() throws Exception {
        winning = new WinningLotto("1,2,3,4,5,6");
        winning.setBonusNumber(7);
    }

    @Test
    public void setWinningNumberTest() {
        for(int i=0, winningNumber=1 ;i<winning.getLottoNumbers().size() ; i++,winningNumber++){
            assertEquals(winningNumber,winning.getLottoNumbers().get(i).getLottoNumber());
        }
    }
    @Test
    public void setBonusNumberTest() {
            assertEquals(7,winning.getBonusNumber());
    }

    @After
    public void tearDown() {
        winning = null;
    }
}
