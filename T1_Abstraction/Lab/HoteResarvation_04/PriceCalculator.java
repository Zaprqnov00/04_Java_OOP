package T1_Abstraction.Lab.HoteResarvation_04;

public class PriceCalculator {
    private double pricePerDay;
    private int days;

    public PriceCalculator(double pricePerDay, int days) {
        this.pricePerDay = pricePerDay;
        this.days = days;
    }

    public double getPricePerDay() {
        return pricePerDay;
    }

    public int getDays() {
        return days;
    }

    public void finalPrice(PriceCalculator priceCalculator, Season season, DiscountType discountType){
        double priceWithOutDiscount = priceCalculator.getPricePerDay() * priceCalculator.getDays() * season.getPrice();
        double finalSum = priceWithOutDiscount - (priceWithOutDiscount * discountType.getDiscount() / 100);
        System.out.printf("%.2f",finalSum);
    }
}
