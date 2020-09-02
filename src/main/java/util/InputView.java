package util;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.io.InputStream;

public final class InputView {
    private static final int MAX_NAME_LENGTH = 5;
    private static Scanner scanner;

    public static List<String> getCarNames(InputStream inputStream) throws InputViewException {
        scanner = new Scanner(inputStream);
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String value = scanner.nextLine();
        return parseString(value);
    }

    public static int getCount(InputStream inputStream) throws InputViewException, InputMismatchException {
        scanner = new Scanner(inputStream);
        System.out.println("시도할 회수는 몇회인가요?");
        int count = scanner.nextInt();
        if (count <= 0) {
            throw new InputViewException("[Error] 시도 회수는 0보다 커야 합니다");
        }
        return count;
    }

    private static List<String> parseString(String nameValues) throws InputViewException {
        checkEmptyInput(nameValues);
        String[] names = nameValues.split(",");
        for (int i = 0; i < names.length; i++) {
            names[i] = names[i].trim();
            checkLengthLimit(names[i]);
        }
        return Arrays.asList(names);
    }

    private static void checkEmptyInput(String nameValues) throws InputViewException {
        if (nameValues.length() == 0) {
            throw new InputViewException("[Error] 자동차의 이름을 하나 이상 입력하세요");
        }
    }

    private static void checkLengthLimit(String name) throws InputViewException {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new InputViewException("[Error] 자동차의 이름은 " + MAX_NAME_LENGTH + "자 이하여야 합니다.");
        }
    }
}
