import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoGenerator {
    private static List<Integer> lottoNoPool;

    public static Lotto generateLottoWithNos(List<Integer> lottoNos) {
        return new Lotto(lottoNos);
    }

    public static Lotto generateAutoLotto() {
        return generateLottoWithNos(getRandomLottoNos());
    }

    private static List<Integer> getRandomLottoNos() {
        lottoNoPool = IntStream.rangeClosed(1, 45).boxed().collect(Collectors.toList());
        Collections.shuffle(lottoNoPool);
        return lottoNoPool.subList(0, 6);
    }
}
