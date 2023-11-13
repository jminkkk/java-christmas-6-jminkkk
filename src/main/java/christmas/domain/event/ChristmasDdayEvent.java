package christmas.domain.event;

import christmas.domain.order.Order;

public class ChristmasDdayEvent implements DateEvent {
    private final int INITIAL_DISCOUNT_AMOUNT = 1_000;
    private final int DISCOUNT_INTEREST = 100;
    private final int START_DATE = 1;
    private final int ENDED_DATE = 25;

    @Override
    public int getDiscountAmount(Order order) {
        int discountPeriod = order.getExpectedVisitDate() - START_DATE;
        return INITIAL_DISCOUNT_AMOUNT + discountPeriod * DISCOUNT_INTEREST;
    }

    @Override
    public boolean isConditioned(Order order) {
        return isConditioned(order.getExpectedVisitDate());
    }

    @Override
    public boolean isConditioned(int expectedVisitDate) {
        return expectedVisitDate <= ENDED_DATE;
    }
}
