package lottodomain;

import java.util.List;
import java.util.stream.Collectors;

public class WinningNos {
    private List<LottoNo> winningNos;
    private LottoNo bonusNo;

    public WinningNos(List<Integer> winningNos, int bonusNo) {
        this.winningNos = winningNos.stream().map(number -> new LottoNo(number))
                .collect(Collectors.toList());
        this.bonusNo = new LottoNo(bonusNo);
    }

    public int countMatchOf(Lotto lotto) {
        return winningNos.stream().filter(lotto::contains).collect(Collectors.toList()).size();
    }

    public boolean isBonus(Lotto lotto) {
        return lotto.contains(bonusNo);
    }
}
