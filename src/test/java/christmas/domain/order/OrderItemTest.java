package christmas.domain.order;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.domain.menu.Menu;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OrderItemTest {
    @DisplayName("메뉴의 가격과 수량을 곱한 값을 정상적으로 반환하는가")
    @Test
    void getTotalPrice() {
        OrderItem orderItem = OrderItem.of(Menu.CHAMPAGNE, 3);
        assertThat(orderItem.getTotalPrice()).isEqualTo(75_000);
    }
}
