package T3_Inheritance.Exercices.Animals_06;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String animal = scanner.nextLine();
        while (!animal.equals("Beast!")) {
            String[] typeAnimal = scanner.nextLine().split("\\s+");
            String name = typeAnimal[0];
            int age = Integer.parseInt(typeAnimal[1]);
            String gender = typeAnimal[2];

            switch (animal){
                case "Cat":
                    Cat cat = new Cat(name,age,gender);
                    System.out.println(animal);
                    System.out.println(cat);
                    System.out.println(cat.produceSound());
                    break;
                case "Dog":
                    Dog dog = new Dog(name,age,gender);
                    System.out.println(animal);
                    System.out.println(dog);
                    System.out.println(dog.produceSound());
                    break;
                case "Frog":
                    Frog frog = new Frog(name,age,gender);
                    System.out.println(animal);
                    System.out.println(frog);
                    System.out.println(frog.produceSound());
                    break;
                case "Kitten":
                    Kitten kitten = new Kitten(name,age);
                    System.out.println(animal);
                    System.out.println(kitten);
                    System.out.println(kitten.produceSound());
                    break;
                case "Tomcat":
                    Tomcat tomcat = new Tomcat(name,age);
                    System.out.println(animal);
                    System.out.println(tomcat);
                    System.out.println(tomcat.produceSound());
                    break;
            }

            animal = scanner.nextLine();
        }
    }
}
