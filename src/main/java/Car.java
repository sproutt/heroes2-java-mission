import java.util.Random;

public class Car implements Comparable<Car> {
    private static final int THRESHOLD = 4;
    private static final int MAX_POWER = 10;
    private String name;
    private int position;
    private char carChar;

    public Car(String name) {
        this.name = name;
        this.position = 0;
        this.carChar = '-';
    }

    public String getName() {
        return this.name;
    }

    public int getPosition() {
        return this.position;
    }

    public char getCarChar() {
        return this.carChar;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public void moveForward() {
        Random random = new Random();
        int RandNumber = random.nextInt(MAX_POWER);
        if (RandNumber >= THRESHOLD)
            this.setPosition(this.getPosition() + 1);
    }

    @Override
    public int compareTo(Car car) {
        return this.getPosition() - car.getPosition();
    }
}
