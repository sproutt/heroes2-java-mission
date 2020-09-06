package MISSION_1.View;

import java.util.Map;

public class ResultView{
    public void printStart() {
        System.out.println("실행결과");
    }

    public void printEachCase(Map<String,Integer> cases){
        for(String eachCase:cases.keySet()){
            System.out.print(eachCase + ":");
            for(int k=0;k < (int) cases.get(eachCase);k++){
                System.out.print("-");
            }
            System.out.println();
        }
    }

    public void printResult(String winner){
        System.out.printf("%s가 최종 우승했습니다.",winner);
    }
}
