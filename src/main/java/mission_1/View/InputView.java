package MISSION_1.View;

import java.util.Scanner;

public class InputView {
    private String carNames;
    private int time;

    public InputView(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        carNames = scanner.nextLine();

        System.out.println("시도할 횟수는 몇회인가요?");
        time = scanner.nextInt();
    }

    public String getCarNames(){
        return carNames;
    }

    public int getTime() {
        return time;
    }
}
