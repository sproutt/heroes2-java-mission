package MISSION_1;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class RacingGame {
    private int time = 0;
    private ArrayList<String> car = new ArrayList<>();
    private ArrayList<Integer> carPosition = new ArrayList<>();

    public int getTime(){ return time; }

    public ArrayList getCar(){ return car; }

    public ArrayList getCarPosition(){ return carPosition; }

    public void setTime(int time){ this.time = time; }

    public void setCar(String input){
        String[] carNames = input.split(",");
        for(String carName : carNames){
            car.add(carName.trim());
            carPosition.add(0);
        }
    }

    public void move(){
        Random rand = new Random();
        for(int index = 0; index < car.size(); index++){
            int condition = rand.nextInt(10);
            if(condition >= 4 && condition <= 9){
                carPosition.set(index,carPosition.get(index)+1);
            }
        }
    }
    
    public String winner(){
        ArrayList<String> winner = new ArrayList<>();
        Integer maxValue = (Integer) Collections.max(carPosition);
        for(int i=0; i< carPosition.size(); i++){
            if(carPosition.get(i) == maxValue){
                winner.add(car.get(i));
            }
        }
        String winnerList = String.join(",",winner.toArray(new String[winner.size()]));
        return winnerList;
    }
}
