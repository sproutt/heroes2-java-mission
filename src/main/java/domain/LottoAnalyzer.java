package domain;

import java.util.List;
import java.util.stream.Collectors;

public class LottoAnalyzer {
    private static final int PRICE_PER_LOTTO = 1000;
    private static final int PERCENTAGE = 100;

    private List<Lotto> lottos;
    private List<WinningLotto> winningLottos;

    public LottoAnalyzer(List<Lotto> lottos, WinningNos winningNos) {
        this.lottos = lottos;
        winningLottos = lottos.stream().map(lotto -> new WinningLotto(lotto, calculateRankOfLotto(lotto, winningNos)))
                .collect(Collectors.toList());
    }

    public Rank calculateRankOfLotto(Lotto lotto, WinningNos winningNos) {
        int countOfMatch = winningNos.countMatchOf(lotto);
        boolean matchBonus = winningNos.isBonus(lotto);
        return Rank.valueOf(countOfMatch, matchBonus);
    }

    public double calculateEarningRate() {
        int inputMoney = lottos.size() * PRICE_PER_LOTTO;
        double earnedMoney = calculateEarnedMoney();
        return Math.round(earnedMoney / inputMoney * PERCENTAGE * 10) / 10.0;
    }

    public int calculateEarnedMoney() {
        List<Integer> winningMoneys = winningLottos.stream()
                .map(winningLotto -> winningLotto.getLottoPrize().getWinningMoney())
                .collect(Collectors.toList());
        return winningMoneys.stream().reduce(0, (accumulation, current) -> accumulation + current);
    }

    public int countRank(Rank findingRank) {
        return (int) winningLottos.stream().map(WinningLotto::getLottoPrize)
                .filter(rank -> rank.equals(findingRank)).count();
    }
}
