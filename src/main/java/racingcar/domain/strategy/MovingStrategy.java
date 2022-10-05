package racingcar.domain.strategy;

import racingcar.domain.CarStatus;

public interface MovingStrategy {
    CarStatus playRound(int number);
}
