public class Main {

    public static void main(String[] args) {
//        Rank[] ranks = Rank.values();
//        for (Rank rank: ranks) {
//            System.out.println(rank);
//            System.out.println(rank.getCountOfMatch());
//            System.out.println(rank.getWinningMoney());
//        }
//        Rank rank = Rank.valueOf("SECOND");
//        System.out.println(rank);
//        System.out.println(rank.getCountOfMatch());
//        System.out.println(rank.getWinningMoney());
        Rank temp = Rank.valueOf(3, false);
        System.out.println(temp);
    }
}
