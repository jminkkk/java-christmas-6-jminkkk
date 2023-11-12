package christmas.event;

import christmas.domain.order.Order;

public interface DecemberEvent {
    int startedDate = 1;
    void apply(Order order);
}
