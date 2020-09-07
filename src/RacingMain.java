import java.util.ArrayList;
import java.util.List;

public class RacingMain {
    public static void main(String[] args) {
        OutputView outputView = new OutputView();
        RacingGame racingGame = new RacingGame();
        List<Car> cars = new ArrayList<>();
        int trial;

        InputView.inputCarNamesMessage();
        cars = InputView.inputCarName();
        InputView.inputCountMessage();
        trial = InputView.inputTrial();

        for(int i = 0; i < trial; i++) {
            outputView.resultMessage();
            racingGame.race(cars);
            outputView.oneTrialMessage(cars);
        }

        outputView.getWinnerMessage(racingGame.getWinner(cars));
    }
}


