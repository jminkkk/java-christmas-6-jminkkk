package christmas.domain;


import static christmas.global.Comment.BEFORE_TOTAL_AMOUNT_COMMENT;
import static christmas.global.Comment.BENEFIT_HISTORY_COMMENT;
import static christmas.global.Comment.DECEMBER;
import static christmas.global.Comment.DECEMBER_EVENT_BADGE_COMMENT;
import static christmas.global.Comment.EVENT_BENEFITS_COMMENT;
import static christmas.global.Comment.ORDER_MENU_COMMENT;
import static christmas.global.Comment.PRESENT_MENU_COMMENT;
import static christmas.global.Comment.TOTAL_BENEFIT_AMOUNT_COMMENT;
import static christmas.global.Comment.TOTAL_PAYMENT_AMOUNT_COMMENT;
import static christmas.view.OutputView.printMinusMoney;
import static christmas.view.OutputView.printMoney;
import static christmas.view.OutputView.println;

import christmas.domain.benefit.BenefitHistory;
import christmas.domain.order.Order;

public class EventPlanner {
    private final Order order;
    private final BenefitHistory benefitHistory;
    public EventPlanner(Order order, BenefitHistory benefitHistory) {
        this.order = order;
        this.benefitHistory = benefitHistory;
    }

    public void notifyEventHistory() {
        notifyPreview();
        notifyOrder();
        notifyBenefits();
        notifyTotalPayment();
        notifyBadge();
    }

    public void notifyPreview() {
        int visitDate = order.getExpectedVisitDate();
        println(DECEMBER.getMessage() + visitDate + EVENT_BENEFITS_COMMENT.getMessage());
        println();
    }

    private void notifyOrder() {
        println(ORDER_MENU_COMMENT);
        println(order.getOrderItems());
        println();

        println(BEFORE_TOTAL_AMOUNT_COMMENT);
        printMoney(order.getTotalPrice());
        println();
    }

    private void notifyBenefits() {
        println(PRESENT_MENU_COMMENT);
        println(benefitHistory.getPresentItems());
        println();

        println(BENEFIT_HISTORY_COMMENT);
        println(benefitHistory.getEventAndBenefitAmounts());
        println();

        println(TOTAL_BENEFIT_AMOUNT_COMMENT);
        printMinusMoney(benefitHistory.getTotalBenefitAmount());
        println();
    }

    private void notifyTotalPayment() {
        println(TOTAL_PAYMENT_AMOUNT_COMMENT);

        int totalPaymentAmount = checkTotalPayment();
        printMoney(totalPaymentAmount);
        println();
    }

    public void notifyBadge() {
        println(DECEMBER_EVENT_BADGE_COMMENT);
        Badge badge = checkBadge();
        println(badge);
    }

    public int checkTotalPayment() {
        int totalPrice = order.getTotalPrice();
        int totalDiscountAmount = benefitHistory.getTotalDiscountAmount();
        return totalPrice - totalDiscountAmount;
    }

    public Badge checkBadge() {
        int totalBenefitAmount = benefitHistory.getTotalBenefitAmount();
        return Badge.of(totalBenefitAmount);
    }
}
