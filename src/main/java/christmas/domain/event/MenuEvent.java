package christmas.domain.event;

import christmas.domain.order.OrderItem;
import java.util.List;

/**
 * MenuEvent 인터페이스는 주문 내역 중 특정 메뉴에 의존하여 적용되는 이벤트를 나타내는 인터페이스입니다.
 */
public interface MenuEvent extends Event {
    /**
     * 주어진 orderItems이 구현체의 날짜 조건을 만족하는지 여부를 반환합니다.
     *
     * @param orderItems 주문 메뉴 및 수량 내역
     * @return 메뉴 조건을 만족하는지 여부 (true: 만족, false: 만족하지 않음)
     */
    boolean isConditioned(List<OrderItem> orderItems);
}
