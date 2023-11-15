package christmas;


import static christmas.global.Comment.INPUT_ORDER_MENU_COMMENT;
import static christmas.global.Comment.NOT_SATISFIED_MINIMUM_EVENT_APPLICATION_PRICE;
import static christmas.global.Comment.VISIT_DATE_COMMENT;
import static christmas.global.Comment.WELCOME_COMMENT;
import static christmas.view.OutputView.println;

import christmas.domain.EventPlanner;
import christmas.domain.benefit.BenefitHistory;
import christmas.domain.order.Order;
import christmas.domain.order.OrderItem;
import christmas.util.OrderItemConverter;
import christmas.validator.OrderItemValidator;
import christmas.validator.VisitDateValidator;
import christmas.view.InputView;
import java.util.List;

public class Shop {
    private static final int MINIMUM_EVENT_APPLICATION_PRICE = 10_000;
    private final BenefitHistoryGenerator benefitHistoryGenerator;

    public Shop(BenefitHistoryGenerator benefitHistoryGenerator) {
        this.benefitHistoryGenerator = benefitHistoryGenerator;
    }

    public void serveCustomer() {
        println(WELCOME_COMMENT);
        int visitDate = askVisitDate();
        List<OrderItem> orderItems = askOrderMenu();

        Order newOrder = receiveOrder(visitDate, orderItems);

        if (newOrder.getTotalPrice() < MINIMUM_EVENT_APPLICATION_PRICE) {
            println(NOT_SATISFIED_MINIMUM_EVENT_APPLICATION_PRICE);
        }

        BenefitHistory benefitHistory = benefitHistoryGenerator.generateBenefitHistory(newOrder);
        EventPlanner eventPlanner = new EventPlanner(newOrder, benefitHistory);
        eventPlanner.notifyEventHistory();
    }

    public int askVisitDate() {
        println(VISIT_DATE_COMMENT);
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
        println(INPUT_ORDER_MENU_COMMENT);
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

    public Order receiveOrder(int visitDate, List<OrderItem> orderItems) {
        return Order.of(visitDate, orderItems);
    }
}
