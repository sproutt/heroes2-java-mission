import java.util.Random;

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

    public void setPosition(int position) {
        this.position = position;
    }

    public void goForward(){
        Random random = new Random();
        if(random.nextInt(10) >= 4){
            this.setPosition(this.getPosition()+1);
        }
    }
}
