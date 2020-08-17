import java.io.InputStream;
import java.util.Scanner;

public class InputCarName {
    private static final int MAX_NAME_LENGTH = 5;
    private Scanner scanner;

    public InputCarName(InputStream inputStream) {
        scanner = new Scanner(inputStream);
    }

    public String[] getCarNames() {
        String[] carNames;
        try {
            System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
            String value = scanner.nextLine();
            carNames = this.parseString(value);
        } catch (InputViewException e) {
            System.out.println(e.getMessage());
            carNames = getCarNames();
        }
        return carNames;
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
        if (name.length() > MAX_NAME_LENGTH) {
            System.out.println(name);
            throw new InputViewException("[Error] 자동차의 이름은 " + MAX_NAME_LENGTH + "자 이하여야 합니다.");
        }
    }

}
