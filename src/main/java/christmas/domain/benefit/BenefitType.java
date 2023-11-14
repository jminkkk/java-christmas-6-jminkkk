package christmas.domain.benefit;

public enum BenefitType {
    DISCOUNT("할인"),
    PRESENT("증정품 제공")
    ;

    private final String name;
    BenefitType(String name) {
        this.name = name;
    }

    public String getMessage() {
        return null;
    }
}
