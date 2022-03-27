package T3_Inheritance.Exercices.Restaurant_05;

import java.math.BigDecimal;

public class Salmon extends Starter {
    private final static double SALMON_GRAMS = 22;

    public Salmon(String name, BigDecimal price) {
        super(name, price, SALMON_GRAMS);
    }
}

