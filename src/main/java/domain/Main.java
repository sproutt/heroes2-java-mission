package domain;

import view.InputView;
import view.OutputView;
import view.ViewException;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            int payment = InputView.askPayment(scanner);
            int numberOfManualLottos = InputView.askNumberOfManualLottos(scanner);
            List<List<Integer>> manualNumbers = InputView.askManualLottoNos(scanner, numberOfManualLottos);

            LottoGame lottoGame = new LottoGame(payment, manualNumbers);
            OutputView.showAllLottos(lottoGame.getAllLotto(), numberOfManualLottos);

            WinningNos winningNos = new WinningNos(
                    InputView.askWinningNos(scanner), InputView.askBonusNo(scanner)
            );
            LottoAnalyzer lottoAnalyzer = lottoGame.getLottoAnalyzer(winningNos);
            OutputView.showAnalysis(lottoAnalyzer);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
