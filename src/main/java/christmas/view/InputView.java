package christmas.view;

import static christmas.exception.Exception.INVALID_DATE;
import static christmas.exception.Exception.INVALID_ORDER;

import camp.nextstep.edu.missionutils.Console;
import java.util.regex.Pattern;

public class InputView {
    private static final String regex = ".*[가-힣,-]+.*";
    public static int readVisitDate() {
        try {
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_DATE.getMessage());
        }
    }

    public static String readMenuAndCount() {
        String menuAndCount = Console.readLine();
        validate(menuAndCount);
        return menuAndCount;
    }

    public static void validate(String menuAndCount) {
        if (!Pattern.matches(regex, menuAndCount)) {
            throw new IllegalArgumentException(INVALID_ORDER.getMessage());
        }
    }
}