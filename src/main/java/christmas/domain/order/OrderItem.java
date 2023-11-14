package christmas.domain.order;

import christmas.domain.menu.Menu;
import java.util.Objects;

public class OrderItem {
    private final Menu menu;
    private final int quantity;

    public OrderItem(Menu menu, int quantity) {
        this.menu = menu;
        this.quantity = quantity;
    }

    public Menu getMenu() {
        return menu;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getTotalPrice() {
        return menu.getPrice() * quantity;
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

    @Override
    public String toString() {
        return menu.getName() + " " + quantity + "개";
    }
}
