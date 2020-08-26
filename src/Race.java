import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Race {
    Rule rule = new Rule();

    public void race(List<Car> cars) {
        for(Car car: cars) {
            goOrStay(car);
        }
    }

    private void goOrStay(Car car) {
        if(rule.isGoForward()) {
            car.goForward();
        }
    }

    public List<String> getWinner(List<Car> cars) {
        List<Car> winner = new ArrayList<>();
        int positionOfWinner;
        positionOfWinner = findPositionOfWinner(cars);
        winner = cars.stream().filter(car -> (car.getPosition() == positionOfWinner)).collect(Collectors.toList());
        List<String> winnernames = new ArrayList<>();
        for(int i = 0; i < winner.size(); i++) {
            winnernames.add(winner.get(i).getName());
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