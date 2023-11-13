package christmas.domain.event;

import christmas.domain.order.Order;
import christmas.domain.order.OrderItem;
import christmas.domain.menu.MenuCategory;
import java.util.List;

public class WeekdayEvent implements DateEvent, MenuEvent {
    private final int DISCOUNT_AMOUNT = 2_023;

    @Override
    public int getDiscountAmount(Order order) {
        int desertCount = getDesertCount(order.getOrderItems());
        return desertCount * DISCOUNT_AMOUNT;
    }

    @Override
    public boolean isConditioned(Order order) {
        return isConditioned(order.getExpectedVisitDate())
                && isConditioned(order.getOrderItems());
    }

    @Override
    public boolean isConditioned(int expectedVisitDate) {
        return EventDate.WEEKDAY_EVENT_DATE.isConditioned(expectedVisitDate);
    }

    @Override
    public boolean isConditioned(List<OrderItem> orderItems) {
        return orderItems.stream()
                .map(OrderItem::getMenu)
                .anyMatch(menu -> menu.isSameCategory(MenuCategory.DESSERT));
    }

    public int getDesertCount(List<OrderItem> orderItems) {
        return (int) orderItems.stream()
                .map(OrderItem::getMenu)
                .filter(menu -> menu.isSameCategory(MenuCategory.DESSERT))
                .count();
    }
}