package christmas.domain.benefit;

import christmas.domain.menu.Menu;

public class PresentItem {
    private final Menu menu;
    private final int quantity;

    public PresentItem(Menu menu, int quantity) {
        this.menu = menu;
        this.quantity = quantity;
    }

    public Menu getMenu() {
        return menu;
    }

    public int getPresentAmount() {
        return menu.getPrice() * quantity;
    }

    @Override
    public String toString() {
        return menu.getName() + " " + quantity + "개";
    }

    public static PresentItem of(Menu menu, int quantity) {
        return new PresentItem(menu, quantity);
    }
}
