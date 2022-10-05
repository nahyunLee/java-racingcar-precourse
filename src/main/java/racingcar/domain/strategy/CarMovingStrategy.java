package racingcar.domain.strategy;

import racingcar.domain.CarStatus;

public class CarMovingStrategy implements MovingStrategy{

    private static final int MOVING_STATUS_NUMBER = 4;

    @Override
    public CarStatus playRound(int number) {
        if (number >= MOVING_STATUS_NUMBER) {
            return CarStatus.MOVE;
        }
        return CarStatus.STOP;
    }
}
