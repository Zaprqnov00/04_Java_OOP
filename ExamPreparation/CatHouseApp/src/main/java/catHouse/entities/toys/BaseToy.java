package catHouse.entities.toys;

public abstract class BaseToy implements Toy{
    private int softness;
    private double price;

    protected BaseToy(int softness, double price) {
        setSoftness(softness);
        setPrice(price);
    }

    private void setSoftness(int softness) {
        this.softness = softness;
    }

    private void setPrice(double price) {
        this.price = price;
    }

    @Override
    public int getSoftness() {
        return this.softness;
    }

    @Override
    public double getPrice() {
        return this.price;
    }
}
