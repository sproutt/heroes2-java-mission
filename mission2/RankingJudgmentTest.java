import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

public class RankingJudgmentTest {
    LottoSetting setting;
    LottoMoney money;
    ManualLotto manual;
    InputView input;
    RankingJudgment ranking;
    WinningLotto winning;
    Rank rank;

    @Before
    public void setUp() throws Exception {
        setting = new LottoSetting();
        money = new LottoMoney(1000);
        manual = new ManualLotto(1, money);
        input = new InputView();
        ranking = new RankingJudgment();
        winning = new WinningLotto("1,2,3,4,5,6");
        winning.setBonusNumber(7);
    }

    @Test
    public void rankTest() throws Exception {
        ArrayList<String> manualNumbers = new ArrayList<>();
        manualNumbers.add("1,2,9,10,11,12");
        manualNumbers.add("1,2,3,8,9,10");
        manualNumbers.add("1,2,3,4,8,9");
        manualNumbers.add("1,2,3,4,5,8");
        manualNumbers.add("1,2,3,4,5,7");
        manualNumbers.add("1,2,3,4,5,6");
        ArrayList<Lotto> lottoTickets = setting.setLottoTickets(manualNumbers, money, manual);
        assertEquals(Rank.MISS, rank.valueOf(ranking.checkOneLotto(lottoTickets.get(0), winning), ranking.checkBonus(lottoTickets.get(0), winning)));
        assertEquals(Rank.FIFTH, rank.valueOf(ranking.checkOneLotto(lottoTickets.get(1), winning), ranking.checkBonus(lottoTickets.get(1), winning)));
        assertEquals(Rank.FOURTH, rank.valueOf(ranking.checkOneLotto(lottoTickets.get(2), winning), ranking.checkBonus(lottoTickets.get(2), winning)));
        assertEquals(Rank.THIRD, rank.valueOf(ranking.checkOneLotto(lottoTickets.get(3), winning), ranking.checkBonus(lottoTickets.get(3), winning)));
        assertEquals(Rank.SECOND, rank.valueOf(ranking.checkOneLotto(lottoTickets.get(4), winning), ranking.checkBonus(lottoTickets.get(4), winning)));
        assertEquals(Rank.FIRST, rank.valueOf(ranking.checkOneLotto(lottoTickets.get(5), winning), ranking.checkBonus(lottoTickets.get(5), winning)));
    }

    @Test
    public void profitPercentTest() throws Exception {
        ArrayList<String> manualNumbers = new ArrayList<>();
        manualNumbers.add("1,2,3,10,11,12");
        ArrayList<Lotto> lottoTickets = setting.setLottoTickets(manualNumbers, money, manual);
        int[] rankCheck = ranking.checkLottoWinning(lottoTickets, winning);
        assertEquals(5, ranking.calculateProfitPercent(money, Rank.calculateWinningMoney(rankCheck)));
    }

    @After
    public void tearDown() {
        setting = null;
        money = null;
        manual = null;
        input = null;
        ranking = null;
        winning = null;
    }
}
