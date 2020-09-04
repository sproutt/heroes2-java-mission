import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

public class LottoSettingTest {
    LottoSetting setting;
    LottoMoney money;
    ManualLotto manual;
    InputView input;

    @Before
    public void setUp() throws Exception {
        setting = new LottoSetting();
        money = new LottoMoney(2000);
        manual = new ManualLotto(2, money);
        input = new InputView();
    }

    @Test
    public void setLottoTicketsTest() throws Exception {
        ArrayList<String> manualNumbers = new ArrayList<>();
        manualNumbers.add("1,2,3,10,11,12");
        manualNumbers.add("1,2,3,4,13,14");
        ArrayList<Lotto> lottoTickets = setting.setLottoTickets(manualNumbers, money, manual);
        assertEquals("[1,2,3,10,11,12]", input.viewOneTicket(lottoTickets.get(0)));
        assertEquals("[1,2,3,4,13,14]", input.viewOneTicket(lottoTickets.get(1)));
    }

    @After
    public void tearDown() {
        setting = null;
        money = null;
        manual = null;
        input = null;
    }
}
