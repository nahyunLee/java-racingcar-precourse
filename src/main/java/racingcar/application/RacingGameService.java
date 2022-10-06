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

import static racingcar.application.CarConstants.CAR_NAME_SPLITTER;
import static racingcar.application.ValidService.validCarsNameAnswer;
import static racingcar.application.ValidService.validRoundNumberAnswer;

public class RacingGameService {

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
}
