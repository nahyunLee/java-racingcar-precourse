package racingcar.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.domain.Fixtures.car1;
import static racingcar.domain.Fixtures.car2;

public class GameResultTest {

    private List<GameRoundResult> gameRoundResults;
    private List<String> winnerCarNames;

    @BeforeEach
    private void playGame() {
        Car car1 = car1();
        Car car2 = car2();

        Map<String, Integer> firstRoundResultMap = new HashMap<>();
        firstRoundResultMap.put(car1.getName(), 1);
        firstRoundResultMap.put(car2.getName(), 0);
        GameRoundResult firstRoundResult = GameRoundResult.createGameRoundResult(firstRoundResultMap);

        Map<String, Integer> secondRoundResultMap = new HashMap<>();
        secondRoundResultMap.put(car1.getName(), 2);
        secondRoundResultMap.put(car2.getName(), 0);
        GameRoundResult secondRoundResult = GameRoundResult.createGameRoundResult(secondRoundResultMap);

        gameRoundResults = Arrays.asList(firstRoundResult, secondRoundResult);

        winnerCarNames = Collections.singletonList(car1.getName());
    }

    @Test
    @DisplayName("게임의 총 결과를 생성한다.")
    void test_createGameResult() {
        Assertions.assertDoesNotThrow(() -> GameResult.createGameResult(gameRoundResults, winnerCarNames));
    }

    @Test
    @DisplayName("반환된 게임 라운드 결과들을 수정하고자 하면 UnsupportedOperationException을 반환한다.")
    void test_modifyGameRoundResults() {
        //given
        GameResult gameResult = GameResult.createGameResult(gameRoundResults, winnerCarNames);
        List<GameRoundResult> gameRoundResultList = gameResult.getGameRoundResultList();

        //when then
        assertThatThrownBy(() -> gameRoundResultList.get(0).getGameRoundResultMap().put("car3", 1))
                .isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    @DisplayName("반환된 게임 우승자 결과들을 수정하고자 하면 UnsupportedOperationException을 반환한다.")
    void test_modifyGameWinners() {
        //given
        GameResult gameResult = GameResult.createGameResult(gameRoundResults, winnerCarNames);
        List<String> gameWinners = gameResult.getWinnerCars();

        //when then
        assertThatThrownBy(() -> gameWinners.add("car3"))
                .isInstanceOf(UnsupportedOperationException.class);
    }
}
