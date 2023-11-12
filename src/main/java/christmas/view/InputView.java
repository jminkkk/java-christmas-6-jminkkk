package christmas.view;

import static christmas.exception.Exception.ONLY_NUMBER_ALLOWED;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static int readVisitDate() {
        try {
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ONLY_NUMBER_ALLOWED.getMessage());
        }
    }

    public static String readMenuAndCount() {
        return Console.readLine();
    }
}