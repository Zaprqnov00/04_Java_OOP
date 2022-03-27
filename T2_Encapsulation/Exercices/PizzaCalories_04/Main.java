package T2_Encapsulation.Exercices.PizzaCalories_04;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] pizzaInput = scanner.nextLine().split("\\s+");
        String pizzaName = pizzaInput[1];
        int numberOfToppings = Integer.parseInt(pizzaInput[2]);

        Pizza pizza = new Pizza(pizzaName,numberOfToppings);

        String[] doughInput = scanner.nextLine().split("\\s+");
        String flourType = doughInput[1];
        String backingTechnique = doughInput[2];
        double weightDough = Double.parseDouble(doughInput[3]);

        Dough dough = new Dough(flourType,backingTechnique,weightDough);
        pizza.setDough(dough);

        String command = scanner.nextLine();
        while (!command.equals("END")){
            String[] toppingInput = command.split("\\s+");
            String toppingType = toppingInput[1];
            double weightTopping = Double.parseDouble(toppingInput[2]);

            Topping topping = new Topping(toppingType,weightTopping);

            pizza.addTopping(topping);

            command = scanner.nextLine();
        }

        System.out.println(pizza);
    }
}
