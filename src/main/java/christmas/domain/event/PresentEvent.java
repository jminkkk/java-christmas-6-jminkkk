package christmas.domain.event;

import christmas.domain.benefit.Benefit;
import christmas.domain.benefit.BenefitType;
import christmas.domain.order.Order;

public class PresentEvent implements TotalPriceEvent {
    private final String NAME = "증정 이벤트";
    private final int MINIMUM_TOTAL_PRICE = 120_000;
    private final int BENEFIT_AMOUNT = 25_000;

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public Benefit applyBenefit(Order order) {
        return Benefit.of(BenefitType.PRESENT, BENEFIT_AMOUNT);
    }

    @Override
    public boolean isConditioned(Order order) {
        return isConditioned(order.getTotalPrice());
    }

    @Override
    public boolean isConditioned(int totalPrice) {
        return totalPrice > MINIMUM_TOTAL_PRICE;
    }
}
