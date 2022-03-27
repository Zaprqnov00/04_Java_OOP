package T4_Interfaces.Lab.SayHelloExtend_04;

import T4_Interfaces.Lab.SayHello_03.Person;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>();


        persons.add(new Bulgarian("Peter"));
        persons.add(new European("Peter"));
        persons.add(new Chinese("Peter"));

        for (Person person : persons) {
            print(person);
        }
    }

    private static void print(Person person) {
        System.out.println(person.sayHello());
    }

}
