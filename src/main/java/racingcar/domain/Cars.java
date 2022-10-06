package racingcar.domain;

import racingcar.domain.strategy.MovingStrategy;
import racingcar.domain.strategy.NumberGenerateStrategy;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars createCars(List<Car> cars) {
        validCarsSize(cars.size());

        return new Cars(cars);
    }

    private static void validCarsSize(int size) {
        if (size < 2) {
            throw new IllegalArgumentException("자동차는 최소 2대가 필요합니다.");
        }
    }

    public void carsPlayRound(MovingStrategy movingStrategy, NumberGenerateStrategy numberGenerateStrategy) {
        for (Car car : cars) {
            CarStatus carStatus = movingStrategy.playRound(numberGenerateStrategy.generateNumber());
            car.playRound(carStatus);
        }
    }

    public List<Car> getWinners() {
        List<Car> winnerCars = new ArrayList<>();
        int maxPosition = this.getMaxPosition();

        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winnerCars.add(car);
            }
        }

        return winnerCars;
    }

    private int getMaxPosition() {
        int maxPosition = 0;

        for (Car car : cars) {
            maxPosition = Math.max(maxPosition, car.getPosition());
        }

        return maxPosition;
    }
}
