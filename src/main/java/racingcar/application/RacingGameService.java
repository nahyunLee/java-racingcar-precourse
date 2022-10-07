package racingcar.application;

import racingcar.domain.CarNames;
import racingcar.domain.Cars;
import racingcar.domain.GameResult;
import racingcar.domain.GameRoundResults;
import racingcar.domain.strategy.CarMovingStrategy;
import racingcar.domain.strategy.RandomNumberGenerateStrategy;

import java.util.Arrays;

import static racingcar.application.ValidService.validCarsNameAnswer;
import static racingcar.application.ValidService.validRoundNumberAnswer;
import static racingcar.presentation.CarViewConstants.CAR_NAME_SPLITTER;

public class RacingGameService {

    public GameResult startGame(String carsNameAnswer, String roundNumberAnswer) {
        validCarsNameAnswer(carsNameAnswer);
        validRoundNumberAnswer(roundNumberAnswer);

        Cars cars = createCars(carsNameAnswer);

        GameRoundResults gameRoundResults = this.playGameRounds(cars, Integer.parseInt(roundNumberAnswer));

        return GameResult.createGameResult(gameRoundResults, cars.getWinnerCarNames());
    }

    Cars createCars(String carsNameAnswer) {
        String[] carNamesSplit = carsNameAnswer.split(CAR_NAME_SPLITTER);
        CarNames carNames = CarNames.createCarNames(Arrays.asList(carNamesSplit));

        return Cars.createCarsWithNames(carNames);
    }

    private GameRoundResults playGameRounds(Cars cars, int roundCount) {
        GameRoundResults gameRoundResults = GameRoundResults.createEmptyGameRoundResults();
        for (int i = 0; i < roundCount; i++) {
            gameRoundResults.addGameRoundResult(cars.carsPlayRound(new CarMovingStrategy(), new RandomNumberGenerateStrategy()));
        }

        return gameRoundResults;
    }
}
