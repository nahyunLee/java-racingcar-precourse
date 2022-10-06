package racingcar.application;

import racingcar.domain.Cars;
import racingcar.domain.GameResult;
import racingcar.domain.GameRoundResult;
import racingcar.domain.strategy.CarMovingStrategy;
import racingcar.domain.strategy.RandomNumberGenerateStrategy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static racingcar.presentation.CarViewConstants.CAR_NAME_SPLITTER;
import static racingcar.application.ValidService.validCarsNameAnswer;
import static racingcar.application.ValidService.validRoundNumberAnswer;

public class RacingGameService {

    public GameResult startGame(String carsNameAnswer, String roundNumberAnswer) {
        validCarsNameAnswer(carsNameAnswer);
        validRoundNumberAnswer(roundNumberAnswer);

        Cars cars = createCars(carsNameAnswer);

        List<GameRoundResult> gameRoundResults = this.playGameRounds(cars, Integer.parseInt(roundNumberAnswer));

        return GameResult.createGameResult(gameRoundResults, cars.getWinnerCarNames());
    }

    Cars createCars(String carsNameAnswer) {
        String[] carNames = carsNameAnswer.split(CAR_NAME_SPLITTER);
        return Cars.createCarsWithNames(Arrays.asList(carNames));
    }

    private List<GameRoundResult> playGameRounds(Cars cars, int roundCount) {
        List<GameRoundResult> gameRoundResults = new ArrayList<>();
        for (int i = 0; i < roundCount; i++) {
            gameRoundResults.add(cars.carsPlayRound(new CarMovingStrategy(), new RandomNumberGenerateStrategy()));
        }

        return gameRoundResults;
    }
}
