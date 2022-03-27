package T4_Interfaces.Exercices.BirthdayCelebrations_03;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Citizen> citizenList = new ArrayList<>();
        List<Pet> petList = new ArrayList<>();
        List<Robot> robotList = new ArrayList<>();

        String command = scanner.nextLine();

        while (!command.equals("End")) {
            String[] input = command.split("\\s+");

            switch (input[0]) {
                case "Citizen":
                    String name = input[1];
                    int age = Integer.parseInt(input[2]);
                    String id = input[3];
                    String birthDate = input[4];
                    Citizen citizen = new Citizen(name,age,id,birthDate);
                    citizenList.add(citizen);
                    break;
                case "Pet":
                    String namePet = input[1];
                    String birthDatePet = input[2];
                    Pet pet = new Pet(namePet,birthDatePet);
                    petList.add(pet);
                    break;
                case "Robot":
                    String model = input[1];
                    String idRobot =  input[2];
                    Robot robot = new Robot(idRobot,model);
                    robotList.add(robot);
                    break;

            }
            command = scanner.nextLine();
        }

        String searchBirthDateYear = scanner.nextLine();

        for (Citizen citizen :citizenList) {
            if (citizen.getBirthDate().endsWith(searchBirthDateYear)){
                System.out.println(citizen.getBirthDate());
            }
        }

        for (Pet pet :petList) {
            if (pet.getBirthDate().endsWith(searchBirthDateYear)) {
                System.out.println(pet.getBirthDate());
            }
        }
    }
}
