package christmas.domain.event;

import christmas.domain.benefit.Benefit;
import christmas.domain.benefit.BenefitType;
import christmas.domain.order.Order;
import christmas.domain.order.OrderItem;
import christmas.domain.menu.MenuCategory;
import java.util.List;

public class WeekdayEvent implements DateEvent, MenuEvent {
    private final String NAME = "평일 할인";
    private final int DISCOUNT_AMOUNT = 2_023;

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public Benefit applyBenefit(Order order) {
        int desertCount = order.getCategoryCount(MenuCategory.DESSERT);
        return Benefit.of(BenefitType.DISCOUNT, desertCount * DISCOUNT_AMOUNT);
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
}