package catHouse.entities.cat;

public class LonghairCat extends BaseCat{
    private final static int KILOGRAMS_LONGHAIRCAT = 9;
    private final static int INCREASE_KILOGRAMS = 3;

    public LonghairCat(String name, String breed, double price) {
        super(name, breed, price);
    }

    @Override
    public void eating() {
        super.setKilograms(KILOGRAMS_LONGHAIRCAT + INCREASE_KILOGRAMS);
    }

}
