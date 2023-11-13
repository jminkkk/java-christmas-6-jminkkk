package christmas.domain.event;

public interface TotalPriceEvent extends Event {
    boolean isConditioned(int totalPrice);
}
