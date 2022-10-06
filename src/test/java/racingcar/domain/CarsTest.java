package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import racingcar.domain.strategy.CarMovingStrategy;
import racingcar.domain.strategy.MovingStrategy;
import racingcar.domain.strategy.NumberGenerateStrategy;
import racingcar.domain.strategy.RandomNumberGenerateStrategy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static racingcar.domain.Fixtures.car1;
import static racingcar.domain.Fixtures.car2;

public class CarsTest {
    //메세지
    //자동차 리스트로 일급컬렉션 Cars를 생성할 수 있다.
    //자동차 리스트가 비어있는 일급컬렉션 Cars는 생성할 수 없다.
    //게임 라운드가 시작되면 차들을 이동시킨다.
    //게임 최종 우승자를 반환한다.

    @Test
    @DisplayName("자동차 리스트로 일급컬렉션 Cars를 생성한다.")
    void test_createCars() {
        assertDoesNotThrow(() -> Cars.createCars(Arrays.asList(car1(), car2())));
    }

    @ParameterizedTest
    @MethodSource("invalidSizeCarList")
    @DisplayName("자동차가 1개 이하인 리스트로 일급컬렉션 Cars를 생성하면 IllegalArgumentExceptiond을 반환한다. ")
    void createCars_withEmptyList(List<Car> cars) {
        assertThatThrownBy(() -> Cars.createCars(cars))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차는 최소 2대가 필요합니다.");
    }

    private static Stream<Arguments> invalidSizeCarList() {
        return Stream.of(
                Arguments.of(new ArrayList<>()),
                Arguments.of(Collections.singletonList(Car.createCar("1")))
        );
    }

    @Test
    @DisplayName("자동차들을 게임 한라운드 플레이한다.")
    void testMoveCars() {
        //given
        Cars cars = Cars.createCars(Arrays.asList(car1(), car2()));

        //when
        cars.carsPlayRound(new CarMovingStrategy(), new RandomNumberGenerateStrategy());

        //then
        assertAll(
                () -> assertThat(car1().getPosition()).isBetween(0, 1),
                () -> assertThat(car2().getPosition()).isBetween(0, 1)
        );
    }

    @Test
    @DisplayName("최종 우승자들을 반환한다.")
    void test_getWinners() {
        //given
        Car car1 = car1();
        car1.playRound(CarStatus.MOVE);
        car1.playRound(CarStatus.MOVE);

        Car car2 = car2();
        car2.playRound(CarStatus.MOVE);
        car2.playRound(CarStatus.STOP);

        Car car3 = Car.createCar("3");
        car3.playRound(CarStatus.MOVE);
        car3.playRound(CarStatus.MOVE);

        Cars cars = Cars.createCars(Arrays.asList(car1, car2, car3));

        //when
        List<Car> winnerCars = cars.getWinners();

        //then
        assertAll(
                () -> assertThat(winnerCars.contains(car1)).isTrue(),
                () -> assertThat(winnerCars.contains(car3)).isTrue()
        );
    }
}
