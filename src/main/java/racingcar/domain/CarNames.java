package racingcar.domain;

import java.util.Collections;
import java.util.List;

public class CarNames {

    private List<String> carNames;

    public CarNames(List<String> carNames) {
        this.carNames = carNames;
    }

    public static CarNames createCarNames(List<String> carNames) {
        return new CarNames(carNames);
    }

    public List<String> getCarNames() {
        return Collections.unmodifiableList(carNames);
    }

    public int getSize() {
        return carNames.size();
    }
}
