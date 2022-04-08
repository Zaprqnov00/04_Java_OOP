package cats;

public class Main {
    public static void main(String[] args) {

        House house = new House("Home",5);

        Cat tom = new Cat("Tom");
        Cat jerry = new Cat("jerry");
        Cat andi = new Cat("andi");

        house.addCat(tom);
        house.addCat(jerry);
        house.addCat(andi);

        System.out.println(house.getCapacity());
        System.out.println(house.getCount());
        System.out.println(house.statistics());
    }
}
