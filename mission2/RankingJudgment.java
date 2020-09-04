import java.util.ArrayList;

public class RankingJudgment {
    public int[] checkLottoWinning(ArrayList<Lotto> lottoTickets, WinningLotto winning) {
        int[] rankCheck = new int[5];
        for (int i = 0; i < lottoTickets.size(); i++) {
            rankCheck = countRanking(checkOneLotto(lottoTickets.get(i), winning), checkBonus(lottoTickets.get(i), winning), rankCheck);
        }
        return rankCheck;
    }

    public int checkOneLotto(Lotto lotto, WinningLotto winning) {
        int countOfMatch = 0;
        for (int i = 0; i < lotto.getLottoNumbers().size(); i++) {
            countOfMatch = checkLottoMatch(countOfMatch, lotto, winning, i);
        }
        return countOfMatch;
    }

    public int checkLottoMatch(int countOfMatch, Lotto lotto, WinningLotto winning, int i) {
        ArrayList<Integer> container = new ArrayList<>();
        for (int k = 0; k < lotto.getLottoNumbers().size(); k++) {
            container.add(lotto.getLottoNumbers().get(k).getLottoNumber());
        }
        if (container.contains(winning.getLottoNumbers().get(i).getLottoNumber())) {
            countOfMatch++;
        }
        return countOfMatch;
    }

    public boolean checkBonus(Lotto lotto, WinningLotto winning) {
        boolean isBonus = false;
        ArrayList<Integer> container = new ArrayList<>();
        for (int k = 0; k < lotto.getLottoNumbers().size(); k++) {
            container.add(lotto.getLottoNumbers().get(k).getLottoNumber());
        }
        if (container.contains(winning.getBonusNumber())) {
            isBonus = true;
        }
        return isBonus;
    }

    public int[] countRanking(int countOfMatch, boolean isBonus, int[] rankCheck) {
        if (countOfMatch == 3) {
            rankCheck[0]++;
        }
        if (countOfMatch == 4) {
            rankCheck[1]++;
        }
        if (countOfMatch == 5 && isBonus == false) {
            rankCheck[2]++;
        }
        if (countOfMatch == 5 && isBonus == true) {
            rankCheck[3]++;
        }
        if (countOfMatch == 6) {
            rankCheck[4]++;
        }
        return rankCheck;
    }

    public static double calculateProfitPercent(LottoMoney money, int prizeMoney) {
        return (double) prizeMoney / money.getLottoMoney();
    }
}
