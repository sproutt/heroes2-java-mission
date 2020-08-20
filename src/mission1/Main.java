public class Main {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        RacingGame racingGame = new RacingGame();
        GameWinner gameWinner = new GameWinner();
        ResultView resultView = new ResultView();

        Car[] car = inputView.registerCar(inputView.inputCarName());
        int time = inputView.inputTime();
        System.out.println("\n실행 결과");
        for (int i = 0; i < time; i++) {
            racingGame.raceByTime(car);
            resultView.showResultByTime(car);
            System.out.println();
        }
        resultView.showFinalResult(gameWinner.findWinner(car));
    }
}
