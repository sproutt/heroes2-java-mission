public class Main {
    public static void main(String[] args) {
        InputView input = new InputView();
        String[] carNames = input.inputNames();
        int number = input.inputNumber();

        ResultView result=new ResultView();
        result.resultRacing(carNames,number);
    }
}
