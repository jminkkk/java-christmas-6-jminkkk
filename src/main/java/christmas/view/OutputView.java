package christmas.view;

import christmas.domain.order.Order;

public class OutputView {
    private static final String WELCOME_COMMENT = "안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.";
    private static final String VISIT_DATE_COMMENT = "12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!).";
    private static final String ORDER_MENU_COMMENT = "주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)";
    private static final String EVENT_BENEFITS_COMMENT = "12월 26일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!";
    private static final String CRLF = "";
    public static void printWelcome() {
        println(WELCOME_COMMENT);
    }

    public static void printVisitDate() {
        println(VISIT_DATE_COMMENT);
    }

    public static void printOrderMenu() {
        println(ORDER_MENU_COMMENT);
    }

    public static void printEventBenefits(Order order) {
        println(EVENT_BENEFITS_COMMENT);
        println();

        // 주문 내역
        // 할인 전 총주문 금액
        // 증정 메뉴
        // 혜택 내역
        // 총혜택 금액
        // 할인 후 예상 결제 금액
        // 12월 이벤트 배지
    }

    public static void println() {
        println(CRLF);
    }

    public static void println(String message) {
        System.out.println(message);
    }
}