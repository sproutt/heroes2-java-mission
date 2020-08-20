
import java.util.Scanner;
import java.util.Random;

public class RacingGame {
    public static String[] nameSet(String inputNames) {
        String[] names = inputNames.split(",");
        int i = 0;
        while (i < names.length) {
            names = nameLengthCheck(names, i);
            i++;
        }
        return names;
    }
    public static String[] nameLengthCheck(String[] names, int i) {
        final int MAX_LENGTH = 6;
        if (names[i].length() >= MAX_LENGTH) {
            System.out.println("자동차의 이름들을 5자 이하로 다시 작성하십시오");
            Scanner scanner = new Scanner(System.in);
            String inputNames = scanner.nextLine();
            names = inputNames.split(",");
        }
        return names;
    }
    public static String getInputNames(String names){
        String[] carNames = nameSet(names);
        String cars="";
        for(int i=0;i<carNames.length;i++){
            cars +=carNames[i]+"";
        }
        return cars;
    }

    public static int[] randomValueSet(String[] names) {
        Random random = new Random();
        int[] values = new int[names.length];
        for (int i = 0; i < names.length; i++) {
            values[i] = random.nextInt(10);
        }
        return values;
    }
    public static int[] randomToNumber(int[] values, int[] carPositions) {
        for (int i = 0; i < values.length; i++) {
            carPositions = valueCheck(values, carPositions, i);
        }
        return carPositions;
    }
    public static int[] valueCheck(int[] values, int[] carPositions, int i) {
        final int GO_NUMBER = 4;
        if (values[i] >= GO_NUMBER) {
            carPositions[i]++;
        }
        return carPositions;
    }
    public static String getRandomToNumber(int[] values){
        int[] carPositions = new int[values.length];
        String positions="";
        carPositions = randomToNumber(values, carPositions);
        for(int i=0;i< carPositions.length;i++){
            positions+=carPositions[i]+" ";
        }
        return positions;
    }

    public static String racingView(int n) {
        String car = "";
        for (int i = 0; i < n; i++) {
            car += "-";
        }
        return car;
    }
    public static void resultRacing(int[] carPositions, String[] names) {
        for (int i = 0; i < carPositions.length; i++) {
            System.out.println(names[i] + ":" + racingView(carPositions[i]));
        }
    }

    public static Car winnerJudge(Car[] c, int max, int i, String winner) {
        Car a = new Car();
        if (max < c[i].position) {
            max = c[i].position;
            winner = c[i].name;
        }
        a.position = max;
        a.name = winner;
        return a;
    }
    public static int sameScoreCount(int cnt, int max, Car[] c, int i) {
        if (max == c[i].position) {
            cnt += 1;
        }
        return cnt;
    }
    public static String[] winnersNameSet(String[] winners, int max, Car[] c, int cnt) {
        int index = 0;
        for (int i = 0; i < c.length; i++) {

            winners = sameScoreWinners(max, c, winners, i, index).winners;
            index = sameScoreWinners(max, c, winners, i, index).index;
        }
        return winners;
    }
    static class Winners {
        int index;
        String[] winners;
    }
    public static Winners sameScoreWinners(int max, Car[] c, String[] winners, int i, int index) {
        Winners w = new Winners();
        if (max == c[i].position) {
            winners[index++] = c[i].name;
        }
        w.index = index;
        w.winners = winners;
        return w;
    }
    public static String[] winnerNameReturn(int cnt, String winner) {
        String[] winners = new String[1];
        if (cnt == 0) {
            winners[0] = winner;
        }
        return winners;
    }
    public static String[] winnersNameReturn(int cnt, int max, Car[] c) {
        String[] winners = new String[cnt];
        winners = winnersNameSet(winners, max, c, cnt);
        return winners;
    }
    public static String[] findWinner(Car[] c) {
        int max = c[0].position;
        String winner = c[0].name;
        for (int i = 1; i < c.length; i++) {
            max = winnerJudge(c, max, i, winner).position;
            winner = winnerJudge(c, max, i, winner).name;
        }
        int cnt = 0;
        for (int i = 0; i < c.length; i++) {
            cnt = sameScoreCount(cnt, max, c, i);
        }
        String[] winners;
        winners = winnerNameReturn(cnt, winner);
        if (cnt > 0) {
            winners = winnersNameReturn(cnt, max, c);
        }
        return winners;
    }
    public static String getWinner(String input,String[] carNames,int[] randomNumbers){
       ResultView v=new ResultView();
        int[] carPositions = new int[carNames.length];
        carPositions = randomToNumber(randomNumbers, carPositions);
        Car[] c = v.carSet(carNames, carPositions);
        String[] winners = findWinner(c);
        String winner="";
        for(int i=0;i<winners.length;i++){
            winner+=winners[i]+" ";
        }
        return winner;
    }
}
