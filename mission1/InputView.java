import java.util.Scanner;

public class InputView {
    public static String setNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public static String overNames() {
        System.out.println("자동차의 이름들을 5자 이하로 다시 작성하십시오");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public static int inputNumber() {
        System.out.println("시도할 회수는 몇회인가요?");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

}