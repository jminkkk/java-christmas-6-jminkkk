package christmas;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class IntegrationTest extends NsTest {
    @DisplayName("적용된 이벤트가 하나도 없는 경우")
    @Test
    void exampleNoEventTest() {
        assertSimpleTest(() -> { // 8,000 + 55,000 + 15,000 + 3,0000
            run("26", "타파스-1,제로콜라-1");
            assertThat(output()).contains(
                    "12월 26일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!"
                    , "타파스 1개"
                    , "제로콜라 1개"
                    , "8,500원"
                    , "없음"
                    , "없음"
                    , "0원"
                    , "8,500원"
            );
        });
    }


    @DisplayName("기대하는 '12월 이벤트 플래너'의 예시 모습 테스트")
    @Test
    void exampleTest() {
        assertSimpleTest(() -> { // 8,000 + 55,000 + 15,000 + 3,0000
            run("3", "티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1");
            assertThat(output()).contains(
                    "12월 3일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!"
                    , "티본스테이크 1개"
                    , "바비큐립 1개"
                    , "초코케이크 2개"
                    , "제로콜라 1개"
                    , "142,000원"
                    , "샴페인 1개"
                    , "크리스마스 디데이 할인: -1,200원"
                    , "평일 할인: -4,046원"
                    , "특별 할인: -1,000원"
                    , "증정 이벤트: -25,000원"
                    , "-31,246원"
                    , "135,754원"
                    , "산타"
            );
        });
    }


    @DisplayName("정상 실행 시나리오1")
    @Test
    void test1() {
        assertSimpleTest(() -> { // 8,000 + 55,000 + 15,000 + 3,0000
            run("10", "시저샐러드-1,티본스테이크-1,초코케이크-1,제로콜라-1");
            assertThat(output()).contains(
                    "12월 10일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!",
                    "81,000원",
                    "크리스마스 디데이 할인: -1,900원",
                    "평일 할인: -2,023원",
                    "특별 할인: -1,000원",
                    "-4,923원",
                    "76,077원",
                    "없음"
            );
        });
    }

    @DisplayName("정상 실행 시나리오2")
    @Test
    void test2() {
        assertSimpleTest(() -> {
            run("25", "해산물파스타-1,크리스마스파스타-1,아이스크림-1,레드와인-1");
            assertThat(output()).contains(
                    "12월 25일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!",
                    "125,000원", // 125,000 -6,423
                    "크리스마스 디데이 할인: -3,400원",
                    "평일 할인: -2,023원",
                    "특별 할인: -1,000원",
                    "증정 이벤트: -25,000원",
                    "-31,423원",
                    "118,577원",
                    "산타"
            );
        });

    }

    @DisplayName("음료만 주문한 경우 재입력")
    @Test
    void test3() {
        assertSimpleTest(() -> {
            run("25", "제로콜라-1", "해산물파스타-1");
            assertThat(output()).contains(
                    "[ERROR] 음료만 주문은 불가능합니다. 다시 입력해 주세요.",
                    "주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)"
            );
        });
    }

    @DisplayName("주문한 메뉴 개수의 합이 20개를 초과한 경우 재입력")
    @Test
    void test4() {
        assertSimpleTest(() -> {
            run("25", "제로콜라-1,해산물파스타-23", "해산물파스타-1");
            assertThat(output()).contains(
                    "[ERROR] 한 주문에 20개 이상의 메뉴를 주문할 수 없습니다. 다시 입력해 주세요.",
                    "주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)"
            );
        });
    }

    @DisplayName("주문한 메뉴 개수의 합이 20개를 초과한 경우 재입력")
    @Test
    void test5() {
        assertSimpleTest(() -> {
            run("25", "아이스크림-1");
            assertThat(output()).contains(
                    "총주문 금액 10,000원 이상부터 이벤트가 적용됩니다."
            );
        });
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}

