package domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Winner {
    private List<Car> candidates;
    private List<Car> winners;

    public Winner(List<Car> candidates) {
        this.candidates = candidates;
    }

    public List<Car> getWinners() {
        Car farthestCar = Collections.max(candidates, Car.ascendingPositionComparator);
        return findCarsAtSamePosition(farthestCar, candidates);
    }

    private List<Car> findCarsAtSamePosition(Car carToFind, List<Car> candidates) {
        return candidates.stream()
                .filter(car -> (car.isSamePosition(carToFind))).collect(Collectors.toList());
    }
}
