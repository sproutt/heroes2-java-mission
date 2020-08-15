import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {
    private int timeLimits;
    private List<Car> racingCars;
    private RacingView racingView;

    public RacingGame(int timeLimits, List<Car> racingCars) {
        this.timeLimits = timeLimits;
        this.racingCars = racingCars;
        this.racingView = new RacingView();
    }

    public void run() {
        this.racingView.showRaceStart();
        this.race();
        this.racingView.showWinner(this.findWinner());
    }

    private void race() {
        for (int i = 0; i < this.timeLimits; i++) {
            this.moveCars();
            this.racingView.showRace(this.racingCars);
            System.out.println();
        }
    }

    private void moveCars() {
        for ( Car car: racingCars) {
            car.moveForward();
        }
    }

    private List<Car> findWinner() {
        Collections.sort(this.racingCars);
        int farrestPosition = this.racingCars.get(racingCars.size() - 1).getPosition();
        return findCarsByPosition(farrestPosition, this.racingCars);
    }

    private List<Car> findCarsByPosition(int position, List<Car> Cars) {
        List<Car> filteredCars = new ArrayList<Car>();
        filteredCars = Cars.stream()
                        .filter(car -> (car.getPosition() == position)).collect(Collectors.toList());
        return filteredCars;
    }
}
