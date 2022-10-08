package racingcar.domain;

import static racingcar.domain.ErrorMessage.MOVE_ONLY_FORWARD;

public class CarPosition {

    private int position;

    public CarPosition(int position) {
        this.position = position;
    }

    public static CarPosition createCarPosition() {
        return new CarPosition(0);
    }

    public void move(int moveDistance) {
        this.validMoveDistance(moveDistance);
        this.position += moveDistance;
    }

    private void validMoveDistance(int moveDistance) {
        if (moveDistance < 0) {
            throw new IllegalStateException(MOVE_ONLY_FORWARD);
        }
    }

    public int getPosition() {
        return position;
    }
}
