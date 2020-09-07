import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {
    private List<String> winnernames = new ArrayList<>();

    public void race(List<Car> cars) {
        for(Car car: cars) {
            goOrStay(car);
        }
    }

    private void goOrStay(Car car) {
        if(Rule.isGoForward()) {
            car.goForward();
        }
    }

    public List<String> getWinner(List<Car> cars) {
        int positionOfWinner = findPositionOfWinner(cars);
        cars = cars.stream().filter(car -> (car.getPosition() == positionOfWinner)).collect(Collectors.toList());
        for (Car car : cars) {
            this.winnernames.add(car.getName());
        }
        return winnernames;
    }

    private int findPositionOfWinner(List<Car> cars) {
        List<Integer> position = new ArrayList<>();
        int positionOfWinner;
        for(Car car: cars) {
            position.add(car.getPosition());
        }
        positionOfWinner = Collections.max(position);
        return positionOfWinner;
    }
}