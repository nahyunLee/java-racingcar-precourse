package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CarNames {

    private List<CarName> carNames;

    public CarNames(List<CarName> carNames) {
        this.carNames = carNames;
    }

    public static CarNames createCarNamesWithStringCarName(List<String> carNameList) {
        List<CarName> carNames = new ArrayList<>();
        for (String carName : carNameList) {
            carNames.add(CarName.createCarName(carName));
        }

        return new CarNames(carNames);
    }

    public static CarNames createCarNamesWithCarName(List<CarName> carNames) {
        return new CarNames(carNames);
    }

    public List<CarName> getCarNames() {
        return Collections.unmodifiableList(carNames);
    }

    public int getSize() {
        return carNames.size();
    }
}
