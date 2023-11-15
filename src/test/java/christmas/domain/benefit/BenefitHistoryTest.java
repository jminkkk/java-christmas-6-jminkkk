package christmas.domain.benefit;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import christmas.domain.event.ChristmasDdayEvent;
import christmas.domain.event.Event;
import christmas.domain.event.PresentEvent;
import christmas.domain.menu.Menu;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BenefitHistoryTest {

    @DisplayName("혜택 내역의 총 혜택 금액 및 총 할인 금액을 정상적으로 반환하는지")
    @Test
    void getTotalBenefitAmount() {
        Map<Event, Benefit> eventAndBenefitAmounts = Map.of(
                new ChristmasDdayEvent(), Benefit.of(BenefitType.DISCOUNT, 1_000),
                new PresentEvent(), Benefit.of(BenefitType.PRESENT, 25_000)
        );
        List<PresentItem> presentItems = List.of(PresentItem.of(Menu.CHAMPAGNE, 1));

        BenefitHistory benefitHistory = new BenefitHistory(eventAndBenefitAmounts, presentItems);

        assertAll(
                () -> assertThat(benefitHistory.getTotalBenefitAmount()).isEqualTo(26_000),
                () -> assertThat(benefitHistory.getTotalDiscountAmount()).isEqualTo(1_000)
        );
    }
}
