package christmas.domain.benefit;

public class Benefit {
    private final BenefitType benefitType;
    private final int benefitAmount;

    public Benefit(BenefitType benefitType, int benefitAmount) {
        this.benefitType = benefitType;
        this.benefitAmount = benefitAmount;
    }

    public BenefitType getBenefitType() {
        return benefitType;
    }

    public int getBenefitAmount() {
        return benefitAmount;
    }

    public static Benefit of(BenefitType benefitType, int benefitAmount) {
        return new Benefit(benefitType, benefitAmount);
    }
}
