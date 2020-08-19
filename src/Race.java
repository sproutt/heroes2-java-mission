import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Race {
    final static String drive = "-";
    private List<Car> carLineUp = new ArrayList<>();
    private int trial;
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();

    public void play() {
        outputView.inputCarNamesMessage();
        carLineUp = inputView.input();
        outputView.inputCountMessage();
        trial = inputView.inputCount();
        for(int i = 0; i < trial; i++) {
            outputView.ResultMessage();
            race(carLineUp);
        }
        getWinner(carLineUp);
    }

    private void race(List<Car> carLineUp){
        for(Car car: carLineUp){
            car.goForward();
            raceOneTrial(car);
        }
    }

    private void raceOneTrial(Car car){
        StringBuilder goSignal = new StringBuilder();
        for(int i = 0; i<car.getPosition(); i++){
            goSignal.append("-");
        }
        outputView.oneTrialMessage(car,goSignal);
    }

    private void getWinner(List<Car> carLineUp) {
        /*
        StringBuilder winner = new StringBuilder();
        int positionOfWinner;
        positionOfWinner = findPositionOfWinner(carLineUp);
        for(Car car: carLineUp){
                winner.append(winnerBuilder(car,positionOfWinner));
            }
        System.out.println(String.join(",",winner)+"가 최종 우승했습니다");
        }
        */
        List<Car> winner = new ArrayList<>();
        int positionOfWinner;
        positionOfWinner = findPositionOfWinner(carLineUp);
        winner = carLineUp.stream().filter(car -> (car.getPosition() == positionOfWinner)).collect(Collectors.toList());
        List<String> winnernames = new ArrayList<>();
        for(int i = 0; i < winner.size(); i++){
            winnernames.add(winner.get(i).getName());
        }
        outputView.getWinnerMessage(winnernames);
    }

    /*
    private StringBuilder winnerBuilder(Car car, int positionOfWinner){
        StringBuilder winner = new StringBuilder();
        if(positionOfWinner == car.getPosition()) {
            winner.append(car.getName());
        }
        return winner;
    }
     */

    private int findPositionOfWinner(List<Car> carLineUp){
        List<Integer> position = new ArrayList<>();
        int positionOfWinner;
        for(Car car: carLineUp){
            position.add(car.getPosition());
        }
        positionOfWinner = Collections.max(position);
        return positionOfWinner;
    }
}