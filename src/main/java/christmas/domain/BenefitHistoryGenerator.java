package christmas.domain;

import christmas.domain.benefit.Badge;
import christmas.domain.benefit.Benefit;
import christmas.domain.benefit.BenefitHistory;
import christmas.domain.benefit.PresentItem;
import christmas.domain.event.ChristmasDdayEvent;
import christmas.domain.event.Event;
import christmas.domain.event.PresentEvent;
import christmas.domain.event.SpecialEvent;
import christmas.domain.event.WeekdayEvent;
import christmas.domain.event.WeekendEvent;
import christmas.domain.menu.Menu;
import christmas.domain.order.Order;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class BenefitGenerator {
    private static final int MINIMUM_EVENT_APPLY_PRICE = 10_000;
    private static final List<Event> AVAILABLE_EVENTS =
            List.of(new ChristmasDdayEvent(),
                    new SpecialEvent(),
                    new PresentEvent(),
                    new WeekendEvent(),
                    new WeekdayEvent());

    public BenefitHistory generateBenefitHistory(Order order) {
        if (order.getTotalPrice() < MINIMUM_EVENT_APPLY_PRICE) {
            return new BenefitHistory(new HashMap<>(), new ArrayList<>());
        }

        Map<Event, Benefit> appliedEventAndBenefits = checkApplyEvents(order);
        List<PresentItem> presents = checkGiftPresents(appliedEventAndBenefits);

        return new BenefitHistory(appliedEventAndBenefits, presents);
    }

    private Map<Event, Benefit> checkApplyEvents(Order order) {
        Map<Event, Benefit> eventHistory = new HashMap<>();

        for (Event event : AVAILABLE_EVENTS) {
            if (event.isConditioned(order)) {
                eventHistory.put(event, event.applyBenefit(order));
            }
        }

        return eventHistory;
    }

    public List<PresentItem> checkGiftPresents(Map<Event, Benefit> applyEvent) {
        List<PresentItem> presents = new ArrayList<>();

        if (applyEvent.containsKey(PresentEvent.class)) {
            presents.add(new PresentItem(Menu.CHAMPAGNE, 1));
        }

        return presents;
    }

    public Optional<Badge> giftBadge(int totalBenefitAmount) {
        Badge badge = Badge.of(totalBenefitAmount);
        return Optional.ofNullable(badge);
    }
}