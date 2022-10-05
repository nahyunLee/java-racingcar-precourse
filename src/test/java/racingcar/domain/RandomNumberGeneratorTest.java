package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomNumberGeneratorTest {

    @Test
    @DisplayName("0에서 9까지의 랜덤값을 생성한다.")
    void createRandomNumber() {
        //given
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();

        //when
        int randomNumber = randomNumberGenerator.createRandomNumber();

        //then
        assertThat(randomNumber).isBetween(0, 9);
    }
}
