package T4_Interfaces.Lab.BorderController_05;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Citizen> citizenList = new ArrayList<>();
        List<Robot> robotList = new ArrayList<>();

        String command = scanner.nextLine();
        while (!command.equals("End")){
            String[] input = command.split("\\s+");
            if (input.length == 3){
                String name = input[0];
                int age = Integer.parseInt(input[1]);
                String id = input[2];

                Citizen citizen = new Citizen(name,age,id);
                citizenList.add(citizen);
            }else {
                String id = input[0];
                String model = input[1];
                Robot robot = new Robot(model,id);
                robotList.add(robot);
            }

            command = scanner.nextLine();
        }

        String searchId = scanner.nextLine();
        for (Citizen citizen :citizenList) {
            if (citizen.getId().endsWith(searchId)){
                System.out.println(citizen.getId());
            }
        }
        for (Robot robot :robotList) {
            if (robot.getId().endsWith(searchId)){
                System.out.println(robot.getId());
            }
        }
    }
}
