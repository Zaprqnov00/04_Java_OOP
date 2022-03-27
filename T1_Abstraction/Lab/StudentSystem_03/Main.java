package T1_Abstraction.Lab.StudentSystem_03;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        Map<String,Student> studentMap = new LinkedHashMap<>();

        String command = scanner.nextLine();
        while (!command.equals("Exit")) {
            String[] input = command.split("\\s+");
            String name = input[1];
            switch (input[0]){
                case "Create":
                    int age = Integer.parseInt(input[2]);
                    double grade = Double.parseDouble(input[3]);
                    Student student = new Student(name,age,grade);
                    studentMap.put(name,student);
                    break;
                case "Show":
                    for (Map.Entry<String, Student> entry : studentMap.entrySet()) {
                        if (name.equals(entry.getValue().getName())){
                            entry.getValue().showStudent(name);
                            break;
                        }
                    }

                    break;
            }

            command = scanner.nextLine();
        }
    }
}
