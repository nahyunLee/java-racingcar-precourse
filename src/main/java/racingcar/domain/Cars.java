package racingcar.domain;

import racingcar.domain.strategy.MovingStrategy;
import racingcar.domain.strategy.NumberGenerateStrategy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Cars {

    private List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars createCarsWithNames(List<String> carNames) {
        validCarsSize(carNames.size());

        return new Cars(createCarList(carNames));
    }

    public static Cars createCarsWithCarList(List<Car> cars) {
        validCarsSize(cars.size());

        return new Cars(cars);
    }

    private static void validCarsSize(int size) {
        if (size < 2) {
            throw new IllegalArgumentException("자동차는 최소 2대가 필요합니다.");
        }
    }

    private static List<Car> createCarList(List<String> carNames) {
        List<Car> createdCares = new ArrayList<>();

        for (String carName : carNames) {
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
