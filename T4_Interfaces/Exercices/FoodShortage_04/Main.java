package T4_Interfaces.Exercices.FoodShortage_04;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<Citizen> citizensSet = new LinkedHashSet<>();
        Set<Rebel> rebelSet = new LinkedHashSet<>();

        int numberOfPeople = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numberOfPeople; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            String name = input[0];
            int age = Integer.parseInt(input[1]);
            if (input.length == 4) {
                String id = input[2];
                String birthDate = input[3];
                Citizen citizen = new Citizen(name, age, id, birthDate);
                citizensSet.add(citizen);
            } else {
                String group = input[2];
                Rebel rebel = new Rebel(name, age, group);
                rebelSet.add(rebel);
            }
        }

        String name = scanner.nextLine();
        int allFoodSCitizen = 0;
        int allFoodSRebel = 0;

        while (!name.equals("End")) {
            for (Citizen citizen : citizensSet) {
                if (citizen.getName().equals(name)) {
                    citizen.buyFood();
                    allFoodSCitizen = citizen.getFood();
                }
            }
            for (Rebel rebel : rebelSet) {
                if (rebel.getName().equals(name)) {
                    rebel.buyFood();
                    allFoodSRebel = rebel.getFood();
                }
            }
            name = scanner.nextLine();
        }

        System.out.println(allFoodSCitizen + allFoodSRebel);
    }
}
