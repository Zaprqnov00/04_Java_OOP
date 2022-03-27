package T4_Interfaces.Lab.CarShopExtend_02;

public class Seat extends CarImpl implements Sellable{
    private Double price;

    public Seat(String model, String color, int horsePower, String countryProduced, Double price) {
        super(model, color, horsePower, countryProduced);
        this.price = price;
    }

    @Override
    public Double getPrice() {
        return this.price;
    }

    @Override
    public String toString(){
        return String.format("This is %s produced in %s and have %d tires\n%s sells for %s"
                ,getModel(),countryProduced(),TIRES,getModel(),getPrice());
    }
}
