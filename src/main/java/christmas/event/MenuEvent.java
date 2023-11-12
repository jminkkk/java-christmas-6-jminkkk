package christmas.event;

import christmas.domain.order.OrderItem;
import java.util.List;

public interface MenuEvent extends DecemberEvent {
    boolean isConditioned(List<OrderItem> menu);
}
