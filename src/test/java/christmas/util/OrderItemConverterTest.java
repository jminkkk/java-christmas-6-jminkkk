package christmas.util;

import static christmas.domain.menu.Menu.TAPAS;
import static christmas.domain.menu.Menu.ZERO_COKE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import christmas.domain.order.OrderItem;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OrderItemConverterTest {

    @DisplayName("입력값을 정상적으로 OrderItem 목록으로 변환하는가")
    @Test
    void convert() {
        String input = "타파스-1,제로콜라-1";

        assertThat(OrderItemConverter.convert(input))
                .containsExactly(
                        OrderItem.of(TAPAS, 1),
                        OrderItem.of(ZERO_COKE, 1));
    }

    @DisplayName("지정된 구분자가 아닌 포함된 문자열을 입력할 경우 예외를 반환하는가")
    @Test
    void convertException() {
        String input = "타파스~1,제로콜라-1";

        assertThatThrownBy(() -> OrderItemConverter.convert(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
    }

    @DisplayName("메뉴판에 없는 메뉴를 입력할 경우 예외를 반환하는가")
    @Test
    void getMenuException() {
        String input = "흰쌀밥-1,제로콜라-1";

        assertThatThrownBy(() -> OrderItemConverter.convert(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
    }


    @DisplayName("메뉴의 주문 개수가 숫자가 아닐 경우 예외를 반환하는가")
    @Test
     void getCountException() {
        String input = "타파스-밥,제로콜라-1";

        assertThatThrownBy(() -> OrderItemConverter.convert(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
    }
}
