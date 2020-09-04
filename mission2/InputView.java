import java.util.ArrayList;
import java.util.Scanner;

public class InputView {
    public static int setLottoMoney() throws LottoException{
        System.out.println("구입금액을 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public static int setManualLotto() throws LottoException {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public static void viewManualNumber() {
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
    }

    public static void viewTicketsCheck(ArrayList<Lotto> tickets,int manual,int auto){
        System.out.println("수동으로 "+manual+"장, 자동으로 "+auto+"개를 구매했습니다.");
        for(int i=0; i< tickets.size();i++){
            System.out.println(viewOneTicket(tickets.get(i)));
        }
    }
    public static String viewOneTicket(Lotto lotto){
        String lottoNumbers="[";
        for(int i=0; i< lotto.getLottoNumbers().size()-1;i++){
            lottoNumbers+=lotto.getLottoNumbers().get(i).getLottoNumber();
            lottoNumbers+=",";
        }
        lottoNumbers+=lotto.getLottoNumbers().get(5).getLottoNumber()+"]";
        return lottoNumbers;
    }
    public static String setWinningLotto() throws LottoException {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public static int setBonusBall() throws LottoException {
        System.out.println("보너스 볼을 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
