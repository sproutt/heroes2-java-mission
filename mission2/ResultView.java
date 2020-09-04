public class ResultView {
    public static void viewResult(int[] rankCheck) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        System.out.println("3개 일치 (5000원)-" + rankCheck[0] + "개");
        System.out.println("4개 일치 (50000원)-" + rankCheck[1] + "개");
        System.out.println("5개 일치 (1500000원)-" + rankCheck[2] + "개");
        System.out.println("5개 일치, 보너스 볼 일치(30000000원)-" + rankCheck[3] + "개");
        System.out.println("6개 일치 (2000000000원)-" + rankCheck[4] + "개");
    }

    public static void viewProfitPercent(LottoMoney money, int prizeMoney) {
        System.out.println("총 수익률은 " + RankingJudgment.calculateProfitPercent(money, prizeMoney) + "%입니다.");
    }
}
