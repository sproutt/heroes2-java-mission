import java.util.Random;

public class RacingGame {
    static final int RANDOM_RANGE = 10;
    static final int MIN_MOVE_STANDARD = 4;

    public void raceByTime(Car[] car) {
        for (int i = 0; i < car.length; i++) {
            int randomValue = giveRandomValue();
            move(car[i], randomValue);
        }
    }

    private int giveRandomValue() {
        Random random = new Random();
        return random.nextInt(RANDOM_RANGE);
    }

    private void move(Car car, int randomValue) {
        if (canMove(randomValue)) {
            car.addPosition();
        }
    }

    private boolean canMove(int number) {
        return number >= MIN_MOVE_STANDARD;
    }
}