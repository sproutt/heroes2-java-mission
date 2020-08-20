public class ResultView {
    RacingGame racing = new RacingGame();
    public void resultRacing(String[] carNames, int number) {
        System.out.println("실행 결과");
        int[] carPositions = new int[carNames.length];
        int[] carPosition = new int[carNames.length];
        for (int i = 0; i < number; i++) {
            int[] values = racing.randomValueSet(carNames);
            carPosition = racing.randomToNumber(values, carPositions);
            racing.resultRacing(carPosition, carNames);
            System.out.println("");
        }
        Car[] c = carSet(carNames, carPosition);
        String[] winners = racing.findWinner(c);
        finalResultView(winners);
    }
    public static Car[] carSet(String[] carNames, int[] carPosition) {
        Car[] c = new Car[carNames.length];
        for (int i = 0; i < c.length; i++) {
            c[i] = new Car();
            c[i].position = carPosition[i];
            c[i].name = carNames[i];
        }
        return c;
    }
    public static void finalResultView(String[] winners) {
        if (winners.length == 1) {
            System.out.println(winners[0] + "가 최종 우승했습니다.");
        }
        if (winners.length > 1) {
            for (int i = 0; i < winners.length - 1; i++) {
                System.out.print(winners[i] + ",");
            }
            System.out.println(winners[winners.length - 1] + "가 최종 우승했습니다.");
        }
    }
}
