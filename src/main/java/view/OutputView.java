package view;

import domain.Lotto;
import domain.LottoAnalyzer;
import domain.LottoNo;
import domain.Rank;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class OutputView {
    public static void showAllLottos(List<Lotto> allLotto, int numberOfManualLottos) {
        int numberOfAutoLottos = allLotto.size() - numberOfManualLottos;
        System.out.printf("수동으로 %d장, 자동으로 %d장을 구매했습니다.\n", numberOfManualLottos, numberOfAutoLottos);
        allLotto.stream().forEach(lotto -> showLotto(lotto));
    }

    public static void showLotto(Lotto lotto) {
        System.out.println(lotto.getLottoNos().stream().map(LottoNo::getValue).map(number -> number.toString())
                .collect(Collectors.joining(", ", "[", "]")));
    }

    public static void showAnalysis(LottoAnalyzer lottoAnalyzer) {
        showWRanks(lottoAnalyzer);
        showEarningRate(lottoAnalyzer.calculateEarningRate());
    }

    public static void showRankCount(Rank rank, int count) {
        System.out.printf("%d개 일치 (%d원)- %d개\n", rank.getCountOfMatch(), rank.getWinningMoney(), count);
    }

    public static void showEarningRate(double earningRate) {
        System.out.printf("총 수익률은 %.1f%%입니다.\n", earningRate);
    }

    private static void showWRanks(LottoAnalyzer lottoAnalyzer) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        List<Rank> prize = Stream.of(Rank.values()).collect(Collectors.toList());
        prize.remove(Rank.MISS);
        for (int i = prize.size() - 1; i >= 0 ; i--) {
            int count = lottoAnalyzer.countRank(prize.get(i));
            showRankCount(prize.get(i), count);
        }
    }
}
