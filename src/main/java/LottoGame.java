import java.util.ArrayList;
import java.util.List;

public class LottoGame {
    private static final int PRICE_PER_LOTTO = 1000;

    private List<Lotto> allLotto;
    private int numberOfAllLotto;
    private int numberOfManualLotto;

    public LottoGame(int inputMoney) {
        allLotto = new ArrayList<>();
        numberOfAllLotto = inputMoney / PRICE_PER_LOTTO;
        numberOfManualLotto = 0;
    }

    public void setManualLottos(int numberOfManualLotto, List<List<Integer>> manualLottoNumbers) {
        this.numberOfManualLotto = numberOfManualLotto;
        // TODO numberOfManualLotto와 manualLottoNumbers의 길이가 일치하지 않는 상황에 대한 예외처리
        for (int i = 0; i < numberOfManualLotto ; i++) {
            allLotto.add(LottoGenerator.generateLottoWithNos(manualLottoNumbers.get(i)));
        }
    }

    public List<Lotto> issueAutoLottos() {
        int numberOfAutoLottos = numberOfAllLotto - numberOfManualLotto;
        List<Lotto> autoLottos = new ArrayList<>();
        for (int i = 0; i < numberOfAutoLottos ; i++) {
            autoLottos.add(LottoGenerator.generateAutoLotto());
        }
        allLotto.addAll(autoLottos);
        return autoLottos;
    }

    public LottoAnalyzer getLottoAnalyzer(WinningNumbers winningNumbers) {
        return new LottoAnalyzer(allLotto, winningNumbers);
    }

    public List<Lotto> getAllLotto() {
        return allLotto;
    }

}
