package racingcar.domain;

import racingcar.domain.strategy.MovingStrategy;
import racingcar.domain.strategy.NumberGenerateStrategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import static racingcar.domain.ErrorMessage.CARS_SIZE;

public class Cars {

    private List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars createCarsWithNames(CarNames carNames) {
        validCarsSize(carNames.getSize());

        return new Cars(createCarList(carNames));
    }

    public static Cars createCarsWithCarList(List<Car> cars) {
        validCarsSize(cars.size());

        return new Cars(cars);
    }

    private static void validCarsSize(int size) {
        if (size < 2) {
            throw new IllegalArgumentException(CARS_SIZE);
        }
    }

    private static List<Car> createCarList(CarNames carNames) {
        List<Car> createdCares = new ArrayList<>();

        for (String carName : carNames.getCarNames()) {
            createdCares.add(Car.createCar(carName));
        }
        return createdCares;
    }

    public GameRoundResult carsPlayRound(MovingStrategy movingStrategy, NumberGenerateStrategy numberGenerateStrategy) {
        HashMap<String, Integer> playedOneRoundResultMap = new HashMap<>();

        for (Car car : cars) {
            CarStatus carStatus = movingStrategy.playRound(numberGenerateStrategy.generateNumber());
            car.playRound(carStatus);
            playedOneRoundResultMap.put(car.getName(), car.getPosition());
        }

        return GameRoundResult.createGameRoundResult(playedOneRoundResultMap);
    }

    public CarNames getWinnerCarNames() {
        List<String> winnerCars = new ArrayList<>();
        int maxPosition = this.getMaxPosition();

        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winnerCars.add(car.getName());
            }
        }

        return CarNames.createCarNames(winnerCars);
    }

    private int getMaxPosition() {
        int maxPosition = 0;

        for (Car car : cars) {
            maxPosition = Math.max(maxPosition, car.getPosition());
        }

        return maxPosition;
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }
}
