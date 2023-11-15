package christmas.domain.benefit;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Benefit benefit = (Benefit) o;
        return benefitAmount == benefit.benefitAmount && benefitType == benefit.benefitType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(benefitType, benefitAmount);
    }

    public int compareTo(Benefit benefit) {
        return benefit.getBenefitAmount() - this.getBenefitAmount();
    }
}
