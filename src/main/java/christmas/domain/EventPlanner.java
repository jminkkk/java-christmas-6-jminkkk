package christmas.domain;


import static christmas.util.PrintFormatter.println;

import christmas.domain.benefit.Badge;
import christmas.domain.benefit.BenefitHistory;
import christmas.domain.order.Order;
import christmas.domain.order.OrderItem;
import christmas.util.OrderItemConverter;
import christmas.validator.OrderItemValidator;
import christmas.validator.VisitDateValidator;
import christmas.view.InputView;
import christmas.view.OutputView;
import java.util.List;
import java.util.Optional;

public class EventPlanner {
    private final BenefitHistoryGenerator benefitHistoryGenerator;

    public EventPlanner(BenefitHistoryGenerator benefitHistoryGenerator) {
        this.benefitHistoryGenerator = benefitHistoryGenerator;
    }

    public void serveCustomer() {
        OutputView.printWelcome();
        Order order = receiveOrder();

        BenefitHistory benefitHistory = getBenefitsHistory(order);
        OutputView.printEventBenefits(order, benefitHistory);

        Optional<Badge> badge = getBadge(benefitHistory);
        OutputView.printBadge(badge);
    }

    private Order receiveOrder() {
        int visitDate = askVisitDate();
        List<OrderItem> orderItems = askOrderMenu();

        return Order.of(visitDate, orderItems);
    }

    public int askVisitDate() {
        OutputView.printVisitDate();
        try {
            int visitDate = InputView.readVisitDate();
            VisitDateValidator.validate(visitDate);
            return visitDate;
        } catch (IllegalArgumentException e) {
            println(e);
            return askVisitDate();
        }
    }

    public List<OrderItem> askOrderMenu() {
        OutputView.printOrderMenu();
        try {
            String menuAndCount = InputView.readMenuAndCount();
            List<OrderItem> orderItems = OrderItemConverter.convert(menuAndCount);
            OrderItemValidator.validate(orderItems);
            return orderItems;
        } catch (IllegalArgumentException e) {
            println(e);
            return askOrderMenu();
        }
    }

    private BenefitHistory getBenefitsHistory(Order order) {
        return benefitHistoryGenerator.generateBenefitHistory(order);
    }

    private Optional<Badge> getBadge(BenefitHistory benefitHistory) {
        int totalBenefitAmount = benefitHistory.getTotalBenefitAmount();
        return benefitHistoryGenerator.giftBadge(totalBenefitAmount);
    }
}
