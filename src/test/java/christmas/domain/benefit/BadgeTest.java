package christmas.domain.benefit;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class BadgeTest {
    @DisplayName("총 혜택 금액에 맞는 뱃지를 정상적으로 반환하는가")
    @ParameterizedTest
    @CsvSource({"6_000, STAR", "10_000, TREE", "25_000, SANTA", "30_000, SANTA"})
    void of(int totalBenefitAmount, Badge Badge) {
        assertThat(Badge.of(totalBenefitAmount)).isEqualTo(Badge);
    }
}
