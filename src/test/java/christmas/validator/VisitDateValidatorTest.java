package christmas.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class VisitDateValidatorTest {

    @DisplayName("1~31일 사이가 아닌 방문 날짜를 입력하면 예외가 발생한다.")
    @ParameterizedTest()
    @CsvSource(value = {"0", "32"})
    void validate(int visitDate) {
        assertThatThrownBy(() -> VisitDateValidator.validate(visitDate))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");

    }
}
