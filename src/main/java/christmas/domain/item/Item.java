package christmas.domain;

import christmas.domain.menu.Menu;

public abstract class Item {
    protected final Menu menu;
    protected final int quantity;

    protected Item(Menu menu, int quantity) {
        this.menu = menu;
        this.quantity = quantity;
    }

    public Menu getMenu() {
        return menu;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getAmountByQuantity() {
        return menu.getPrice() * quantity;
    }

    @Override
    public String toString() {
        return menu.getName() + " " + quantity + "개";
    }
}

