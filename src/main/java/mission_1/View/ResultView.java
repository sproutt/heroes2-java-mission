package MISSION_1.View;

import MISSION_1.RacingGame;

import java.util.ArrayList;

public class ResultView{
    RacingGame car;
    ArrayList<String> carNames = new ArrayList<>();

    public ResultView(RacingGame car){
        this.car = car;
    }

    public void printResult() {
        System.out.println("실행결과");
        carNames = car.getCar();

        for(int i=0;i< car.getTime();i++){
            car.move();
            printEachCase();
            System.out.println();
        }

        printWinner();
    }

    private void printEachCase(){
        ArrayList<Integer> carPosition = car.getCarPosition();
        for(int j=0;j<carNames.size();j++){
            System.out.print(carNames.get(j) + ":");
            for(int k=0;k< carPosition.get(j);k++){
                System.out.print("-");
            }
            System.out.println();
        }
    }

    private void printWinner(){
        String winner = car.winner();
        System.out.printf("%s가 최종 우승했습니다.",winner);
    }
}
