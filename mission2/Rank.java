public enum Rank {
    FIRST(6, 2000000000),
    SECOND(5, 30000000),
    THIRD(5, 1500000),
    FOURTH(4, 50000),
    FIFTH(3, 5000),
    MISS(0, 0);
    private int countOfMatch;
    private int winningMoney;

    private Rank(int countOfMatch, int winningMoney) {
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public int getWinningMoney() {
        return winningMoney;
    }

    public static Rank valueOf(int countOfMatch, boolean matchBonus) {
        Rank rank = MISS;
        if (countOfMatch == 3) {
            rank = FIFTH;
        }
        if (countOfMatch == 4) {
            rank = FOURTH;
        }
        if (countOfMatch == 5 && matchBonus == false) {
            rank = THIRD;
        }
        if (countOfMatch == 5 && matchBonus) {
            rank = SECOND;
        }
        if (countOfMatch == 6) {
            rank = FIRST;
        }
        return rank;
    }

    public static int calculateWinningMoney(int[] rankCheck) {
        Rank rankFirst = Rank.FIRST;
        Rank rankSecond = Rank.SECOND;
        Rank rankThird = Rank.THIRD;
        Rank rankFourth = Rank.FOURTH;
        Rank rankFifth = Rank.FIFTH;
        int sum = rankFirst.winningMoney * rankCheck[4];
        sum += rankSecond.winningMoney * rankCheck[3];
        sum += rankThird.winningMoney * rankCheck[2];
        sum += rankFourth.winningMoney * rankCheck[1];
        sum += rankFifth.winningMoney * rankCheck[0];
        return sum;
    }
}