package domain;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {
    private static final int PRICE_PER_LOTTO = 1000;

    private List<Lotto> allLotto;
    private int numberOfAllLotto;

    public LottoGame(int inputMoney, List<List<Integer>> manualLottoNos) {
        numberOfAllLotto = inputMoney / PRICE_PER_LOTTO;
        allLotto = issueLottos(manualLottoNos);
    }

    public LottoAnalyzer getLottoAnalyzer(WinningNos winningNos) {
        return new LottoAnalyzer(allLotto, winningNos);
    }

    public List<Lotto> getAllLotto() {
        return allLotto;
    }

    private List<Lotto> issueLottos(List<List<Integer>> manualLottoNos) {
        List<Lotto> lottos = issueManualLottos(manualLottoNos);
        lottos.addAll(issueAutoLottos(numberOfAllLotto - lottos.size()));
        return lottos;
    }

    private List<Lotto> issueManualLottos(List<List<Integer>> manualLottoNos) {
        List<Lotto> ManualLottos = new ArrayList<>();
        for (int i = 0; i < manualLottoNos.size(); i++) {
            ManualLottos.add(LottoGenerator.generateLottoWithNos(manualLottoNos.get(i)));
        }
        return ManualLottos;
    }

    private List<Lotto> issueAutoLottos(int numberOfAutoLottos) {
        List<Lotto> autoLottos = new ArrayList<>();
        for (int i = 0; i < numberOfAutoLottos; i++) {
            autoLottos.add(LottoGenerator.generateAutoLotto());
        }
        return autoLottos;
    }
}
