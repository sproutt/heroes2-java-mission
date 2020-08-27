import java.util.ArrayList;

public class ResultView {
    public static void resultRacing(int number, ArrayList<Car> cars) {
        System.out.println("실행 결과");
        for (int i = 0; i < number; i++) {
            RacingGame.randomToNumber(cars);
            resultRacing(cars);
            System.out.println("");
        }
        ArrayList<String> winners = RacingGame.findWinner(cars);
        finalResultView(winners);
    }

    public static void resultRacing(ArrayList<Car> cars) {
        for (int i = 0; i < cars.size(); i++) {
            System.out.println(cars.get(i).getName() + ":" + racingView(cars.get(i).getPosition()));
        }
    }

    public static String racingView(int n) {
        String car = "";
        for (int i = 0; i < n; i++) {
            car += "-";
        }
        return car;
    }

    public static void finalResultView(ArrayList<String> winners) {
        if (winners.size() == 1) {
            System.out.println(winners.get(0) + "가 최종 우승했습니다.");
        }
        if (winners.size() > 1) {
            for (int i = 0; i < winners.size() - 1; i++) {
                System.out.print(winners.get(i) + ",");
            }
            System.out.println(winners.get(winners.size() - 1) + "가 최종 우승했습니다.");
        }
    }
}
