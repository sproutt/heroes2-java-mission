package lottoview;

import java.util.List;

public class InputValidation {
    private final static int NUMBER_OF_LOTTO_NOS = 6;

    public static void validatePayment(int payment) throws ViewException {
//        if (payment < 1000) {
//            throw new ViewException("[ViewException] 구입금액은 1000원 이상이어야 합니다");
//        }
        if (payment % 1000 != 0) {
            throw new ViewException("[ViewException] 구입금액은 1000원단위로 입력해주세요");
        }
    }

    public static void validateNumberOfLottos(int numberOfLottos) throws ViewException {
        if (numberOfLottos < 0) {
            throw new ViewException("[ViewException] 로또의 수는 0이상이어야 합니다");
        }
    }

    public static void validateAllLottoNos(List<List<Integer>> lottoNos) throws ViewException {
        for (List<Integer> lottoNo : lottoNos) {
            validateLottoNos(lottoNo);
        }
    }

    public static void validateLottoNos(List<Integer> lottoNos) throws ViewException {
        if (lottoNos.size() != NUMBER_OF_LOTTO_NOS) {
            throw new ViewException("[ViewException] 로또 번호는 6자리 입니다");
        }
        for (int number : lottoNos) {
            validateNoRange(number);
        }
    }

    public static void validateNoRange(int number) throws ViewException {
        if (number <= 0 || number > 45) {
            throw new ViewException("[ViewException] 로또 번호는 1 ~ 45 범위 내의 숫자입니다");
        }
    }
}
