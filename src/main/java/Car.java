import java.util.Random;

public class Car implements Comparable<Car> {
    private String name;
    private int position;
    private char carChar;

    public Car(String name) {
        this.name = name;
        this.position = 0;
        this.carChar = '-';
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public char getCarChar() {
        return carChar;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public void moveForward() {
        Random random = new Random();
        int RandNumber = random.nextInt(10);
        if (RandNumber >= 4)
            this.setPosition(this.getPosition() + 1);
    }

    public int compareTo(Car car) {
        return this.getPosition() - car.getPosition();
    }
}
