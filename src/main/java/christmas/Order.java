package christmas;

import java.util.List;

public class Order {
    private final int expectedVisitDate;
    private final List<OrderItem> orderItems;
    private int beforeDiscountPrice;
    public Order(int visitDate, List<OrderItem> items) {
        this.expectedVisitDate = visitDate;
        this.orderItems = items;
        beforeDiscountPrice = calculateBeforeDiscountPrice();
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
        beforeDiscountPrice -= discountAmount;
    }
}
