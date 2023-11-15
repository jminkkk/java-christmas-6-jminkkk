package christmas.domain.order;

import christmas.domain.Item;
import christmas.domain.menu.Menu;
import java.util.Objects;

/**
 * PresentItem은 Item의 구현체로, 주문 항목을 나타냅니다.
 */
public class OrderItem extends Item {
    protected OrderItem(Menu menu, int quantity) {
        super(menu, quantity);
    }

    public static OrderItem of(Menu menu, int quantity) {
        return new OrderItem(menu, quantity);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        OrderItem orderItem = (OrderItem) o;
        return quantity == orderItem.quantity && menu == orderItem.menu;
    }

    @Override
    public int hashCode() {
        return Objects.hash(menu, quantity);
    }
}
