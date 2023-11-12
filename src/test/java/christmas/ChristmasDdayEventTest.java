package christmas;

import static christmas.domain.menu.Menu.TAPAS;
import static christmas.domain.menu.Menu.ZERO_COKE;
import static org.assertj.core.api.Assertions.assertThat;

import christmas.domain.order.Order;
import christmas.domain.order.OrderItem;
import christmas.domain.event.ChristmasDdayEvent;
import java.util.List;
import org.junit.jupiter.api.Test;

class ChristmasDdayEventTest {
    Order order = new Order(1, List.of(
            new OrderItem(TAPAS, 1),
            new OrderItem(ZERO_COKE, 1)));

    @Test
    void apply() {
        new ChristmasDdayEvent().apply(order);

        assertThat(order.getBeforeDiscountPrice()).isEqualTo(ZERO_COKE.getPrice() + TAPAS.getPrice() - 1000);
    }
}
