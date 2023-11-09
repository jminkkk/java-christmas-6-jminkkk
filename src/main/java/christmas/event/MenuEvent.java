package christmas.event;

import christmas.domain.menu.Menu;

public interface MenuEvent {
    boolean isConditioned(Menu menu);
}
