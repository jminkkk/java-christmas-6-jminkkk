package christmas.domain.event;

import christmas.domain.benefit.Benefit;
import christmas.domain.benefit.BenefitType;
import christmas.domain.order.Order;
import christmas.domain.order.OrderItem;
import christmas.domain.menu.MenuCategory;
import java.util.List;

public class WeekendEvent implements DateEvent, MenuEvent {
    private final String NAME = "주말 할인";
    private final int DISCOUNT_AMOUNT = 2_023;

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public Benefit applyBenefit(Order order) {
        int mainMenuCount = order.getCategoryCount(MenuCategory.MAIN_COURSE);
        return Benefit.of(BenefitType.DISCOUNT, mainMenuCount * DISCOUNT_AMOUNT);
    }

    @Override
    public boolean isConditioned(Order order) {
        return isConditioned(order.getExpectedVisitDate())
                && isConditioned(order.getOrderItems());
    }

    @Override
    public boolean isConditioned(int expectedVisitDate) {
        return EventDate.WEEKEND_EVENT_DATE.contains(expectedVisitDate);
    }

    @Override
    public boolean isConditioned(List<OrderItem> orderItems) {
        return orderItems.stream()
                .map(OrderItem::getMenu)
                .anyMatch(menu -> menu.isSameCategory(MenuCategory.MAIN_COURSE));
    }
}
