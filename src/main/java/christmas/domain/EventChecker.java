package christmas.domain;

import christmas.domain.order.Order;

public class EventChecker {
    public BenefitHistory confirm(Order order) {
        // 주문으로부터 각 할인들이 적용될 수 있는지 확인
        return new BenefitHistory();
    }
}
