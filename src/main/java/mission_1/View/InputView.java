package MISSION_1.View;

import java.util.Scanner;

public class InputView {
    public String setCarNames() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNames = scanner.nextLine();
        return carNames;
    }

    public int setTime(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("시도할 횟수는 몇회인가요?");
        int time = scanner.nextInt();
        return time;
    }
}
