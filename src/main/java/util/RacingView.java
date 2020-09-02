package util;

import java.util.List;
import java.util.stream.Collectors;

import domain.*;

public final class RacingView {
    private static final char[] carShape = {'□', '■', '▦', '▩', '▥', '▤', '▨', '▧'};

    public static void showRaceStart() {
        System.out.println("실행결과");
    }

    public static void showRaceHistory(RacingHistory history) {
        history.getHistory().stream().forEach(racingStamp -> showRaceStamp(racingStamp));
    }

    public static void showRaceStamp(RacingStamp racingStamp) {
        racingStamp.getRacingStamp().stream().forEach(carStamp -> {
            System.out.print(carStamp.getCarName() + " : ");
            showCarMovement(carStamp.getPosition(), carStamp.getCarShapeId());
        });
        System.out.println();
    }

    public static void showCarMovement(int position, int carShapeId) {
        String carLogs = "";
        for (int i = 0; i < position ; i++) {
            carLogs += carShape[carShapeId];
        }
        System.out.println(carLogs);
    }

    public static void showWinner(Winner winner) {
        List<Car> winners = winner.getWinners();
        String winnersWithCommas = winners.stream().map(Car::getName).collect(Collectors.joining(", "));
        System.out.println(winnersWithCommas + "가 최종우승 했습니다.");
    }
}
