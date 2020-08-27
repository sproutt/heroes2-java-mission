package domain;

public class CarStamp {
    private String carName;
    private int position;
    private int carShapeId;

    public CarStamp(Car car) {
        carName = car.getName();
        position = car.getPosition();
        carShapeId = car.getCarShapeId();
    }

    public String getCarName() {
        return carName;
    }

    public int getPosition() {
        return position;
    }

    public int getCarShapeId() {
        return carShapeId;
    }
}
