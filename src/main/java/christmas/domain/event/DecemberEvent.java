package christmas.domain.event;

import christmas.domain.order.Order;

public interface DecemberEvent {
    int startedDate = 1;
    int getDiscountAmount(Order order);
}
