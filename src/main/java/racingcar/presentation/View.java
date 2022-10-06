package racingcar.presentation;

import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static racingcar.presentation.CarViewConstants.CAR_NAME_SPLITTER;
import static racingcar.presentation.CarViewConstants.CAR_POSITION_VIEW;

public class View {

    public static String getCarsNameAnswer() {
        System.out.println("경주할 자동차 이름(이름은 쉼표(,) 기준으로 구분)");
        return readLine();
    }

    public static String getRoundNumberAnswer() {
        System.out.println("시도할 회수는 몇회인가요?");
        return readLine();
    }

    public static void printCarNameWithPosition(String carName, int carPosition) {
        StringBuilder carPositionView = new StringBuilder();
        for (int i = 0; i < carPosition; i++) {
            carPositionView.append(CAR_POSITION_VIEW);
        }

        System.out.println(carName + " : " + carPositionView.toString());
    }

    public static void printWinner(List<String> winnerNames) {
        StringBuilder winnerNameBuilder = new StringBuilder();
        for (String carName : winnerNames) {
            winnerNameBuilder.append(carName);
            winnerNameBuilder.append(CAR_NAME_SPLITTER);
        }

        System.out.println("최종 우승자 : " + removeLastSplitter(winnerNameBuilder.toString()));
    }

    private static String removeLastSplitter(String winner) {
        return winner.substring(0, winner.length() - 1);
    }

    public static void printResultInformation() {
        System.out.println("실행 결과");
    }

    public static void printNewLine() {
        System.out.println();
    }
}
