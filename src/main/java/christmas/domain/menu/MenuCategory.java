package christmas.domain.menu;

public enum MenuCategory {
    APPETIZER("애피타이저"),
    MAIN_COURSE("메인코스"),
    DESSERT("디저트"),
    DRINK("음료");

    private final String name;

    MenuCategory(String name) {
        this.name = name;
    }
}
