package christmas.view;

import static christmas.global.Exception.INVALID_DATE;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static int readVisitDate() {
        try {
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_DATE.getMessage());
        }
    }

    public static String readMenuAndCount() {
        return Console.readLine();
    }
}