package christmas.domain.event;

import christmas.domain.order.Order;

public interface Event {
    int getDiscountAmount(Order order);
    boolean isConditioned(Order order);
}
