import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int payment = InputView.askPayment(scanner);
        int numberOfManualLottos = InputView.askNumberOfManualLottos(scanner);
        List<List<Integer>> manualNumbers = InputView.askManualLottoNumbers(scanner, numberOfManualLottos);

        LottoGame lottoGame = new LottoGame(payment);
        lottoGame.setManualLottos(numberOfManualLottos, manualNumbers);
        lottoGame.issueAutoLottos();
        OutputView.showAllLottos(lottoGame.getAllLotto(), numberOfManualLottos);

        WinningNumbers winningNumbers = new WinningNumbers(
                InputView.askWinningNumbers(scanner), InputView.askBonusNumber(scanner)
        );
        LottoAnalyzer lottoAnalyzer = lottoGame.getLottoAnalyzer(winningNumbers);
        OutputView.showAnalysis(lottoAnalyzer);
    }
}
