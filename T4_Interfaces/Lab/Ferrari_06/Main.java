package T4_Interfaces.Lab.Ferrari_06;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String driverName = scanner.nextLine();

        Ferrari ferrari = new Ferrari(driverName);
        System.out.println(ferrari);
    }
}
