import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Race {
    private static final String DRIVE = "-";
    private List<Car> cars = new ArrayList<>();
    private int trial;
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    Rule rule = new Rule();

    public void play() {
        inputView.inputCarNamesMessage();
        cars = inputView.inputCarName();
        inputView.inputCountMessage();
        trial = inputView.inputTrial();

        for(int i = 0; i < trial; i++) {
            outputView.resultMessage();
            race(cars);
        }
        getWinner(cars);
    }

    private void race(List<Car> cars) {
        for(Car car: cars) {
            goOrStay(car);
            raceOneTrial(car);
        }
    }

    private void goOrStay(Car car) {
        if(rule.isGoForward()) {
            car.goForward();
        }
    }

    private void raceOneTrial(Car car) {
        StringBuilder goSignal = new StringBuilder();
        for(int i = 0; i<car.getPosition(); i++) {
            goSignal.append("-");
        }
        outputView.oneTrialMessage(car,goSignal);
    }

    private void getWinner(List<Car> cars) {
        List<Car> winner = new ArrayList<>();
        int positionOfWinner;
        positionOfWinner = findPositionOfWinner(cars);
        winner = cars.stream().filter(car -> (car.getPosition() == positionOfWinner)).collect(Collectors.toList());
        List<String> winnernames = new ArrayList<>();
        for(int i = 0; i < winner.size(); i++) {
            winnernames.add(winner.get(i).getName());
        }
        outputView.getWinnerMessage(winnernames);
    }

    private int findPositionOfWinner(List<Car> cars) {
        List<Integer> position = new ArrayList<>();
        int positionOfWinner;
        for(Car car: cars) {
            position.add(car.getPosition());
        }
        positionOfWinner = Collections.max(position);
        return positionOfWinner;
    }
}