package christmas.domain.order;

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

    private int calculateBeforeDiscountPrice() {
        return orderItems.stream()
                .mapToInt(OrderItem::getTotalPrice)
                .sum();
    }
}
