import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        String[] carNames = inputView.getCarNames();
        int timeLimit = inputView.getCount();

        List<Car> Cars = new ArrayList<>();
        for (int i = 0; i < carNames.length; i++) {
            Cars.add(new Car(carNames[i]));
        }

        RacingGame game = new RacingGame(timeLimit, Cars);
        game.run();

    }
}
