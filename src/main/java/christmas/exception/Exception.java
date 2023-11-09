package christmas.exception;

public enum Exception {
    INVALID_ORDER("유효하지 않은 주문입니다. 다시 입력해 주세요."),
    ONLY_NUMBER_ALLOWED("숫자만 입력 가능합니다."),
    ;
    private final String PREFIX = "[ERROR] ";
    private final String message;
    Exception(String message) {
        this.message = message;
    }

    public String getMessage() {
        return PREFIX + message;
    }
}

