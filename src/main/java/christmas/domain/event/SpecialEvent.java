package christmas.domain.event;

import christmas.domain.order.Order;
import christmas.domain.EventDate;

public class SpecialEvent implements DateEvent {
    private final int DISCOUNT_AMOUNT = 1_000;

    @Override
    public boolean isConditioned(int expectedVisitDate) {
        return EventDate.STAR_EVENT_DATE.isConditioned(expectedVisitDate);
    }

    @Override
    public int getDiscountAmount(Order order) {
        return DISCOUNT_AMOUNT;
    }
}
