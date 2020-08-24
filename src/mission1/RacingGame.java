import java.util.Random;
import java.util.List;

public class RacingGame {
    private static final int RANDOM_RANGE = 10;
    private static final int MIN_MOVE_STANDARD = 4;

    public void raceByTime(List<Car> cars) {
        for (Car car : cars) {
            int randomValue = giveRandomValue();
            move(car, randomValue);
        }
    }

    private int giveRandomValue() {
        Random random = new Random();
        return random.nextInt(RANDOM_RANGE);
    }

    private void move(Car car, int randomValue) {
        if (canMove(randomValue)) {
            car.run();
        }
    }

    private boolean canMove(int number) {
        return number >= MIN_MOVE_STANDARD;
    }
}