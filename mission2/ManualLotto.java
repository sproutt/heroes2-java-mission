import java.util.ArrayList;
import java.util.Scanner;

public class ManualLotto {
    private int manualLottoNumber;

    public ManualLotto(int number, LottoMoney money) throws LottoException {
        if (number > money.getLottoTicketNumber()) {
            throw new LottoException("예외 발생 - 구매한 로또 티켓 수의 이하를 입력하세요.");
        }
        this.manualLottoNumber = number;
    }

    public int getManualLottoNumber() {
        return manualLottoNumber;
    }

    public ArrayList putManualNumber() {
        ArrayList<String> manualNumbers = new ArrayList<>();
        for (int i = 0; i < this.manualLottoNumber; i++) {
            Scanner scanner = new Scanner(System.in);
            manualNumbers.add(scanner.nextLine());
        }
        return manualNumbers;
    }
}
