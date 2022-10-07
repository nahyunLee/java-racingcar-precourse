package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class CarNamesTest {

    @Test
    @DisplayName("자동차둘의 이름이 담긴 일급컬렉션을 생성한다.")
    void test_createWinnerCarNames() {
        //given
        String winner1 = "car1";
        String winner2 = "car2";

        List<String> carNameList = Arrays.asList(winner1, winner2);

        //when
        CarNames carNames = CarNames.createCarNames(carNameList);

        //then
        assertAll(
                () -> assertThat(carNames.getCarNames().get(0)).isEqualTo(winner1),
                () -> assertThat(carNames.getCarNames().get(1)).isEqualTo(winner2)
        );
    }

    @Test
    @DisplayName("반환받은 자동차 이름들은 수정하려고 하면 UnsupportedOperationException을 반환한다.")
    void test_cannotModify() {
        //given
        String winner1 = "car1";
        String winner2 = "car2";

        CarNames carNames = CarNames.createCarNames(Arrays.asList(winner1, winner2));

        //when
        List<String> carNameList = carNames.getCarNames();

        //then
        assertThatThrownBy(() -> carNameList.add("car3"))
                .isInstanceOf(UnsupportedOperationException.class);
    }
}
