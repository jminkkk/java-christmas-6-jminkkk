package christmas.domain.order;

import christmas.domain.menu.Menu;

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
}
