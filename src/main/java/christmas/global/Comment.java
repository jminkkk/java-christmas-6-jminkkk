package christmas.global;

public enum Comment {
    WELCOME_COMMENT("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다."),
    VISIT_DATE_COMMENT("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)."),
    INPUT_ORDER_MENU_COMMENT("주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)"),
    EVENT_BENEFITS_COMMENT("12월 26일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!"),

    ORDER_MENU_COMMENT("<주문 메뉴>"),
    BEFORE_TOTAL_AMOUNT_COMMENT("<할인 전 총주문 금액>"),
    PRESENT_MENU_COMMENT("<증정 메뉴>"),
    BENEFIT_HISTORY_COMMENT("<혜택 내역>"),
    TOTAL_BENEFIT_AMOUNT_COMMENT("<총혜택 금액>"),
    TOTAL_PAYMENT_AMOUNT_COMMENT("<할인 후 예상 결제 금액>"),
    DECEMBER_EVENT_BADGE_COMMENT("<12월 이벤트 배지>"),
    ;

    private final String message;

    Comment(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}