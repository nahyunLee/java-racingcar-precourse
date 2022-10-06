package racingcar.domain;

import java.util.Collections;
import java.util.Map;

public class GameRoundResult {

    private Map<String, Integer> playedOneRoundResultMap;

    private GameRoundResult(Map<String, Integer> playedOneRoundResultMap) {
        this.playedOneRoundResultMap = playedOneRoundResultMap;
    }

    public static GameRoundResult createGameRoundResult(Map<String, Integer> playedOneRoundResultMap) {
        return new GameRoundResult(playedOneRoundResultMap);
    }

    public Map<String, Integer> getGameRoundResultMap() {
        return Collections.unmodifiableMap(playedOneRoundResultMap);
    }
}
