package christmas;

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

public class BenefitHistoryGenerator {
    private static final int MINIMUM_EVENT_APPLICATION_PRICE = 10_000;
    private static final List<Event> AVAILABLE_EVENTS =
            List.of(new ChristmasDdayEvent(),
                    new SpecialEvent(),
                    new PresentEvent(),
                    new WeekendEvent(),
                    new WeekdayEvent());

    public BenefitHistory generateBenefitHistory(Order order) {
        if (order.getTotalPrice() < MINIMUM_EVENT_APPLICATION_PRICE) {
            return new BenefitHistory(new HashMap<>(), new ArrayList<>());
        }

        return applyEvents(order);
    }

    private BenefitHistory applyEvents(Order order) {
        Map<Event, Benefit> eventHistory = new HashMap<>();
        List<PresentItem> presents = new ArrayList<>();

        for (Event event : AVAILABLE_EVENTS) {
            if (event.isConditioned(order)) {
                eventHistory.put(event, event.applyBenefit(order));
                giftPresents(event, presents);
            }
        }

        return BenefitHistory.of(eventHistory, presents);
    }

    public List<PresentItem> giftPresents(Event event, List<PresentItem> presents) {
        if (event instanceof PresentEvent) {
            presents.add(PresentItem.of(Menu.CHAMPAGNE, 1));
        }

        return presents;
    }
}
