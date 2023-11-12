package christmas.domain.event;

public interface TotalPriceEvent extends DecemberEvent {
    boolean isConditioned(int totalPrice);
}
