package domain;

import java.util.List;
import java.util.stream.Collectors;

public class RacingStamp {
    private List<CarStamp> racingStamp;

    public RacingStamp(List<Car> racingCars) {
        racingStamp = racingCars.stream().map(car -> car.stampCurrentCar()).collect(Collectors.toList());
    }

    public List<CarStamp> getRacingStamp() {
        return racingStamp;
    }
}
