package racingcar.application;

import racingcar.domain.Cars;
import racingcar.domain.GameRoundResult;
import racingcar.domain.strategy.CarMovingStrategy;
import racingcar.domain.strategy.MovingStrategy;
import racingcar.domain.strategy.NumberGenerateStrategy;
import racingcar.domain.strategy.RandomNumberGenerateStrategy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.String.format;

public class RacingGameService {

    private static final String CAR_NAME_SPLITTER = ",";

    public List<GameRoundResult> playGame(String carsNameAnswer, String roundNumberAnswer) {
        validCarsNameAnswer(carsNameAnswer);
        validRoundNumberAnswer(roundNumberAnswer);

        String[] carNames = carsNameAnswer.split(CAR_NAME_SPLITTER);
        Cars cars = Cars.createCarsWithNames(Arrays.asList(carNames));
        int roundNumber = Integer.parseInt(roundNumberAnswer);
        List<GameRoundResult> gameRoundResults = new ArrayList<>();

        MovingStrategy movingStrategy = new CarMovingStrategy();
        NumberGenerateStrategy numberGenerateStrategy = new RandomNumberGenerateStrategy();

        for (int i = 0; i < roundNumber; i++) {
            gameRoundResults.add(cars.carsPlayRound(movingStrategy, numberGenerateStrategy));
        }

        return gameRoundResults;
    }

    private void validCarsNameAnswer(String carNameAnswer) {
        String lastString = Character.toString(carNameAnswer.charAt(carNameAnswer.length() - 1));
        if (CAR_NAME_SPLITTER.equals(lastString)) {
            throw new IllegalArgumentException(format("자동차들의 이름은 쉼표(%s)로 구분되어야 합니다.", CAR_NAME_SPLITTER));
        }
    }

    private void validRoundNumberAnswer(String roundNumberAnswer) {
        validInteger(roundNumberAnswer);
        validNumberRange(roundNumberAnswer);
    }

    private void validInteger(String roundNumberAnswer) {
        try {
            Integer.parseInt(roundNumberAnswer);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도할 횟수는 숫자만 입력 가능합니다.");
        }
    }

    private void validNumberRange(String roundNumberAnswer) {
        if (Integer.parseInt(roundNumberAnswer) <= 0) {
            throw new IllegalArgumentException("시도할 횟수는 1번 이상이어야 합니다.");
        }
    }
}
