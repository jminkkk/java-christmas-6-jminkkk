package christmas.domain.benefit;

import christmas.domain.Item;
import christmas.domain.menu.Menu;

/**
 * PresentItem은 Item의 구현체로, 증정품 항목을 나타냅니다.
 */
public class PresentItem extends Item {
    protected PresentItem(Menu menu, int quantity) {
        super(menu, quantity);
    }

    public static PresentItem of(Menu menu, int quantity) {
        return new PresentItem(menu, quantity);
    }
}
