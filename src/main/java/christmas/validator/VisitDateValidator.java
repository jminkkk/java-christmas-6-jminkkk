package christmas.validator;

import static christmas.exception.Exception.INVALID_DATE;

public class VisitDateValidator {
    private static final int MIN_VISIT_DATE = 1;
    private static final int MAX_VISIT_DATE = 31;
    public static void validate(int visitDate) {
        if (visitDate < MIN_VISIT_DATE || visitDate > MAX_VISIT_DATE) {
            throw new IllegalArgumentException(INVALID_DATE.getMessage());
        }
    }
}
