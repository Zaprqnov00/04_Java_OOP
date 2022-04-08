package catHouse.entities.cat;

public class ShorthairCat extends BaseCat{
    private final static int KILOGRAMS_SHORTHAIR_CAT = 7;
    private final static int INCREASE_KILOGRAMS = 1;

    public ShorthairCat(String name, String breed, double price) {
        super(name, breed, price);
    }

    @Override
    public void eating() {
        this.setKilograms(KILOGRAMS_SHORTHAIR_CAT + INCREASE_KILOGRAMS);
    }
}
