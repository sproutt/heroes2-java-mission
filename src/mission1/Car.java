public class Car {
    public String name;
    public int position;

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