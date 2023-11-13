package christmas.domain.menu;

import static christmas.domain.menu.Menu.T_BONE_STEAK;
import static christmas.domain.menu.MenuCategory.DRINK;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class MenuTest {

    @ParameterizedTest(name = "이름에 해당하는 메뉴를 정상적으로 반환하는가")
    @CsvSource({"양송이수프, BUTTON_MUSHROOM_SOUP",
            "타파스, TAPAS",
            "시저샐러드, CAESAR_SALAD",
            "제로콜라, ZERO_COKE"})
    void of(String input, Menu menu) {
        Menu expected = Menu.of(input);
        assertThat(expected).isEqualTo(menu);
    }

    @DisplayName("메뉴판에 없는 메뉴를 찾을 경우 예외")
    @Test
    void ofException() {
        assertThatThrownBy(() -> Menu.of("현미밥"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
    }

    @ParameterizedTest(name = "같은 카테고리인 경우 정상적으로 참을 반환하는가")
    @CsvSource({"TAPAS, APPETIZER",
            "T_BONE_STEAK, MAIN_COURSE",
            "CHOCOLATE_CAKE, DESSERT",
            "RED_WINE, DRINK"})
    void isSameCategory(Menu menu, MenuCategory category) {
        assertThat(menu.isSameCategory(category)).isTrue();
    }

    @Test
    @DisplayName("다른 카테고리인 경우 거짓을 반환하는가")
    void isSameCategoryException() {
        assertThat(T_BONE_STEAK.isSameCategory(DRINK)).isFalse();
    }
}
