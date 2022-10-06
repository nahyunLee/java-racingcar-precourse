package racingcar.application;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RacingGameServiceTest {
    //메세지
    //자동차 경주를 진행하라
    //자동차 이름 입력 값을 검증하라
    //시도 회수 값을 검증하라

    private RacingGameService racingGameService = new RacingGameService();

    @Test
    @DisplayName("자동차 이름들 마지막에 쉼표가 있다면, 다음 자동차 이름 값이 없는 것으로 간주하여 IllegalArgumentException를 반환한다.")
    void test_validCarsNameAnswer() {
        //given
        String carNameAnswer = "하나,둘,셋,";
        String roundNumberAnswer = "3";

        //when
        assertThatThrownBy(() -> racingGameService.playGame(carNameAnswer, roundNumberAnswer))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차들의 이름은 쉼표(,)로 구분되어야 합니다.");
    }

    @Test
    @DisplayName("시도할 회수가 숫자가 아니라면 IllegalArgumentException를 반환한다.")
    void test_validRoundNumberAnswerInteger() {
        //given
        String carNameAnswer = "하나,둘,셋";
        String roundNumberAnswer = "삼";

        //when
        assertThatThrownBy(() -> racingGameService.playGame(carNameAnswer, roundNumberAnswer))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("시도할 횟수는 숫자만 입력 가능합니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "-3"})
    @DisplayName("시도할 회수가 0이하라면 IllegalArgumentException를 반환한다.")
    void test_validRoundNumberAnswerRange(String roundNumberAnswer) {
        //given
        String carNameAnswer = "하나,둘,셋";

        //when
        assertThatThrownBy(() -> racingGameService.playGame(carNameAnswer, roundNumberAnswer))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("시도할 횟수는 1번 이상이어야 합니다.");
    }
}
