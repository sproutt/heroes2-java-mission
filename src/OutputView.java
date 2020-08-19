import java.util.List;

public class OutputView {
    public void inputCarNamesMessage(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }
    public void inputCountMessage(){
        System.out.println("시도할 횟수는 몇회인가요?");
    }
    public void ResultMessage(){
        System.out.println("\n");
        System.out.println("실행 결과");
    }
    public void oneTrialMessage(Car car,StringBuilder goSignal){
        System.out.println(car.getName()+": "+goSignal);
    }
    public void getWinnerMessage(List<String> winnernames) {
        System.out.println(String.join(",", winnernames + "가 최종 우승했습니다."));
    }
}
