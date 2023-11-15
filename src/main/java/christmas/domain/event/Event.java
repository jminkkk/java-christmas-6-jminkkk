package christmas.domain.event;

import christmas.domain.benefit.Benefit;
import christmas.domain.order.Order;

/**
 * Event 인터페이스는 모든 이벤트를 나타내는 인터페이스입니다. 모든 구현체는 이름을 가지고 있습니다.
 */
public interface Event {
    /**
     * 이벤트의 이름을 반환합니다.
     *
     * @return 이벤트의 이름
     */
    String getName();

    /**
     * 주어진 주문에 대한 이벤트의 혜택을 적용하고 결과를 반환합니다.
     *
     * @param order 주문
     * @return 적용된 혜택
     */
    Benefit applyBenefit(Order order);

    /**
     * 주어진 주문이 이벤트의 조건을 만족하는지 여부를 반환합니다.
     *
     * @param order 주문
     * @return 주문이 조건을 만족하는지 여부 (true: 만족, false: 만족하지 않음)
     */
    boolean isConditioned(Order order);
}
