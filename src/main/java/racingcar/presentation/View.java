package racingcar.presentation;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class View {

    public static String getCarsNameAnswer() {
        System.out.println("경주할 자동차 이름(이름은 쉼표(,) 기준으로 구분)");
        return readLine();
    }

    public static String getRoundNumberAnswer() {
        System.out.println("시도할 회수는 몇회인가요?");
        return readLine();
    }
}
