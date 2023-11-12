package christmas.event;

import christmas.domain.order.Order;
import christmas.domain.order.OrderItem;
import christmas.domain.EventDate;
import christmas.domain.menu.MenuCategory;
import java.util.List;

public class WeekdayEvent implements DateEvent, MenuEvent {
    private final int DISCOUNT_AMOUNT = 2_023;

    @Override
    public boolean isConditioned(int expectedVisitDate) {
        return EventDate.WEEKDAY_EVENT_DATE.isConditioned(expectedVisitDate);
    }

    @Override
    public void apply(Order order) {
        int desertCount = getDesertCount(order.getOrderItems());
        int discountAmount = desertCount * DISCOUNT_AMOUNT;

        order.addEventHistory(this, discountAmount);
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