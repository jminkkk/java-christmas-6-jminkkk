package christmas.event;

import christmas.OrderItem;
import java.util.List;

public interface MenuEvent {
    boolean isConditioned(List<OrderItem> menu);
}
