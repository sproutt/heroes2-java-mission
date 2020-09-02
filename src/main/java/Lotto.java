import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private List<LottoNo> lottoNos;
    public Lotto(List<Integer> lottoNos) {
        this.lottoNos = lottoNos.stream().map(number -> {return new LottoNo(number);}).collect(Collectors.toList());
    }

    public List<LottoNo> getLottoNos() {
        return lottoNos;
    }
}
