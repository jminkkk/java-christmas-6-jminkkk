package christmas.exception;

public enum Exception {
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

