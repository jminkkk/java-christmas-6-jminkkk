package christmas.global;

public enum Exception {
    INVALID_DATE("유효하지 않은 날짜입니다."),
    INVALID_ORDER("유효하지 않은 주문입니다."),
    ORDER_ONLY_UNDER_MAX("한 주문에 20개 이상의 메뉴를 주문할 수 없습니다."),
    CAN_NOT_ORDER_ONLY_DRINK("음료만 주문은 불가능합니다."),
    ;
    private final String PREFIX = "[ERROR] ";
    private final String SUFFIX = " 다시 입력해 주세요.";
    private final String message;
    Exception(String message) {
        this.message = message;
    }

    public String getMessage() {
        return PREFIX + message + SUFFIX;
    }
}

