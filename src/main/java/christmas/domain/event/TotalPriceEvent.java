package christmas.domain.event;

/**
 * DateEvent 인터페이스는 주문의 할인 전 총주문 금액이 의존하여 적용되는 이벤트를 나타내는 인터페이스입니다.
 */
public interface TotalPriceEvent extends Event {
    /**
     * 주어진 totalPrice가 구현체의 날짜 조건을 만족하는지 여부를 반환합니다.
     *
     * @param totalPrice 예상 방문 날짜
     * @return 할인 전 총주문 금액을 만족하는지 여부 (true: 만족, false: 만족하지 않음)
     */
    boolean isConditioned(int totalPrice);
}
