package christmas.domain.order;


import static christmas.exception.Exception.INVALID_DATE;

import christmas.domain.event.DecemberEvent;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Order {
    private static final int MIN_VISIT_DATE = 1;
    private static final int MAX_VISIT_DATE = 31;
    private final int expectedVisitDate;
    private final List<OrderItem> orderItems;
    private final int beforeDiscountPrice;
    private int afterDiscountPrice;
    private Map<DecemberEvent, Integer> discountHistory;

    public Order(int visitDate, List<OrderItem> items) {
        validate(visitDate);
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

    public static void validate(int visitDate) {
        if (visitDate < MIN_VISIT_DATE || visitDate > MAX_VISIT_DATE) {
            throw new IllegalArgumentException(INVALID_DATE.getMessage());
        }
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
