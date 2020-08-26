import java.util.List;

public class OutputView {
    private static final String DRIVE = "-";

    public void resultMessage() {
        System.out.println("\n실행 결과");
    }

    public void oneTrialMessage(List<Car> cars) {
        for(Car car: cars) {
            System.out.println(car.getName() + ": " + raceOneTrial(car));
        }
    }

    private StringBuilder raceOneTrial(Car car) {
        StringBuilder goSignal = new StringBuilder();
        for(int i = 0; i<car.getPosition(); i++) {
            goSignal.append(DRIVE);
        }
        return goSignal;
    }

    public void getWinnerMessage(List<String> winnernames) {
        System.out.println(String.join(",", winnernames + "가 최종 우승했습니다."));
    }
}
