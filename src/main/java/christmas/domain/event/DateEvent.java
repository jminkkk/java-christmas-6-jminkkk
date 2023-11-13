package christmas.domain.event;

public interface DateEvent extends Event {
    boolean isConditioned(int expectedVisitDate);
}
