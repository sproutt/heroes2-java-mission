import java.util.ArrayList;

public class GameWinner {
    public ArrayList<String> findWinner(Car[] car) {
        int max = car[0].getPosition();
        for (int i = 1; i < car.length; i++) {
            max = Math.max(max, car[i].getPosition());
        }
        ArrayList<String> winnerList = new ArrayList<>();
        for (int i = 0; i < car.length; i++) {
            addWinnerList(car[i], max, winnerList);
        }
        return winnerList;
    }

    private void addWinnerList(Car car, int max, ArrayList<String> winnerList) {
        if (car.getPosition() == max) {
            winnerList.add(car.getName());
        }
    }
}
