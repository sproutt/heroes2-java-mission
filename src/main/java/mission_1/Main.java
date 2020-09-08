package MISSION_1;

import MISSION_1.View.InputView;
import MISSION_1.View.ResultView;

public class Main {
    public static void main(String[] args){
        InputView input = new InputView();
        ResultView result = new ResultView();
        RacingGame game = new RacingGame();

        game.readyForStart(input.setCarNames());
        game.setTime(input.setTime());

        result.printStart();
        for(int i=0;i< game.getTime();i++){
            game.move();
            result.printEachCase(game.getCarInfo());
            System.out.println();
        }

        result.printResult(game.winner());
    }
}
