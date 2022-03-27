package T5_Polymorphism.Exercices.Vehicles_01;

public class Car extends VehicleImpl{
    private final static double INCREASED_FUEL_CONSUMPTION = 0.9;

    public Car(String type, double fuel, double fuelConsumption) {
        super(type, fuel, fuelConsumption + INCREASED_FUEL_CONSUMPTION);
    }

    @Override
    public String toString(){
        return String.format("%s: %.2f",this.getType(),this.getFuel());
    }
}
