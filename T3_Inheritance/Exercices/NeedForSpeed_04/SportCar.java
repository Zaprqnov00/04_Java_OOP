package T3_Inheritance.Exercices.NeedForSpeed_04;

public class SportCar extends Car{
    private final static double DEFAULT_FUEL_CONSUMPTION = 10;

    public SportCar(double fuel, int horsePower) {
        super(fuel, horsePower);
        this.setFuelConsumption(DEFAULT_FUEL_CONSUMPTION);
    }
}
