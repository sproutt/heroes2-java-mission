import java.util.Random;
import java.util.ArrayList;

public class RacingGame {
    static final int MAX_LENGTH = 6;
    static final int CAN_GO_NUMBER = 4;
    static final int ORIGINAL_POSITION = 0;

    public String[] nameSet(String inputNames) {
        String[] names = inputNames.split(",");
        for (int i = 0; i < names.length; i++) {
            names = nameLengthCheck(names, i);
        }
        return names;
    }

    public ArrayList<Car> registerCarNames(ArrayList<Car> cars, String[] nameSet) {
        for (int i = 0; i < nameSet.length; i++) {
            cars.add(new Car(nameSet[i], ORIGINAL_POSITION));
        }
        return cars;
    }

    public String[] nameLengthCheck(String[] names, int i) {
        if (names[i].length() >= MAX_LENGTH) {
            String inputNames = InputView.overNames();
            names = inputNames.split(",");
        }
        return names;
    }

    public String getInputNames(String names) {
        String[] carNames = nameSet(names);
        String cars = "";
        for (int i = 0; i < carNames.length; i++) {
            cars += carNames[i] + "";
        }
        return cars;
    }

    public static int randomValue() {
        Random random = new Random();
        return random.nextInt(10);
    }

    public static ArrayList<Car> valueCheck(ArrayList<Car> cars, int randomValue, int i) {
        if (randomValue >= CAN_GO_NUMBER) {
            cars.get(i).move();
        }
        return cars;
    }

    public static ArrayList<Car> randomToNumber(ArrayList<Car> cars) {
        for (int i = 0; i < cars.size(); i++) {
            valueCheck(cars, randomValue(), i);
        }
        return cars;
    }

    public static Car winnerJudge(ArrayList<Car> cars, int max, int i, String winner) {
        if (max < cars.get(i).getPosition()) {
            max = cars.get(i).getPosition();
            winner = cars.get(i).getName();
        }
        Car passInfo = new Car(winner, max);
        return passInfo;
    }

    public static int sameScoreCount(int cnt, int max, ArrayList<Car> cars, int i) {
        if (max == cars.get(i).getPosition()) {
            cnt += 1;
        }
        return cnt;
    }

    public static ArrayList<String> winnersNameSet(ArrayList<String> winners, int max, ArrayList<Car> cars) {
        for (int i = 0; i < cars.size(); i++) {
            winners = sameScoreWinners(max, cars, winners, i);
        }
        return winners;
    }

    public static ArrayList<String> sameScoreWinners(int max, ArrayList<Car> cars, ArrayList<String> winners, int i) {
        if (max == cars.get(i).getPosition()) {
            winners.add(cars.get(i).getName());
        }
        return winners;
    }

    public static ArrayList<String> winnerNameReturn(int cnt, String winner) {
        ArrayList<String> winners = new ArrayList<>();
        if (cnt == 0) {
            winners.add(winner);
        }
        return winners;
    }

    public static ArrayList<String> winnersNameReturn(int cnt, int max, ArrayList<Car> cars) {
        ArrayList<String> winners = new ArrayList<>(cnt);
        winners = winnersNameSet(winners, max, cars);
        return winners;
    }

    public static ArrayList<String> findWinner(ArrayList<Car> cars) {
        int max = cars.get(0).getPosition();
        String winner = cars.get(0).getName();
        for (int i = 1; i < cars.size(); i++) {
            max = winnerJudge(cars, max, i, winner).getPosition();
            winner = winnerJudge(cars, max, i, winner).getName();
        }
        int cnt = 0;
        for (int i = 0; i < cars.size(); i++) {
            cnt = sameScoreCount(cnt, max, cars, i);
        }
        ArrayList<String> winners;
        winners = winnerNameReturn(cnt, winner);
        if (cnt > 0) {
            winners = winnersNameReturn(cnt, max, cars);
        }
        return winners;
    }

    public String getWinner(ArrayList<Car> cars, int[] randomNumbers) {
        ResultView v = new ResultView();

        for (int i = 0; i < cars.size(); i++) {
            cars = valueCheck(cars, randomNumbers[i], i);
        }
        ArrayList<String> winners = findWinner(cars);
        String winner = "";
        for (int i = 0; i < winners.size(); i++) {
            winner += winners.get(i) + " ";
        }
        return winner;
    }
}
