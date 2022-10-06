package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

public class GameRoundResultTest {
    //메세지
    //각 게임 라운드의 결과의 정보를 반환한다.
    //각 게임 라운드에 참가한 자동차의 이름과 그 자동차의 위치를 나타낸다
    //이미 끝난 게임의 라운드이므로 반환받은 결과를 수정할 수 없다.

    private String car1Name = "car1";
    private String car2Name = "car2";
    private int car1Position = 3;
    private int car2Position = 4;
    private Map<String, Integer> playedOneRoundResultMap;

    @BeforeEach
    private void setPlayOneRound() {
        playedOneRoundResultMap = new HashMap<>();
        playedOneRoundResultMap.put(car1Name, car1Position);
        playedOneRoundResultMap.put(car2Name, car2Position);
    }

    @Test
    @DisplayName("한 게임 라운드를 진행한 결과 일급컬렉션을 생성한다.")
    void test_getGameRoundResult() {

        //when
        assertDoesNotThrow(() -> GameRoundResult.createGameRoundResult(playedOneRoundResultMap));
    }

    @Test
    @DisplayName("한 게임 라운드를 진행한 자동차의 이름과 그 자동차의 위치를 반환한다.")
    void test_getCarNameAndPosition() {
        //given
        GameRoundResult gameRoundResult = GameRoundResult.createGameRoundResult(playedOneRoundResultMap);

        //when
        Map<String, Integer> gameRoundResultMap = gameRoundResult.getGameRoundResultMap();

        //then
        assertAll(
                () -> assertThat(gameRoundResultMap.get(car1Name)).isEqualTo(car1Position),
                () -> assertThat(gameRoundResultMap.get(car2Name)).isEqualTo(car2Position)
        );
    }

    @Test
    @DisplayName("반환받은 게임 결과 정보들은 수정하려고 하면 UnsupportedOperationException을 반환한다.")
    void test_cannotModify() {
        //given
        GameRoundResult gameRoundResult = GameRoundResult.createGameRoundResult(playedOneRoundResultMap);

        //when
        Map<String, Integer> gameRoundResultMap = gameRoundResult.getGameRoundResultMap();

        //then
        assertThatThrownBy(() -> gameRoundResultMap.replace(car1Name, 10))
                .isInstanceOf(UnsupportedOperationException.class);
    }
}
