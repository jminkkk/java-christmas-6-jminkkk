package christmas.util;

import static christmas.global.Comment.NO_VALUE_COMMENT;

import christmas.domain.benefit.Benefit;
import christmas.domain.event.Event;
import christmas.global.Comment;
import java.util.List;
import java.util.Map;

public class PrintFormatter {
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

        eventAndDiscountAmounts.forEach((event, benefits) -> {
            println(event.getName() + ": " + MoneyFormatter.minusFormat(benefits.getBenefitAmount()));
        });
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
}
