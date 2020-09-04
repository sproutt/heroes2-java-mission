import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        try{
        InputView input = new InputView();
        LottoMoney money = new LottoMoney(input.setLottoMoney());
        ManualLotto manual = new ManualLotto(input.setManualLotto(),money);
        LottoSetting tickets=new LottoSetting();

        input.viewManualNumber();
        ArrayList<Lotto> lottoTickets=tickets.setLottoTickets(manual.putManualNumber(),money, manual);
        input.viewTicketsCheck(lottoTickets,manual.getManualLottoNumber(),tickets.checkAutoNumber(manual,money));
        WinningLotto winning=new WinningLotto(input.setWinningLotto());
        winning.setBonusNumber(input.setBonusBall());

        ResultView result=new ResultView();
        RankingJudgment ranking=new RankingJudgment();
        int[] rankCheck=ranking.checkLottoWinning(lottoTickets,winning);
        result.viewResult(rankCheck);
        result.viewProfitPercent(money,Rank.calculateWinningMoney(rankCheck));}
        catch(Exception e) {
            e.printStackTrace();
        }
    }
}
