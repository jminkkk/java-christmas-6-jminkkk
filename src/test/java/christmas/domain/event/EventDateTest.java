package christmas.domain.event;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class EventDateTest {

    @DisplayName("이벤트 날짜에 해당하는지 여부를 정상적으로 반환하는가")
    @ParameterizedTest
    @CsvSource({"STAR_EVENT_DATE, 10",
            "WEEKDAY_EVENT_DATE, 4",
            "WEEKEND_EVENT_DATE, 9"})
    void contains(EventDate eventDate, int expectedVisitDate) {
        assertThat(eventDate.contains(expectedVisitDate)).isTrue();
    }
}
