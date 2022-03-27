package T5_Polymorphism.Exercices.Vehicles_01;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] inputCar = scanner.nextLine().split("\\s+");
        String type = inputCar[0];
        double fuelCar = Double.parseDouble(inputCar[1]);
        double fuelConsumptionCar = Double.parseDouble(inputCar[2]);

        Car car = new Car(type,fuelCar,fuelConsumptionCar);

        String[] inputTruck = scanner.nextLine().split("\\s+");
        String typeTruck = inputTruck[0];
        double fuelTruck = Double.parseDouble(inputTruck[1]);
        double fuelConsumptionTruck = Double.parseDouble(inputTruck[2]);

        Truck truck = new Truck(typeTruck,fuelTruck,fuelConsumptionTruck);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("\\s+");

            switch (input[0]){
                case "Drive":
                    double distance = Double.parseDouble(input[2]);
                    if (input[1].equals("Car")){
                        car.drive(distance);
                    }else {
                        truck.drive(distance);
                    }
                    break;
                case "Refuel":
                    double litres = Double.parseDouble(input[2]);
                    if (input[1].equals("Car")){
                        car.refuel(litres);
                    }else {
                        truck.refuel(litres);
                    }
                    break;
            }
        }

        System.out.println(car);
        System.out.println(truck);
    }
}
