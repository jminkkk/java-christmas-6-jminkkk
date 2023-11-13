package christmas;

import static christmas.exception.Exception.INVALID_ORDER;
import static christmas.exception.Exception.ORDER_ONLY_UNDER_MAX;

import christmas.domain.order.OrderItem;
import java.util.List;

public class OrderValidator {
    private static final int MIN_MENU_COUNT = 1;
    private static final int MAX_MENU_COUNT = 20;

    public void validate(List<OrderItem> orderItems) {
        validateMenuDuplication(orderItems);
        isUnderThanMin(getTotalMenuCount(orderItems));
        isOverThanMax(getTotalMenuCount(orderItems));
    }

    private void isUnderThanMin(int totalMenuCount) {
        if (totalMenuCount < MIN_MENU_COUNT) {
            throw new IllegalArgumentException(INVALID_ORDER.getMessage());
        }
    }

    private void isOverThanMax(int totalMenuCount) {
        if (totalMenuCount > MAX_MENU_COUNT) {
            throw new IllegalArgumentException(ORDER_ONLY_UNDER_MAX.getMessage());
        }
    }

    private int getTotalMenuCount(List<OrderItem> orderItems) {
        return orderItems.stream()
                .mapToInt(OrderItem::getQuantity)
                .sum();
    }

    private void validateMenuDuplication(List<OrderItem> orderItems) {
        if (orderItems.size() != getDistinctedSize(orderItems)) {
            throw new IllegalArgumentException(INVALID_ORDER.getMessage());
        }
    }

    private int getDistinctedSize(List<OrderItem> orderItems) {
        return (int) orderItems.stream()
                .map(OrderItem::getMenu)
                .distinct()
                .count();
    }
}
