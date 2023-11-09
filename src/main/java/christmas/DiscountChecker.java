package christmas;

import static christmas.domain.menu.MenuCategory.DRINK;

import christmas.domain.menu.Menu;
import java.util.List;

public class DiscountChecker {
    private final int MIN_ORDER_AMOUNT_FOR_DISCOUNT = 10_000;
    private final int MAX_ORDER_SIZE = 20;

    public boolean canDiscount(Order order) {
        return isOverDiscountPrice(order.getTotalPrice()) &&
                isNotOnlyDrink(order) &&
                isOverSize(order.getItems());
    }

    private boolean isOverDiscountPrice(int totalPrice) {
        return totalPrice >= MIN_ORDER_AMOUNT_FOR_DISCOUNT;
    }

    private boolean isNotOnlyDrink(Order order) {
        int drinkCount = (int) order.getItems().stream()
                .filter(this::isDrink)
                .count();
        int itemCount = order.getItems().size();

        return drinkCount == itemCount;
    }

    private boolean isDrink(OrderItem orderItem) {
        Menu menu = orderItem.getMenu();
        return menu.getCategory().equals(DRINK);
    }

    private boolean isOverSize(List<OrderItem> orderItems) {
        return orderItems.stream()
                .mapToInt(OrderItem::getQuantity)
                .sum() <= MAX_ORDER_SIZE;
    }
}