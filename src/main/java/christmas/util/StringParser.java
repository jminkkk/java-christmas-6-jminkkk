package christmas.util;

public class StringParser {
    private static final String ORDER_ITEM_DELIMITER = ",";
    private static final String MENU_AND_COUNT_DELIMITER = "-";
    public static String[] splitByOrderItem(String string) {
        return string.split(ORDER_ITEM_DELIMITER);
    }

    public static String[] splitByMenuAndCount(String string) {
        return string.split(MENU_AND_COUNT_DELIMITER);
    }
}
