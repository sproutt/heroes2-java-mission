public class Car {
    private String name;
    private int position;

    Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void goForward() {
        this.position++;
    }
}
