package domain;

import java.util.LinkedList;
import java.util.List;

public class RacingHistory {
    private List<RacingStamp> history;

    public RacingHistory() {
        history = new LinkedList<>();
    }

    public void write(RacingStamp racingStamp) {
        history.add(racingStamp);
    }

    public List<RacingStamp> getHistory() {
        return history;
    }
}
