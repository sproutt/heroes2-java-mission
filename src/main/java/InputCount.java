import java.util.InputMismatchException;
import java.util.Scanner;
//import java.util.InputMismatchException;

public class InputCount {
    private Scanner scanner;

    public InputCount() {
        scanner = new Scanner(System.in);
    }

    public int getCount() {
        int count;
        try {
            count = askCount();
        } catch (InputMismatchException e) {
            System.out.println("[Error] 숫자를 입력하세요");
            scanner.nextLine();
            count = getCount();
        } catch (InputViewException e) {
            System.out.println(e.getMessage());
            count = getCount();
        }
        return count;
    }

    private int askCount() throws InputViewException, InputMismatchException {
        System.out.println("시도할 회수는 몇회인가요?");
        int count = scanner.nextInt();
        if (count <= 0)
            throw new InputViewException("[Error] 시도 회수는 0보다 커야 합니다");
        return count;
    }
}
