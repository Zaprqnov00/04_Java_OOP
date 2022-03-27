package T5_Polymorphism.Exercices.Vehicles_01;

public class Truck extends VehicleImpl{
    private final static double INCREASED_FUEL_CONSUMPTION = 1.6;
    private final static double PERCENT_REFUEL = 0.95;

    public Truck(String type, double fuel, double fuelConsumption) {
        super(type, fuel, fuelConsumption + INCREASED_FUEL_CONSUMPTION);
    }

    @Override
    public void refuel(double litres) {
        super.refuel(litres * PERCENT_REFUEL);
    }

    @Override
    public String toString(){
        return String.format("%s %.2f",this.getType(),this.getFuel());
    }
}
