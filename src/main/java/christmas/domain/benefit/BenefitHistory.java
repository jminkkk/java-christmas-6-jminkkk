package christmas.domain.benefit;

import static christmas.domain.benefit.BenefitType.DISCOUNT;

import christmas.domain.event.Event;
import java.util.List;
import java.util.Map;

public class BenefitHistory {
    private final Map<Event, Benefit> eventAndBenefitAmounts;
    private final List<PresentItem> presentItems;

    public BenefitHistory(Map<Event, Benefit> eventAndBenefitAmounts, List<PresentItem> presentItems) {
        this.eventAndBenefitAmounts = eventAndBenefitAmounts;
        this.presentItems = presentItems;
    }

    public List<PresentItem> getPresentItems() {
        return presentItems;
    }

    public Map<Event, Benefit> getEventAndBenefitAmounts() {
        return eventAndBenefitAmounts;
    }

    public int getTotalBenefitAmount() {
        return eventAndBenefitAmounts.values().stream()
                .mapToInt(Benefit::getBenefitAmount)
                .sum();
    }

    public int getTotalDiscountAmount() {
        return eventAndBenefitAmounts.values().stream()
                .filter(benefit -> benefit.getBenefitType() == DISCOUNT)
                .mapToInt(Benefit::getBenefitAmount)
                .sum();
    }

    public static BenefitHistory of(Map<Event, Benefit> eventAndBenefitAmounts, List<PresentItem> presentItems) {
        return new BenefitHistory(eventAndBenefitAmounts, presentItems);
    }
}
