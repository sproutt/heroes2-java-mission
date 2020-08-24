import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class InputView {
    private static final int INITIAL_POSITION = 0;
    private static final int MIN_NAME_LENGTH = 1;
    private static final int MAX_NAME_LENGTH = 5;

    public String inputCarName() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,) 기준으로 구분).");
        return scanner.nextLine();
    }

    public List<Car> registerCar(String inputName) {
        String[] names = inputName.split(",");
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < names.length; i++) {
            checkValidName(names[i]);
            cars.add(new Car());
            cars.get(i).name = names[i];
            cars.get(i).position = INITIAL_POSITION;
        }
        return cars;
    }

    public int inputTime() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("시도할 횟수는 몇 회인가요?");
        return scanner.nextInt();
    }

    private void checkValidName(String name) {
        try {
            checkNameLength(name);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void checkNameLength(String name) throws Exception {
        if (name.length() < MIN_NAME_LENGTH || name.length() > MAX_NAME_LENGTH) {
            throw new InputNameException(name);
        }
        if (name.trim().isEmpty()) {
            throw new InputNameException();
        }
    }
}
