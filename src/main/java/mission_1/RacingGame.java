package MISSION_1;
import java.util.Random;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class RacingGame {
    private int time = 0;
    private Map<String, Integer> carInfo = new HashMap<String, Integer>();

    public Map getCarInfo(){ return carInfo; }

    public void setTime(int time){ this.time = time; }
    public int  getTime(){ return time; }

    public void readyForStart(String carNamesText){
        String[] carNames = carNamesText.split(",");
        for(String carName : carNames){
            carInfo.put(carName.trim(), 0);
        }
    }

    public void move(){
        Random rand = new Random();
        for(String carName: carInfo.keySet()){
            int condition = rand.nextInt(10);
            moveOneCar(condition, carName);
        }
    }

    public void moveOneCar(int condition, String carName) {
        int lower = 4;
        int upper = 9;

        if(condition >= lower && condition <= upper){
            carInfo.put(carName, carInfo.get(carName)+1);
        }
    }

    public String winner(){
        ArrayList<String> winner = new ArrayList<>();
        Integer maxValue = (Integer) Collections.max(carInfo.values());
        for(String carName:carInfo.keySet()){
            if(carInfo.get(carName) == maxValue){
                winner.add(carName);
            }
        }
        String winnerList = String.join(",",winner.toArray(new String[winner.size()]));
        return winnerList;
    }
}
