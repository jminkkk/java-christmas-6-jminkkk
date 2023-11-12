package christmas.util;

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

    private static OrderItem convertToOrderItem(String source) {
        String[] itemAndCount = splitByMenuAndCount(source);

        Menu item = Menu.valueOf(itemAndCount[0]);
        int count = Integer.parseInt(itemAndCount[1]);

        return new OrderItem(item, count);
    }
}
