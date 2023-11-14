package christmas.domain.event;

import java.util.List;

public enum EventDate {
    STAR_EVENT_DATE(List.of(3, 10, 17, 24, 25, 31)), // 별
    WEEKDAY_EVENT_DATE(List.of(3, 4, 5, 6, 7, 10, 11, 12, 13, 14, 17, 18, 19, 20, 21, 24, 25, 26, 27, 28, 31)), // 주중
    WEEKEND_EVENT_DATE(List.of(1, 2, 8, 9, 15, 16, 22, 23, 29, 30)), // 주말
    ;
    private final List<Integer> conditionDates;

    EventDate(List<Integer> conditionDates) {
        this.conditionDates = conditionDates;
    }

    public boolean isConditioned(int expectedVisitDate) {
        return conditionDates.contains(expectedVisitDate);
    }
}
