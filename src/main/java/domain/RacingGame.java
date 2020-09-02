package domain;

import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {
    private int timeLimit;
    private List<String> carNames;
    private List<Car> racingCars;
    private RacingHistory history;

    public RacingGame(int timeLimit, List<String> carNames) {
        this.timeLimit = timeLimit;
        this.carNames = carNames;
        this.racingCars = generateCars();
        this.history = new RacingHistory();
    }

    public RacingHistory getHistory() {
        return history;
    }

    public void run() {
        for (int i = 0; i < timeLimit; i++) {
            moveCars();
            writeHistory();
        }
    }

    public Winner findWinner() {
        return new Winner(racingCars);
    }

    private List<Car> generateCars() {
        return carNames.stream().map(carName -> new Car(carName)).collect(Collectors.toList());
    }

    private void moveCars() {
        racingCars.stream().forEach(car -> car.moveForward());
    }

    private void writeHistory() {
        history.write(stampCurrentRace());
    }

    private RacingStamp stampCurrentRace() {
        return new RacingStamp(racingCars);
    }

}
