import java.util.List;
import java.util.stream.Collectors;

public class WinningNumbers {
    private List<LottoNo> winningNumbers;
    private LottoNo bonusNumber;
    public WinningNumbers(List<Integer> winningNumbers, int bonusNumber) {
        this.winningNumbers = winningNumbers.stream().map(number -> new LottoNo(number))
                .collect(Collectors.toList());
        this.bonusNumber = new LottoNo(bonusNumber);
    }

    public List<LottoNo> getWinningNumbers() {
        return winningNumbers;
    }

    public LottoNo getBonusNumber() {
        return bonusNumber;
    }
}
