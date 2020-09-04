import java.util.ArrayList;

public class WinningLotto {
    private ArrayList<LottoNo> winningNumbers = new ArrayList<>();
    private int bonusNumber;

    public WinningLotto(String winningNumber) throws LottoException {
        String[] winNumbers = winningNumber.split(",");
        if (winNumbers.length != 6) {
            throw new LottoException("예외 발생 - 당첨 번호를 6개만 입력해주세요.");
        }
        for (int i = 0; i < winNumbers.length; i++) {
            this.winningNumbers.add(new LottoNo(Integer.parseInt(winNumbers[i])));
        }
    }

    public ArrayList<LottoNo> getLottoNumbers() {
        return this.winningNumbers;
    }

    public void setBonusNumber(int number) throws LottoException {
        handleBonusException(number);
        this.bonusNumber = number;
    }

    public int getBonusNumber() {
        return this.bonusNumber;
    }

    public void handleBonusException(int number) throws LottoException {
        ArrayList<Integer> container = new ArrayList<>();
        for (int k = 0; k < winningNumbers.size(); k++) {
            container.add(winningNumbers.get(k).getLottoNumber());
        }
        if (container.contains(number)) {
            throw new LottoException("예외 발생 - 보너스 번호를 다시 입력하세요.");
        }
    }
}
