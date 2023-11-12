package christmas.event;

import christmas.domain.order.Order;

public class ChristmasDdayEvent implements DateEvent {
    private final int INITIAL_DISCOUNT_AMOUNT = 1_000;
    private final int DISCOUNT_INTEREST = 100;
    private final int endedDate = 25;

    @Override
    public boolean isConditioned(int expectedVisitDate) {
        return expectedVisitDate <= endedDate;
    }

    @Override
    public void apply(Order order) {
        int discountPeriod = order.getExpectedVisitDate() - startedDate;
        int discountAmount = INITIAL_DISCOUNT_AMOUNT + discountPeriod * DISCOUNT_INTEREST;

        order.addEventHistory(this, discountAmount);
    }
}
