package christmas.event;

import christmas.Order;

public class PresentEvent implements TotalPriceEvent {
    private final int discountAmount = 25_000;
    @Override
    public boolean isConditioned(int totalPrice) {
        return false;
    }

    @Override
    public void apply(Order order) {
        order.addEventHistory(this, discountAmount);
    }
}
