package T1_Abstraction.Lab.HoteResarvation_04;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");
        double pricePerDay = Double.parseDouble(input[0]);
        int days = Integer.parseInt(input[1]);
        Season season = Season.valueOf(input[2]);
        DiscountType discountType = DiscountType.valueOf(input[3]);

        PriceCalculator priceCalculator = new PriceCalculator(pricePerDay,days);

        priceCalculator.finalPrice(priceCalculator,season,discountType);


    }
}
