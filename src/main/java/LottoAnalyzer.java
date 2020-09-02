import java.util.List;
import java.util.stream.Collectors;

public class LottoAnalyzer {
    private static final int PRICE_PER_LOTTO = 1000;
    private static final int PERCENTAGE = 100;

    private List<Lotto> lottos;
    private List<WinningLotto> winningLottos;

    public LottoAnalyzer(List<Lotto> lottos, WinningNumbers winningNumbers) {
        this.lottos = lottos;
        winningLottos = lottos.stream().map(lotto -> new WinningLotto(lotto, getRankOfLotto(lotto, winningNumbers)))
                .collect(Collectors.toList());
    }

    public List<WinningLotto> getWinningLotto() {
        return winningLottos;
    }

    public Rank getRankOfLotto(Lotto lotto, WinningNumbers winningNumbers) {
        int countOfMatch = winningNumbers.getWinningNumbers().stream()
                .filter(lotto::contains).collect(Collectors.toList()).size();
        boolean matchBonus = lotto.contains(winningNumbers.getBonusNumber());
        return Rank.valueOf(countOfMatch, matchBonus);
    }

    public double calculateEarningRate() {
        // TODO winningLottos가 null인 경우 에러처리
        int inputMoney = lottos.size() * PRICE_PER_LOTTO;
        double earnedMoney = calculateEarnedMoney();
        return Math.round(earnedMoney / inputMoney * PERCENTAGE * 10) / 10.0;
    }

    public int calculateEarnedMoney() {
        // TODO winningLottos가 null인 경우 에러처리
        List<Integer> winningMoneys = winningLottos.stream()
                .map(winningLotto -> winningLotto.getLottoPrize().getWinningMoney())
                .collect(Collectors.toList());
        return winningMoneys.stream().reduce(0, (accumalation, current) -> accumalation + current);
    }

    public int countRank(Rank findingRank) {
        return (int) winningLottos.stream().map(WinningLotto::getLottoPrize)
                .filter(rank -> rank.equals(findingRank)).count();
    }
}
