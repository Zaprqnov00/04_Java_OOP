package T1_Abstraction.Lab.HoteResarvation_04;

public enum DiscountType {
    VIP(20),
    SecondVisit(10),
    None(0);

    private int discount;

    DiscountType(int discount) {
        this.discount = discount;
    }

    public int getDiscount() {
        return discount;
    }
}
