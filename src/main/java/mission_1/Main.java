package MISSION_1;

import MISSION_1.View.InputView;
import MISSION_1.View.ResultView;

public class Main {
    public static void main(String[] args){
        InputView view = new InputView();
        RacingGame game = new RacingGame();

        game.setCar(view.getCarNames());
        game.setTime(view.getTime());

        ResultView result = new ResultView(game);
        result.printResult();
    }
}
