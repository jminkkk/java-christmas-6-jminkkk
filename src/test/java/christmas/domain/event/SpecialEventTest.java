package christmas.domain.event;

import static christmas.domain.menu.Menu.BARBECUE_RIBS;
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

class SpecialEventTest {
    @DisplayName("특별 이벤트에 해당하는 날짜일 경우 적용되는지 여부와 혜택을 정상적으로 반환하는가")
    @Test
    void apply() {
        int expectedVisitDate = 3;
        Order order = new Order(expectedVisitDate, List.of(
                new OrderItem(BARBECUE_RIBS, 3),
                new OrderItem(ZERO_COKE, 1)));

        Benefit benefit = Benefit.of(BenefitType.DISCOUNT, 1_000);
        assertAll(
                () -> assertThat(new SpecialEvent().isConditioned(order)).isTrue(),
                () -> assertThat(new SpecialEvent().applyBenefit(order)).isEqualTo(benefit)
        );
    }

    @DisplayName("특별 이벤트에 해당하지 않는 날짜일 경우 적용되지 않는다를 반환하는가")
    @Test
    void notApply() {
        int expectedVisitDate = 11;
        Order order = new Order(expectedVisitDate, List.of(
                new OrderItem(TAPAS, 1),
                new OrderItem(ZERO_COKE, 1)));

        assertThat(new SpecialEvent().isConditioned(order)).isFalse();
    }
}
