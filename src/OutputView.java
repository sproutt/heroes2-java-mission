import java.util.List;

public class OutputView {
    public void resultMessage() {
        System.out.println("\n실행 결과");
    }
    public void oneTrialMessage(Car car,StringBuilder goSignal){
        System.out.println(car.getName()+": "+goSignal);
    }
    public void getWinnerMessage(List<String> winnernames) {
        System.out.println(String.join(",", winnernames + "가 최종 우승했습니다."));
    }
}
