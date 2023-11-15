package christmas.domain;

public enum Badge {
    STAR("별", 5_000),
    TREE("트리", 10_000),
    SANTA("산타", 20_000),
    ;
    private final String name;
    private final int totalBenefit;

    Badge(String name, int totalBenefit) {
        this.name = name;
        this.totalBenefit = totalBenefit;
    }

    public String getName() {
        return name;
    }

    public static Badge of(int totalBenefitAmount) {
        if (totalBenefitAmount >= SANTA.totalBenefit) {
            return SANTA;
        }

        if (totalBenefitAmount >= TREE.totalBenefit) {
            return TREE;
        }

        if (totalBenefitAmount >= STAR.totalBenefit) {
            return STAR;
        }

        return null;
    }
}
