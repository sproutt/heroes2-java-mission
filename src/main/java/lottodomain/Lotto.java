package lottodomain;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Lotto {
    private List<LottoNo> lottoNos;

    public Lotto(List<Integer> lottoNos) {
        Collections.sort(lottoNos);
        this.lottoNos = lottoNos.stream().map(number -> new LottoNo(number)).collect(Collectors.toList());
    }

    public List<LottoNo> getLottoNos() {
        return lottoNos;
    }

    public boolean contains(LottoNo lottoNo) {
        return lottoNos.contains(lottoNo);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Lotto lotto = (Lotto) o;
        return Objects.equals(lottoNos, lotto.lottoNos);
    }
}

