package christmas.domain.order;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.domain.menu.Menu;
import christmas.domain.menu.MenuCategory;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class OrderTest {
    @DisplayName("주문의 총 금액의 합을 정상적으로 반환하는가")
    @Test
    void getTotalPrice() {
        Order order = Order.of(25, List.of(
                OrderItem.of(Menu.BUTTON_MUSHROOM_SOUP, 1),
                OrderItem.of(Menu.TAPAS, 1),
                OrderItem.of(Menu.CAESAR_SALAD, 1)
        ));
        int expected = Menu.BUTTON_MUSHROOM_SOUP.getPrice() + Menu.TAPAS.getPrice() + Menu.CAESAR_SALAD.getPrice();

        assertThat(order.getTotalPrice()).isEqualTo(expected);
    }

    @DisplayName("주문 목록 중 특정 카테고리에 해당하는 메뉴의 수량을 정상적으로 반환하는가")
    @ParameterizedTest
    @CsvSource({"APPETIZER, 2", "MAIN_COURSE, 1", "DESSERT, 0", "DRINK, 0"})
    void getCategoryCount(MenuCategory category, int expected) {
        Order order = Order.of(25, List.of(
                OrderItem.of(Menu.T_BONE_STEAK, 1),
                OrderItem.of(Menu.TAPAS, 1),
                OrderItem.of(Menu.CAESAR_SALAD, 1)
        ));

        assertThat(order.getCategoryCount(category)).isEqualTo(expected);
    }
}
