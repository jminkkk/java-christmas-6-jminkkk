package christmas.domain.order;

import christmas.domain.event.DecemberEvent;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Order {
    private final int expectedVisitDate;
    private final List<OrderItem> orderItems;
    private final int beforeDiscountPrice;
    private int afterDiscountPrice;
    private Map<DecemberEvent, Integer> discountHistory;

    public Order(int visitDate, List<OrderItem> items) {
        this.expectedVisitDate = visitDate;
        this.orderItems = items;
        beforeDiscountPrice = calculateBeforeDiscountPrice();
        this.discountHistory = new HashMap<>();
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

    public int getBeforeDiscountPrice() {
        return beforeDiscountPrice;
    }
    public void addEventHistory(DecemberEvent event, int discountAmount) {
        discountHistory.put(event, discountAmount);
    }
}
