package racingcar.domain;

public class Car {

    private static final int CAR_NAME_MAX_LENGTH = 5;
    private static final int CAR_MOVE_DISTANCE = 1;

    private String name;
    private CarPosition position;

    public Car(String name, CarPosition position) {
        this.name = name;
        this.position = position;
    }

    public static Car createCar(String name) {
        validCarName(name);

        return new Car(name, CarPosition.createCarPosition());
    }

    private static void validCarName(String name) {
        if (name.length() > CAR_NAME_MAX_LENGTH) {
            throw new IllegalArgumentException("자동차의 이름은 5자 이하만 가능합니다.");
        }
    }

    public void playRound(CarStatus carStatus) {
        if (CarStatus.isMoveStatus(carStatus)) {
            position.move(CAR_MOVE_DISTANCE);
        }
    }

    public int getPosition() {
        return position.getPosition();
    }
}
