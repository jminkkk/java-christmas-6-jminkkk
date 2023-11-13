package christmas.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import christmas.domain.menu.Menu;
import christmas.domain.order.OrderItem;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OrderItemValidatorTest {
    @DisplayName("주문 메뉴에 음료만 있는 경우 예외가 발생한다.")
    @Test()
    void validateOnlyDrink() {
        List<OrderItem> orderItems = List.of(
                OrderItem.of(Menu.ZERO_COKE, 1),
                OrderItem.of(Menu.RED_WINE, 1));

        assertThatThrownBy(() -> OrderItemValidator.validate(orderItems))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 음료만 주문은 불가능합니다. 다시 입력해 주세요.");
    }

    @DisplayName("주문 메뉴 목록에 중복된 메뉴가 있을 경우 예외가 발생한다.")
    @Test()
    void validateMenuDuplication() {
        List<OrderItem> orderItems = List.of(
                OrderItem.of(Menu.ZERO_COKE, 1),
                OrderItem.of(Menu.TAPAS, 1),
                OrderItem.of(Menu.TAPAS, 1));

        assertThatThrownBy(() -> OrderItemValidator.validate(orderItems))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
    }

    @DisplayName("주문 메뉴 목록이 최소 주문 수량 이하일 경우 예외가 발생한다.")
    @Test()
    void isUnderThanMin() {
        List<OrderItem> orderItems = List.of(
                OrderItem.of(Menu.TAPAS, 0));

        assertThatThrownBy(() -> OrderItemValidator.validate(orderItems))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
    }

    @DisplayName("주문 메뉴 목록의 총 수량이 최대 주문 가능 수량을 넘을 경우 예외가 발생한다.")
    @Test()
    void isOverThanMax() {
        List<OrderItem> orderItems = List.of(
                OrderItem.of(Menu.ZERO_COKE, 30),
                OrderItem.of(Menu.TAPAS, 3));

        assertThatThrownBy(() -> OrderItemValidator.validate(orderItems))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 한 주문에 20개 이상의 메뉴를 주문할 수 없습니다. 다시 입력해 주세요.");
    }
}
