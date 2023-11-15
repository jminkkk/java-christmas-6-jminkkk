package christmas.domain.order;

import christmas.domain.menu.MenuCategory;
import java.util.List;

public class Order {
    private final int expectedVisitDate;
    private final List<OrderItem> orderItems;

    public Order(int visitDate, List<OrderItem> items) {
        this.expectedVisitDate = visitDate;
        this.orderItems = items;
    }

    public int getExpectedVisitDate() {
        return expectedVisitDate;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public int getTotalPrice() {
        return orderItems.stream()
                .mapToInt(OrderItem::getAmountByQuantity)
                .sum();
    }

    public int getCategoryCount(MenuCategory category) {
        return orderItems.stream()
                .filter(orderItem -> orderItem.getMenu().isSameCategory(category))
                .mapToInt(OrderItem::getQuantity)
                .sum();
    }

    public static Order of(int visitDate, List<OrderItem> items) {
        return new Order(visitDate, items);
    }
}
