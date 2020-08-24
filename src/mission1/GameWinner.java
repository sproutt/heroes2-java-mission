import java.util.ArrayList;
import java.util.List;

public class GameWinner {
    public List<String> findWinner(List<Car> cars) {
        int max = cars.get(0).position;
        for (int i = 1; i < cars.size(); i++) {
            max = Math.max(max, cars.get(i).position);
        }
        List<String> winnerList = new ArrayList<>();
        for (Car car : cars) {
            addWinnerList(car, max, winnerList);
        }
        return winnerList;
    }

    private void addWinnerList(Car car, int max, List<String> winnerList) {
        if (car.position == max) {
            winnerList.add(car.name);
        }
    }
}
