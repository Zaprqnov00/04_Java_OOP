package T2_Encapsulation.Exercices.ShoppingSpree_03;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Person> personList = new ArrayList<>();
        List<Product> productList = new ArrayList<>();

        String[] personInput = scanner.nextLine().split("[=;]+");
        for (int i = 0; i < personInput.length; i+=2) {
            String name = personInput[i];
            double money = Double.parseDouble(personInput[i + 1]);
            Person person = new Person(name,money);
            personList.add(person);
        }

        String[] productInput = scanner.nextLine().split("[=;]+");
        for (int i = 0; i < productInput.length; i+=2) {
            String name = productInput[i];
            double cost = Double.parseDouble(productInput[i + 1]);
            Product product = new Product(name,cost);
            productList.add(product);
        }

        String command = scanner.nextLine();
        while (!command.equals("END")){
            String[] input = command.split("\\s+");
            String person = input[0];
            String product = input[1];

            for (Person man :personList) {
                for (Product prod :productList) {
                    if (person.equals(man.getName()) && product.equals(prod.getName())){
                        man.buyProduct(prod);
                    }
                }
            }

            command = scanner.nextLine();
        }

        personList.forEach(System.out::println);
    }
}
