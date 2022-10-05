package racingcar.domain;

public class Car {

    private static final int CAR_NAME_MAX_LENGTH = 5;
    private static final int CAR_MOVE_DISTANCE = 1;

    private String name;
    private int position;

    public Car(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public static Car createCar(String name) {
        validCarName(name);

        return new Car(name, 0);
    }

    private static void validCarName(String name) {
        if (name.length() > CAR_NAME_MAX_LENGTH) {
            throw new IllegalArgumentException("자동차의 이름은 5자 이하만 가능합니다.");
        }
    }

    public void playRound(CarStatus carStatus) {
        if (carStatus.equals(CarStatus.MOVE)) {
            this.position += CAR_MOVE_DISTANCE;
        }
    }

    public int getPosition() {
        return position;
    }
}
