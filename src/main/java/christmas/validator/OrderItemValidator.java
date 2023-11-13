package christmas.validator;

import static christmas.exception.Exception.CAN_NOT_ORDER_ONLY_DRINK;
import static christmas.exception.Exception.INVALID_ORDER;
import static christmas.exception.Exception.ORDER_ONLY_UNDER_MAX;

import christmas.domain.menu.MenuCategory;
import christmas.domain.order.OrderItem;
import java.util.List;

public class OrderItemValidator {
    private static final int MIN_MENU_COUNT = 1;
    private static final int MAX_MENU_COUNT = 20;

    public static void validate(List<OrderItem> orderItems) {
        validateOnlyDrink(orderItems);
        validateMenuDuplication(orderItems);

        int totalMenuCount = getTotalMenuCount(orderItems);
        isUnderThanMin(totalMenuCount);
        isOverThanMax(totalMenuCount);
    }

    private static void validateOnlyDrink(List<OrderItem> orderItems) {
        if (orderItems.size() == getDrinkCount(orderItems)) {
            throw new IllegalArgumentException(CAN_NOT_ORDER_ONLY_DRINK.getMessage());
        }
    }

    private static int getDrinkCount(List<OrderItem> orderItems) {
        return (int) orderItems.stream()
                .map(OrderItem::getMenu)
                .filter(menu -> menu.isSameCategory(MenuCategory.DRINK))
                .count();
    }

    private static void validateMenuDuplication(List<OrderItem> orderItems) {
        if (orderItems.size() != getDistinctedSize(orderItems)) {
            throw new IllegalArgumentException(INVALID_ORDER.getMessage());
        }
    }

    private static int getDistinctedSize(List<OrderItem> orderItems) {
        return (int) orderItems.stream()
                .map(OrderItem::getMenu)
                .distinct()
                .count();
    }

    private static int getTotalMenuCount(List<OrderItem> orderItems) {
        return orderItems.stream()
                .mapToInt(OrderItem::getQuantity)
                .sum();
    }

    private static void isUnderThanMin(int totalMenuCount) {
        if (totalMenuCount < MIN_MENU_COUNT) {
            throw new IllegalArgumentException(INVALID_ORDER.getMessage());
        }
    }

    private static void isOverThanMax(int totalMenuCount) {
        if (totalMenuCount > MAX_MENU_COUNT) {
            throw new IllegalArgumentException(ORDER_ONLY_UNDER_MAX.getMessage());
        }
    }
}
