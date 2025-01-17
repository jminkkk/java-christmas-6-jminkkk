package christmas.domain.event;

import static christmas.domain.menu.Menu.BARBECUE_RIBS;
import static christmas.domain.menu.Menu.CHOCOLATE_CAKE;
import static christmas.domain.menu.Menu.TAPAS;
import static christmas.domain.menu.Menu.ZERO_COKE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import christmas.domain.benefit.Benefit;
import christmas.domain.benefit.BenefitType;
import christmas.domain.order.Order;
import christmas.domain.order.OrderItem;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WeekdayEventTest {
    @DisplayName("평일 이벤트에 해당하는 날짜일 경우 적용되는지 여부와 혜택을 정상적으로 반환하는가")
    @Test
    void apply() {
        int expectedVisitDate = 3;
        int desertMenuCount = 3;
        Order order = new Order(expectedVisitDate, List.of(
                OrderItem.of(CHOCOLATE_CAKE, desertMenuCount),
                OrderItem.of(ZERO_COKE, 1)));

        Benefit benefit = Benefit.of(BenefitType.DISCOUNT, 2_023 * desertMenuCount);
        assertAll(
                () -> assertThat(new WeekdayEvent().isConditioned(order)).isTrue(),
                () -> assertThat(new WeekdayEvent().applyBenefit(order)).isEqualTo(benefit)
        );
    }

    @DisplayName("평일 이벤트에 해당하지 않는 날짜일 경우 적용되지 않는다를 반환하는가")
    @Test
    void notApplyByExpectedVisitDate() {
        int notAppliedDate = 1;
        Order order = new Order(notAppliedDate, List.of(
                OrderItem.of(CHOCOLATE_CAKE, 1),
                OrderItem.of(ZERO_COKE, 1)));

        assertThat(new WeekdayEvent().isConditioned(order)).isFalse();
    }

    @DisplayName("평일 이벤트에 해당하지만 디저트 메뉴가 없는 경우 적용되지 않는다를 반환하는가")
    @Test
    void notApplyByMenu() {
        int expectedVisitDate = 3;
        Order order = new Order(expectedVisitDate, List.of(
                OrderItem.of(TAPAS, 1),
                OrderItem.of(ZERO_COKE, 1)));

        assertThat(new WeekdayEvent().isConditioned(order)).isFalse();
    }
}
