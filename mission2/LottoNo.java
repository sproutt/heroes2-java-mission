public class LottoNo {
    private int lottoNumber;
    public LottoNo(int number) throws LottoException{
        if(number<1 || number >45){
            throw new LottoException("예외 발생 - 1~45사이의 숫자를 입력하세요.");
        }
        this.lottoNumber=number;
    }
    public int getLottoNumber(){
        return this.lottoNumber;
    }
}
