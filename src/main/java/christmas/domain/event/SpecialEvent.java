package christmas.domain.event;

import christmas.domain.benefit.Benefit;
import christmas.domain.benefit.BenefitType;
import christmas.domain.order.Order;

public class SpecialEvent implements DateEvent {
    private final String NAME = "특별 할인";
    private final int DISCOUNT_AMOUNT = 1_000;

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public Benefit applyBenefit(Order order) {
        return Benefit.of(BenefitType.DISCOUNT, DISCOUNT_AMOUNT);
    }

    @Override
    public boolean isConditioned(Order order) {
        return isConditioned(order.getExpectedVisitDate());
    }

    @Override
    public boolean isConditioned(int expectedVisitDate) {
        return EventDate.STAR_EVENT_DATE.contains(expectedVisitDate);
    }
}
