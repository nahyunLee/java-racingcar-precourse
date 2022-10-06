package racingcar.presentation;

import racingcar.application.RacingGameService;
import racingcar.domain.GameResult;
import racingcar.domain.GameRoundResult;

import java.util.List;
import java.util.Map;

import static racingcar.presentation.View.*;

public class RacingGameController {

    public void startGame() {
        String carsNameAnswer = getCarsNameAnswer();
        String roundNumberAnswer = getRoundNumberAnswer();

        RacingGameService racingGameService = new RacingGameService();
        GameResult gameResult = racingGameService.startGame(carsNameAnswer, roundNumberAnswer);

        printResultInformation();
        printGameRoundResults(gameResult.getGameRoundResultList());
        printWinner(gameResult.getWinnerCars());
    }

    private void printGameRoundResults(List<GameRoundResult> gameRoundResults) {
        for (GameRoundResult gameRoundResult : gameRoundResults) {
            printGameRoundResult(gameRoundResult.getGameRoundResultMap());
            printNewLine();
        }
    }

    private void printGameRoundResult(Map<String, Integer> gameRoundResultMap) {
        for (String carName : gameRoundResultMap.keySet()) {
            printCarNameWithPosition(carName, gameRoundResultMap.get(carName));
        }
    }
}
