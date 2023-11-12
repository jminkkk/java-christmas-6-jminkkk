package christmas;

import christmas.event.DecemberEvent;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private final int expectedVisitDate;
    private final List<OrderItem> orderItems;
    private final int beforeDiscountPrice;
    private int afterDiscountPrice;
    private List<DecemberEvent> discountHistory;

    public Order(int visitDate, List<OrderItem> items) {
        this.expectedVisitDate = visitDate;
        this.orderItems = items;
        beforeDiscountPrice = calculateBeforeDiscountPrice();
        this.discountHistory = new ArrayList<>();
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

    public void discount(int discountAmount) {
        afterDiscountPrice -= discountAmount;
    }

    public void addEventHistory(DecemberEvent event) {
        discountHistory.add(event);
    }
}
