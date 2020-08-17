import java.util.ArrayList;
import java.util.List;

public class RacingView {
    public void showRaceStart() {
        System.out.println("실행결과");
    }

    public void showRace(List<Car> cars) {
        for (Car car : cars) {
            showCarMovement(car);
        }
    }

    public void showCarMovement(Car car) {
        System.out.print(car.getName() + " : ");
        for (int i = 0; i < car.getPosition(); i++) {
            System.out.print(car.getCarChar());
        }
        System.out.println();
    }

    public void showWinner(List<Car> winners) {
        List<String> winnernames = new ArrayList<>();
        for (int i = 0; i < winners.size(); i++) {
            winnernames.add(winners.get(i).getName());
        }
        String winnersWithCommas = String.join(", ", winnernames);
        System.out.println(winnersWithCommas + "가 최종우승 했습니다.");
    }
}
