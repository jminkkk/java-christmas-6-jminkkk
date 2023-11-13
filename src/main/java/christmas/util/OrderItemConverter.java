package christmas.util;

import static christmas.exception.Exception.INVALID_DATE;
import static christmas.exception.Exception.INVALID_ORDER;
import static christmas.util.StringParser.splitByMenuAndCount;
import static christmas.util.StringParser.splitByOrderItem;

import christmas.domain.menu.Menu;
import christmas.domain.order.OrderItem;
import java.util.Arrays;
import java.util.List;

public class OrderItemConverter {
    public static List<OrderItem> convert(String input) {
        String[] orderItems = splitByOrderItem(input);

        return Arrays.stream(orderItems)
                .map(OrderItemConverter::convertToOrderItem)
                .toList();
    }

    private static OrderItem convertToOrderItem(String menuAndCount) {
        String[] itemAndCount = splitByMenuAndCount(menuAndCount);

        Menu item = getMenu(itemAndCount[0]);
        int count = getCount(itemAndCount[1]);

        return OrderItem.of(item, count);
    }

    private static Menu getMenu(String menu) {
        try {
            return Menu.of(menu);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(INVALID_ORDER.getMessage());
        }
    }

    private static int getCount(String count) {
        try {
            return Integer.parseInt(count);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_DATE.getMessage());
        }
    }
}
