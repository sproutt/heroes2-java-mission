import java.util.List;

public class Main {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        RacingGame racingGame = new RacingGame();
        GameWinner gameWinner = new GameWinner();
        ResultView resultView = new ResultView();

        List<Car> cars = inputView.registerCar(inputView.inputCarName());
        int time = inputView.inputTime();
        for (int i = 0; i < time; i++) {
            racingGame.raceByTime(cars);
            resultView.showResultByTime(cars);
        }
        resultView.showFinalResult(gameWinner.findWinner(cars));
    }
}
