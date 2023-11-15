package christmas.domain.benefit;

import christmas.domain.Item;
import christmas.domain.menu.Menu;

public class PresentItem extends Item {
    protected PresentItem(Menu menu, int quantity) {
        super(menu, quantity);
    }

    public static PresentItem of(Menu menu, int quantity) {
        return new PresentItem(menu, quantity);
    }
}
