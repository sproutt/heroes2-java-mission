import java.util.Objects;

public class LottoNo {
    private Integer value;

    public LottoNo(int number) {
        value = number;
    }

    public int getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNo lottoNo = (LottoNo) o;
        return value == lottoNo.value;
    }
}
