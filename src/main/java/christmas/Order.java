package christmas;

import java.util.List;

public class Order {
    private final int expectedVisitDate;
    private final List<OrderItem> items;
    public Order(int visitDate, List<OrderItem> items) {
        this.expectedVisitDate = visitDate;
        this.items = items;
    }

    public int getTotalPrice() {
        return items.stream()
            .mapToInt(OrderItem::getTotalPrice)
            .sum();
    }
}
