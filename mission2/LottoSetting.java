import java.util.ArrayList;
import java.util.*;

public class LottoSetting {

    public int checkAutoNumber(ManualLotto manual, LottoMoney money) {
        int auto = money.getLottoTicketNumber() - manual.getManualLottoNumber();
        return auto;
    }

    public ArrayList<Lotto> setLottoTickets(ArrayList<String> manualNumbers, LottoMoney money, ManualLotto manual) throws LottoException {
        ArrayList<Lotto> lottoTickets = new ArrayList<>();
        for (int i = 0; i < manualNumbers.size(); i++) {
            lottoTickets.add(changeStringToLottoTickets(manualNumbers.get(i)));
        }
        for (int i = 0; i < checkAutoNumber(manual, money); i++) {
            lottoTickets.add(changeIntegerToLottoTickets(setRandomNumbers(setRandomList())));
        }
        return lottoTickets;
    }

    public Lotto changeStringToLottoTickets(String numbers) throws LottoException {
        String[] lottoNumbers = numbers.split(",");
        if (lottoNumbers.length != 6) {
            throw new LottoException("예외 발생 - 로또 번호를 6개만 입력해주세요.");
        }
        Lotto lotto = new Lotto();
        for (int i = 0; i < lottoNumbers.length; i++) {
            lotto.setLotto(Integer.parseInt(lottoNumbers[i]));
        }
        return lotto;
    }

    public ArrayList<Integer> setRandomList() {
        ArrayList<Integer> randomList = new ArrayList<>();
        for (int i = 1; i < 46; i++) {
            randomList.add(i);
        }
        return randomList;
    }

    public ArrayList<Integer> setRandomNumbers(ArrayList<Integer> randomList) {
        Collections.shuffle(randomList);
        ArrayList<Integer> randomNumbers = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            randomNumbers.add(randomList.get(i));
        }
        return randomNumbers;
    }

    public Lotto changeIntegerToLottoTickets(ArrayList<Integer> randomNumbers) throws LottoException {
        Lotto lotto = new Lotto();
        for (int i = 0; i < randomNumbers.size(); i++) {
            lotto.setLotto(randomNumbers.get(i));
        }
        return lotto;
    }
}
