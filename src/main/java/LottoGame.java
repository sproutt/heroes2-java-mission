import java.util.ArrayList;
import java.util.List;

public class LottoGame {
    static final int PRICE_PER_LOTTO = 1000;

    private List<Lotto> allLottos;
    private int numberOfManualLotto;
    private int inputMoney;

    public LottoGame(int inputMoney) {
        allLottos = new ArrayList<>();
        this.inputMoney = inputMoney;
        numberOfManualLotto = 0;
    }

    public void setManualLottos(int numberOfManualLotto, List<List<Integer>> manualLottoNumbers) {
        this.numberOfManualLotto = numberOfManualLotto;
        // TODO numberOfManualLotto와 manualLottoNumbers의 길이가 일치하지 않는 상황에 대한 예외처리
        for (int i = 0; i < numberOfManualLotto ; i++) {
            allLottos.add(LottoGenerator.generateLottoWithNos(manualLottoNumbers.get(i)));
        }
    }

    public List<Lotto> issueAutoLottos() {
        int numberOfAutoLottos = inputMoney / PRICE_PER_LOTTO - numberOfManualLotto;
        List<Lotto> autoLottos = new ArrayList<>();
        for (int i = 0; i < numberOfAutoLottos ; i++) {
            autoLottos.add(LottoGenerator.generateAutoLotto());
        }
        allLottos.addAll(autoLottos);
        return autoLottos;
    }

    public List<Lotto> getAllLottos() {
        return allLottos;
    }

}
