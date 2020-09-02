import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
        if (countOfMatch == 5 && matchBonus) {
            return SECOND;
        }

        Map<Integer, Rank> countOfMatchRankMapWithoutSecond = Stream.of(values()).filter(rank -> rank != SECOND)
                .collect(Collectors.toMap(Rank::getCountOfMatch, Function.identity()));
        Rank result = countOfMatchRankMapWithoutSecond.get(countOfMatch);

        if (result == null) {
            result = MISS;
        }
        return result;
    }
}
