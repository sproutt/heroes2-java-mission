package lottoview;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InputView {
    public static int askPayment(Scanner scanner) throws ViewException {
        System.out.println("구입금액을 입력해 주세요.");
        int payment = scanner.nextInt();
        InputValidation.validatePayment(payment);

        scanner.nextLine();
        System.out.println();
        return payment;
    }

    public static int askNumberOfManualLottos(Scanner scanner) throws ViewException {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        int numberOfManualLottos = scanner.nextInt();
        InputValidation.validateNumberOfLottos(numberOfManualLottos);

        scanner.nextLine();
        System.out.println();
        return numberOfManualLottos;
    }

    public static List<List<Integer>> askManualLottoNos(Scanner scanner, int manualCount) throws ViewException {
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        List<List<Integer>> manualLottoNos = new ArrayList<>();
        for (int i = 0; i < manualCount; i++) {
            String numberText = scanner.nextLine();
            manualLottoNos.add(parseNos(numberText));
        }
        InputValidation.validateAllLottoNos(manualLottoNos);

        System.out.println();
        return manualLottoNos;
    }

    public static List<Integer> askWinningNos(Scanner scanner) throws ViewException {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String numberText = scanner.nextLine();

        List<Integer> winningNos = parseNos(numberText);
        InputValidation.validateLottoNos(winningNos);
        return winningNos;
    }

    public static int askBonusNo(Scanner scanner) throws ViewException {
        System.out.println("보너스 볼을 입력해 주세요.");
        int bonusNo = scanner.nextInt();
        InputValidation.validateNoRange(bonusNo);
        scanner.nextLine();
        return bonusNo;
    }

    private static List<Integer> parseNos(String numberText) {
        return Stream.of(numberText.split(","))
                .map(number -> Integer.parseInt(number.trim())).collect(Collectors.toList());
    }
}
