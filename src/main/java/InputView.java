import java.util.InputMismatchException;
import java.util.Scanner;

public class InputView {
    private static final int MAX_NAME_LENGTH = 5;
    private Scanner scanner;

    public InputView() {
        this.scanner = new Scanner(System.in);
    }

    public String[] getCarName() {
        while (true) {
            System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
            String value = scanner.nextLine();
            try {
                String[] carNames = this.parseString(value);
                return carNames;
            } catch (InputViewException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public int getCount() {
        while (true) {
            try {
                int count = askCount();
                return count;
            } catch (InputMismatchException e) {
                System.out.println("[Error] 숫자를 입력하세요");
                scanner.nextLine();
            } catch (InputViewException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private String[] parseString(String nameValues) throws InputViewException {
        if (nameValues.length() == 0) {
            throw new InputViewException("[Error] 자동차의 이름을 하나 이상 입력하세요");
        }
        String[] names = nameValues.split(",");
        for (int i = 0; i < names.length; i++) {
            names[i] = names[i].trim();
            checkLengthLimit(names[i]);
        }
        return names;
    }

    private void checkLengthLimit(String name) throws InputViewException {
        if (name.length() > MAX_NAME_LENGTH)
            throw new InputViewException("[Error] 자동차의 이름은 " + MAX_NAME_LENGTH + "자 이하여야 합니다.");
    }

    private int askCount() throws InputViewException, InputMismatchException {
        System.out.println("시도할 회수는 몇회인가요?");
        int count = scanner.nextInt();
        if (count <= 0)
            throw new InputViewException("[Error] 시도 회수는 0보다 커야 합니다");
        return count;
    }
}
