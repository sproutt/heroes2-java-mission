package lottodomain;

import java.util.List;

public class WinningLotto {
    private List<LottoNo> lottoNos;
    private Rank lottoPrize;

    public WinningLotto(Lotto lotto, Rank lottoPrize) {
        lottoNos = lotto.getLottoNos();
        this.lottoPrize = lottoPrize;
    }

    public List<LottoNo> getLottoNos() {
        return lottoNos;
    }

    public Rank getLottoPrize() {
        return lottoPrize;
    }
}
