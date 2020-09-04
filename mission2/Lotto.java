import java.util.ArrayList;

public class Lotto  {
    private ArrayList<LottoNo> lottoNumbers=new ArrayList<>();
    public void setLotto(int number) throws LottoException{
        this.lottoNumbers.add(new LottoNo(number));
    }
    public ArrayList<LottoNo> getLottoNumbers(){
        return this.lottoNumbers;
    }
}
