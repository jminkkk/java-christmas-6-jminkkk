package christmas.view;

import static christmas.global.Comment.NO_VALUE_COMMENT;

import christmas.domain.Badge;
import christmas.domain.benefit.Benefit;
import christmas.domain.event.Event;
import christmas.global.Comment;
import christmas.util.MoneyFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class OutputView {

    private static final String CRLF = "";

    public static void println(String message) {
        System.out.println(message);
    }

    public static void println() {
        println(CRLF);
    }

    public static void println(IllegalArgumentException exception) {
        println(exception.getMessage());
    }

    public static void println(Comment comment) {
        println(comment.getMessage());
    }

    public static void println(Map<Event, Benefit> eventAndDiscountAmounts) {
        if (eventAndDiscountAmounts.isEmpty()) {
            println(NO_VALUE_COMMENT);
            return;
        }

        List<Event> events = new ArrayList<>(eventAndDiscountAmounts.keySet());
        events.sort((event1, event2) -> (eventAndDiscountAmounts.get(event1)
                .compareTo(eventAndDiscountAmounts.get(event2))));

        for(Event event : events) {
            int benefitAmount = eventAndDiscountAmounts.get(event).getBenefitAmount();
            println(event.getName() + ": " + MoneyFormatter.minusFormat(benefitAmount));
        }
    }

    public static void println(List<?> items) {
        if (items.isEmpty()) {
            println(NO_VALUE_COMMENT);
            return;
        }

        items.forEach(item -> println(item.toString()));
    }

    public static void printMoney(int money) {
        println(MoneyFormatter.format(money));
    }

    public static void printMinusMoney(int money) {
        println(MoneyFormatter.minusFormat(money));
    }

    public static void println(Badge badge) {
        if (badge == null) {
            println(NO_VALUE_COMMENT);
            return;
        }

        println(badge.getName());
    }
}