import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        RacingGame racing = new RacingGame();
        ArrayList<Car> cars = new ArrayList<>();
        cars = racing.registerCarNames(cars, racing.nameSet(InputView.setNames()));
        int number = InputView.inputNumber();
        ResultView result = new ResultView();
        result.resultRacing(number, cars);
    }
}
