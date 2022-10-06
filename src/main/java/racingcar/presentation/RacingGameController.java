package racingcar.presentation;

import camp.nextstep.edu.missionutils.Console;
import racingcar.application.RacingGameService;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static racingcar.presentation.View.getCarsNameAnswer;
import static racingcar.presentation.View.getRoundNumberAnswer;

public class RacingGameController {

    public void startGame() {
        String carsNameAnswer = getCarsNameAnswer();
        String roundNumberAnswer = getRoundNumberAnswer();

        RacingGameService racingGameService = new RacingGameService();
        racingGameService.playGame(carsNameAnswer, roundNumberAnswer);

        //쉼표로 구분했는지
        //자동차 이름 유효성은 도메인이 해야함 -> 자동차 이름은 자동차의 역할이기 때문에

        //숫자인지 확인
        //1이상인지 확인
    }

}
