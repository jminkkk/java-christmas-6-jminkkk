package christmas.domain.event;

public interface DateEvent extends DecemberEvent {
    boolean isConditioned(int expectedVisitDate);
}
