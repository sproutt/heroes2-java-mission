import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    public static void main(String[] args) {
        OutputView outputView = new OutputView();
        Race race = new Race();
        List<Car> cars = new ArrayList<>();
        int trial;

        InputView.inputCarNamesMessage();
        cars = InputView.inputCarName();
        InputView.inputCountMessage();
        trial = InputView.inputTrial();

        for(int i = 0; i < trial; i++) {
            outputView.resultMessage();
            race.race(cars);
            outputView.oneTrialMessage(cars);
        }

        outputView.getWinnerMessage(race.getWinner(cars));
    }
}


