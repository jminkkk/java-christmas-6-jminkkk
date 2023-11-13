package christmas.util;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class StringParserTest {
    @Test
    void splitByOrderItem() {
        assertThat(StringParser.splitByOrderItem("타파스-1,제로콜라-1")).containsExactly("타파스-1","제로콜라-1");
    }

    @Test
    void splitByMenuAndCount() {
        assertThat(StringParser.splitByMenuAndCount("타파스-1")).containsExactly("타파스","1");
    }
}
