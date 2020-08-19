import com.sun.deploy.util.StringUtils;
import java.util.ArrayList;

public class ResultView {

    public void showResultByTime(Car[] car) {
        for (int i = 0; i < car.length; i++) {
            car[i].showResult();
            System.out.println();
        }
    }

    public void showFinalResult(ArrayList<String> winnerList) {
        System.out.print(StringUtils.join((winnerList), ",")+"이(가) 최종 우승했습니다");
    }
}