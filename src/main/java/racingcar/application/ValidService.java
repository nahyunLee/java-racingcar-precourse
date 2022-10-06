package racingcar.application;

import static java.lang.String.format;
import static racingcar.application.CarConstants.CAR_NAME_SPLITTER;

public class ValidService {

    public static void validCarsNameAnswer(String carNameAnswer) {
        String lastString = Character.toString(carNameAnswer.charAt(carNameAnswer.length() - 1));
        if (CAR_NAME_SPLITTER.equals(lastString)) {
            throw new IllegalArgumentException(format("자동차들의 이름은 쉼표(%s)로 구분되어야 합니다.", CAR_NAME_SPLITTER));
        }
    }

    public static void validRoundNumberAnswer(String roundNumberAnswer) {
        validInteger(roundNumberAnswer);
        validNumberRange(roundNumberAnswer);
    }

    private static void validInteger(String roundNumberAnswer) {
        try {
            Integer.parseInt(roundNumberAnswer);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도할 횟수는 숫자만 입력 가능합니다.");
        }
    }

    private static void validNumberRange(String roundNumberAnswer) {
        if (Integer.parseInt(roundNumberAnswer) <= 0) {
            throw new IllegalArgumentException("시도할 횟수는 1번 이상이어야 합니다.");
        }
    }
}
