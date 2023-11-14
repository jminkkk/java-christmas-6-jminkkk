package christmas.domain.event;

/**
 * @ImplNote 방문일자에 따라 적용되는 이벤트
 */
public interface DateEvent extends Event {
    /**
     * @param expectedVisitDate 방문일자
     * @return 방문일자가 이 이벤트의 조건을 만족하는 여부
     */
    boolean isConditioned(int expectedVisitDate);
}
