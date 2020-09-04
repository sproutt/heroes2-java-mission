public class LottoMoney {
    private int lottoMoney;
    private int lottoTicketNumber;
    final int ONE_LOTTO_PRICE=1000;

    public LottoMoney(int money) throws LottoException {
        if(money<ONE_LOTTO_PRICE){
            throw new LottoException("예외 발생 - 1000원 이상을 입력하세요.");
        }
        if(money%ONE_LOTTO_PRICE!=0){
            throw new LottoException("예외 발생 - 1000원 단위로 입력하세요.");
        }
        this.lottoMoney = money;
        this.lottoTicketNumber=this.lottoMoney/ONE_LOTTO_PRICE;
    }
    public int getLottoMoney(){
        return this.lottoMoney;
    }
    public int getLottoTicketNumber(){
        return this.lottoTicketNumber;
    }
}
