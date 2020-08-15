import java.util.List;

public class RacingView {
    public void showRaceStart() {
        System.out.println("경기 시작! 실행결과");
    }

    public void showRace(List<Car> cars) {
        for ( Car car: cars) {
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
        for (int i = 0; i < winners.size(); i++) {
            if (i != 0)
                System.out.print(", ");
            System.out.print(winners.get(i).getName());
        }
        System.out.println("가 최종우승 했습니다.");
    }
}
