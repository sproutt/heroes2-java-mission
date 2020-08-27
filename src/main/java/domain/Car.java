package domain;

import java.util.Comparator;
import java.util.Random;

public class Car {
    private static final int NUMBER_OF_CAR_SHAPES = 8;
    private static final int THRESHOLD = 4;
    private static final int MAX_POWER = 10;
    private String name;
    private int position;
    private int carShapeId;
    public static Comparator<Car> ascendingPositionComparator = new Comparator<Car>() {
        @Override
        public int compare(Car car1, Car car2) {
            return car1.getPosition() - car2.getPosition();
        }
    };

    public Car(String name) {
        this.name = name;
        position = 0;
        Random random = new Random();
        carShapeId = random.nextInt(NUMBER_OF_CAR_SHAPES);
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public int getCarShapeId() {
        return carShapeId;
    }

    public CarStamp stampCurrentCar() {
        return new CarStamp(this);
    }

    public void moveForward() {
        Random random = new Random();
        int RandPower = random.nextInt(MAX_POWER);
        if (RandPower >= THRESHOLD)
            position++;
    }

    public boolean isSamePosition(Car car) {
        return position == car.getPosition();
    }
}
