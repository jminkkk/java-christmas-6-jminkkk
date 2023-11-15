package christmas.domain;

import christmas.domain.menu.Menu;

/**
 * Item은 추상 클래스로, 메뉴와 수량에 기반한 항목을 나타냅니다.
 */
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

