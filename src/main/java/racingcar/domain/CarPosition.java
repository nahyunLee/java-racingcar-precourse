package racingcar.domain;

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
            throw new IllegalStateException("경주게임에서는 후진할 수 없습니다.");
        }
    }

    public int getPosition() {
        return position;
    }
}
