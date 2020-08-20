import java.util.Scanner;

public class InputView {
    RacingGame racing = new RacingGame();
    Scanner scanner = new Scanner(System.in);
    public String[] inputNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String inputNames = scanner.nextLine();
        String[] carNames = racing.nameSet(inputNames);
        return carNames;
    }
    public int inputNumber() {
        System.out.println("시도할 회수는 몇회인가요?");
        int number = scanner.nextInt();
        return number;
    }
}
