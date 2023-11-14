package christmas.domain.event;

import christmas.domain.benefit.Benefit;
import christmas.domain.order.Order;

/**
 * @ImplNote 이벤트
 */
public interface Event {
    String getName();

    /**
     * @param order 주문
     * @return 주문에 적용되는 할인 금액
     */
    Benefit applyBenefit(Order order);

    /**
     * @param order 주문
     * @return 주문이 해당 이벤트의 조건을 만족하는지 여부
     */
    boolean isConditioned(Order order);
}
