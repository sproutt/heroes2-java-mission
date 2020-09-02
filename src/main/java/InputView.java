import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InputView {
    public static int askPayment(Scanner scanner) {
        System.out.println("구입금액을 입력해 주세요.");
        int payment = scanner.nextInt();
        // TODO payment가 1000원단위가 아닐 때 예외 처리
        scanner.nextLine();
        System.out.println();
        return payment;
    }

    public static int askNumberOfManualLottos(Scanner scanner) {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        int NumberOfManualLottos = scanner.nextInt();
        // TODO 음수일 경우 예외처리
        scanner.nextLine();
        System.out.println();
        return NumberOfManualLottos;
    }

    public static List<List<Integer>> askManualLottoNumbers(Scanner scanner, int manualCount) {
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        List<List<Integer>> manualLottoNumbers = new ArrayList<>();
        for (int i = 0; i < manualCount; i++) {
            String numberText = scanner.nextLine();
            // TODO 숫자가 아닌 입력이 들어온 경우 예외처리
            manualLottoNumbers.add(parseNumber(numberText));
        }
        System.out.println();
        return manualLottoNumbers;
    }

    public static List<Integer> askWinningNumbers(Scanner scanner) {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String numberText = scanner.nextLine();
        // TODO 숫자가 아닌 입력이 들어온 경우 예외처리
        return parseNumber(numberText);
    }

    public static int askBonusNumber(Scanner scanner) {
        System.out.println("보너스 볼을 입력해 주세요.");
        int bonusNumber = scanner.nextInt();
        scanner.nextLine();
        return bonusNumber;
    }

    private static List<Integer> parseNumber(String numberText) {
        return Stream.of(numberText.split(","))
                .map(number -> Integer.parseInt(number.trim())).collect(Collectors.toList());
    }
}
