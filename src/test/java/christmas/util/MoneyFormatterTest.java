package christmas.util;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class MoneyFormatterTest {
    @Test
    void format() {
        assertThat(MoneyFormatter.format(100015425)).isEqualTo("100,015,425원");
    }

    @Test
    void minusformat() {
        assertThat(MoneyFormatter.minusFormat(1000)).isEqualTo("-1,000원");
    }
}
