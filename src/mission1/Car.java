public class Car {
    private String name;
    private int position;

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int addPosition() {
        return this.position++;
    }

    public void showResult() {
        System.out.print(this.name + " : ");
        for (int i = 0; i < this.position; i++) {
            System.out.print("-");
        }
    }
}