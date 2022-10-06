package racingcar.domain;

import java.util.Collections;
import java.util.List;

public class GameResult {

    private List<GameRoundResult> gameRoundResultList;
    private List<String> winnerCarNames;

    private GameResult(List<GameRoundResult> gameRoundResultList, List<String> winnerCarNames) {
        this.gameRoundResultList = gameRoundResultList;
        this.winnerCarNames = winnerCarNames;
    }

    public static GameResult createGameResult(List<GameRoundResult> gameRoundResultList, List<String> winnerCars) {
        return new GameResult(gameRoundResultList, winnerCars);
    }

    public List<GameRoundResult> getGameRoundResultList() {
        return Collections.unmodifiableList(gameRoundResultList);
    }

    public List<String> getWinnerCars() {
        return Collections.unmodifiableList(winnerCarNames);
    }
}
