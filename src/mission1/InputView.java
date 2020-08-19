import java.util.Scanner;

public class InputView {
    static final int INITIAL_POSITION = 0;
    static final int MIN_NAME_LENGTH = 1;
    static final int MAX_NAME_LENGTH = 5;

    public Car[] inputCarName() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,) 기준으로 구분).");
        String inputName = scanner.nextLine();
        String[] names = inputName.split(",");
        Car[] car = new Car[names.length];
        for (int i = 0; i < car.length; i++) {
            checkValidName(names[i]);
            car[i] = new Car();
            car[i].setName(names[i]);
            car[i].setPosition(INITIAL_POSITION);
        }
        return car;
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
