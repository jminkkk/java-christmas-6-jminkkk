package christmas.domain;

import christmas.domain.order.Order;
import christmas.domain.order.OrderItem;
import christmas.util.OrderItemConverter;
import christmas.validator.OrderItemValidator;
import christmas.validator.VisitDateValidator;
import christmas.view.InputView;
import christmas.view.OutputView;
import java.util.List;

public class EventPlanner {
    private final EventChecker eventChecker;
    public EventPlanner(EventChecker eventChecker) {
        this.eventChecker = eventChecker;
    }

    public void serveCustomer() {
        OutputView.printWelcome();

        OutputView.printVisitDate();
        int visitDate = askVisitDate();

        OutputView.printOrderMenu();
        List<OrderItem> orderItems = askOrderMenu();

        Order order = receiveOrder(visitDate, orderItems);
        BenefitHistory eventHistory = eventChecker.confirm(order);

        OutputView.printEventBenefits(eventHistory);
    }

    private Order receiveOrder(int visitDate, List<OrderItem> orderItems) {
        return new Order(visitDate, orderItems);
    }

    public int askVisitDate() {
        try {
            int visitDate = InputView.readVisitDate();
            VisitDateValidator.validate(visitDate);
            return visitDate;
        } catch (IllegalArgumentException e) {
            OutputView.println(e);
            return askVisitDate();
        }
    }

    public List<OrderItem> askOrderMenu() {
        try {
            String menuAndCount = InputView.readMenuAndCount();
            List<OrderItem> orderItems = OrderItemConverter.convert(menuAndCount);
            OrderItemValidator.validate(orderItems);
            return orderItems;
        } catch (IllegalArgumentException e) {
            OutputView.println(e);
            return askOrderMenu();
        }
    }
}
