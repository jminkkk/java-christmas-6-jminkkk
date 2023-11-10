package christmas.event;

import christmas.Order;

public interface DecemberEvent {
    int startedDate = 1;
    void apply(Order order);
}
