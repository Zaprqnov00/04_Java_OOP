package T2_Encapsulation.Lab.SalaryIncrease_02;

import T2_Encapsulation.Lab.FirstAndReserveTeam_04.Team;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<Person> people = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            String firstName = input[0];
            String lastName = input[1];
            int age = Integer.parseInt(input[2]);
            double salary = Double.parseDouble(input[3]);
            Person person = new Person(firstName,lastName,age,salary);
            people.add(person);
        }

        Team team = new Team("Mashinite");
        for (Person player :people) {
            team.addPlayer(player);
        }

        System.out.println(team);
    }
}
