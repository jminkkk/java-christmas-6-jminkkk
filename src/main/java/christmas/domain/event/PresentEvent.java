package christmas.domain.event;

import christmas.domain.order.Order;

public class PresentEvent implements TotalPriceEvent {
    private final int MINIMUM_TOTAL_PRICE = 120_000;
    private final int DISCOUNT_AMOUNT = 25_000;
    @Override
    public boolean isConditioned(int totalPrice) {
        return totalPrice > MINIMUM_TOTAL_PRICE;
    }

    @Override
    public int getDiscountAmount(Order order) {
        return DISCOUNT_AMOUNT;
    }
}
