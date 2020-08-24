import com.sun.deploy.util.StringUtils;
import java.util.List;

public class ResultView {

    public void showResultByTime(List<Car> cars) {
        for (Car car : cars) {
            showResult(car);
            System.out.println();
        }
        System.out.println();
    }

    public void showFinalResult(List<String> winnerList) {
        System.out.print(StringUtils.join((winnerList), ",")+"이(가) 최종 우승했습니다.");
    }

    private void showResult(Car car) {
        System.out.print(car.name + " : ");
        for (int i = 0; i < car.position; i++) {
            System.out.print("-");
        }
    }
}