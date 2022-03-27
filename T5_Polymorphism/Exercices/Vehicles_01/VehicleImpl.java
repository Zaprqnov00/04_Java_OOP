package T5_Polymorphism.Exercices.Vehicles_01;

import java.text.DecimalFormat;

public class VehicleImpl implements Vehicle{
    private String type;
    private double fuel;
    private double fuelConsumption;

    public VehicleImpl(String type, double fuel, double fuelConsumption) {
        this.type = type;
        this.fuel = fuel;
        this.fuelConsumption = fuelConsumption;
    }

    public String getType() {
        return type;
    }

    public double getFuel() {
        return fuel;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    protected void setFuel(double fuel) {
        this.fuel = fuel;
    }

    protected void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    @Override
    public void drive(double distance) {
        double needFuelForDrive = distance * this.fuelConsumption;
        DecimalFormat decimalFormat = new DecimalFormat("0.##");
        if (fuel >= needFuelForDrive){
            setFuel(this.fuel - needFuelForDrive);
            System.out.printf("%s travelled %s km\n",this.type,decimalFormat.format(distance));
        }else {
            System.out.printf("%s needs refueling\n",this.type);
        }
    }

    @Override
    public void refuel(double litres) {
        setFuel(this.fuel + litres);
    }
}
