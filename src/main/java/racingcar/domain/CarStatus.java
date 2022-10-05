package racingcar.domain;

public enum CarStatus {
    MOVE, STOP;

    public static boolean isMoveStatus(CarStatus carStatus) {
        return carStatus == MOVE;
    }
}
