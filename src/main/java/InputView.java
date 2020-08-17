public class InputView {
    public String[] getCarNames() {
        InputCarName inputCarName = new InputCarName(System.in);
        String[] carNames = inputCarName.getCarNames();
        return carNames;
    }

    public int getCount() {
        InputCount inputCount = new InputCount(System.in);
        int count = inputCount.getCount();
        return count;
    }
}
