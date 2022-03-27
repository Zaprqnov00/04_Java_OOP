package T3_Inheritance.Lab.HierarchicalInheritance_03;

import T3_Inheritance.Lab.SingleInheritance_01.Dog;

public class Main {
    public static void main(String[] args) {

        Dog dog = new Dog();
        dog.eat();
        dog.bark();

        Cat cat = new Cat();
        cat.eat();
        cat.meow();
    }
}
