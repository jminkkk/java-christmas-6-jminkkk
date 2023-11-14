package christmas.view;

import static christmas.global.Comment.BEFORE_TOTAL_AMOUNT_COMMENT;
import static christmas.global.Comment.BENEFIT_HISTORY_COMMENT;
import static christmas.global.Comment.DECEMBER_EVENT_BADGE_COMMENT;
import static christmas.global.Comment.EVENT_BENEFITS_COMMENT;
import static christmas.global.Comment.INPUT_ORDER_MENU_COMMENT;
import static christmas.global.Comment.NO_VALUE_COMMENT;
import static christmas.global.Comment.ORDER_MENU_COMMENT;
import static christmas.global.Comment.PRESENT_MENU_COMMENT;
import static christmas.global.Comment.TOTAL_BENEFIT_AMOUNT_COMMENT;
import static christmas.global.Comment.TOTAL_PAYMENT_AMOUNT_COMMENT;
import static christmas.global.Comment.VISIT_DATE_COMMENT;
import static christmas.global.Comment.WELCOME_COMMENT;
import static christmas.global.Comment.DECEMBER;
import static christmas.util.PrintFormatter.printMoney;
import static christmas.util.PrintFormatter.printMinusMoney;
import static christmas.util.PrintFormatter.println;

import christmas.domain.benefit.Badge;
import christmas.domain.benefit.BenefitHistory;
import christmas.domain.order.Order;
import java.util.Optional;

public class OutputView {

    public static void printWelcome() {
        println(WELCOME_COMMENT);
    }

    public static void printVisitDate() {
        println(VISIT_DATE_COMMENT);
    }

    public static void printOrderMenu() {
        println(INPUT_ORDER_MENU_COMMENT);
    }

    public static void printEventBenefits(Order order, BenefitHistory benefitHistory) {
        int visitDate = order.getExpectedVisitDate();
        println(DECEMBER.getMessage() + visitDate + EVENT_BENEFITS_COMMENT.getMessage());
        println();

        printOrder(order);
        printBenefits(benefitHistory);
        printTotalBenefitAmount(benefitHistory.getTotalBenefitAmount());
        printAmountAfterDiscount(order.getTotalPrice(), benefitHistory);
    }

    private static void printOrder(Order order) {
        println(ORDER_MENU_COMMENT);
        println(order.getOrderItems());
        println();

        println(BEFORE_TOTAL_AMOUNT_COMMENT);
        printMoney(order.getTotalPrice());
        println();
    }

    private static void printBenefits(BenefitHistory benefitHistory) {
        println(PRESENT_MENU_COMMENT);
        println(benefitHistory.getPresentItems());
        println();

        println(BENEFIT_HISTORY_COMMENT);
        println(benefitHistory.getEventAndBenefitAmounts());
        println();
    }

    private static void printTotalBenefitAmount(int totalBenefitAmount) {
        println(TOTAL_BENEFIT_AMOUNT_COMMENT);
        printMinusMoney(totalBenefitAmount);
        println();
    }

    public static void printAmountAfterDiscount(int totalPrice, BenefitHistory benefitHistory) {
        println(TOTAL_PAYMENT_AMOUNT_COMMENT);
        printMoney(benefitHistory.getAmountAfterDiscount(totalPrice));
        println();
    }

    public static void printBadge(Optional<Badge> badge) {
        println(DECEMBER_EVENT_BADGE_COMMENT);
        if (badge.isPresent()) {
            println(badge.get().getName());
            return;
        }
        println(NO_VALUE_COMMENT);
    }
}