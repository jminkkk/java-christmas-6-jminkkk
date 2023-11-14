package christmas.util;

import java.text.DecimalFormat;

public class MoneyFormatter {
    private static final String MONEY_UNIT = "원";
    private static final String MINUS = "-";
    public static String format(int money) {
        DecimalFormat decimalFormat = new DecimalFormat("#,###.#");
        return decimalFormat.format(money) + MONEY_UNIT;
    }

    public static String minusFormat(int money) {
        if (money == 0) {
            return format(money);
        }
        return MINUS + format(money);
    }
}
