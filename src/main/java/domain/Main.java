package domain;

import util.InputView;
import util.InputViewException;
import util.RacingView;

import java.util.List;

public class Main {
    public static void main(String[] args) throws InputViewException {
        List<String> carNames = InputView.getCarNames(System.in);
        int timeLimit = InputView.getCount(System.in);

        RacingGame game = new RacingGame(timeLimit, carNames);
        RacingView.showRaceStart();
        game.run();
        RacingView.showRaceHistory(game.getHistory());
        RacingView.showWinner(game.findWinner());
    }
}
