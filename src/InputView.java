import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class InputView {
    private static final int MAX_LENGTH = 6;
    private Scanner scanner = new Scanner(System.in);

    public List<Car> inputCarName() {
        String name = scanner.nextLine();
        String[] splittedInputCarName = splitInputCarName(name);
        String[] trimmedInputCarName = trimInputCarName(splittedInputCarName);

        try {
            processStreamAboutCheckName(trimmedInputCarName);
        } catch(IllegalArgumentException e) {
            System.out.println(e.getMessage());
            inputCarName();
        }

        List<Car> cars = new ArrayList<>();
        for(int i = 0; i< splittedInputCarName.length; i++) {
            cars.add(new Car(trimmedInputCarName[i]));
        }
        return cars;
    }

    private String[] splitInputCarName(String name) {
        String[] splittedInputCarName = name.split(",");
        return splittedInputCarName;
    }

    private String[] trimInputCarName(String[] name) {
        for(int i = 0; i<name.length; i++) {
            name[i] = name[i].trim();
        }
        return name;
    }

    private void checkNameLength(String name) {
        if(name.length() >= MAX_LENGTH) {
            throw new IllegalArgumentException("이름은 5자 이하만 가능합니다.");
        }
    }

    private void processStreamAboutCheckName(String[] trimmedInputCarName) {
        Stream<String> stream = Arrays.stream(trimmedInputCarName);
        stream.forEach(e -> checkNameLength(e));
    }

    public int inputTrial() {
        return scanner.nextInt();
    }

    public void inputCarNamesMessage() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public void inputCountMessage() {
        System.out.println("시도할 횟수는 몇회인가요?");
    }
}





