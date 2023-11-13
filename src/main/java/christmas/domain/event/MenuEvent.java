package christmas.domain.event;

import christmas.domain.order.OrderItem;
import java.util.List;

public interface MenuEvent extends Event {
    boolean isConditioned(List<OrderItem> menu);
}
