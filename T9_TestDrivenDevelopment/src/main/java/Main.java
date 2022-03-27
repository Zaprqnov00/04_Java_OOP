package T9_TestDrivenDevelopment.src.main.java;

public class Main {
    public static void main(String[] args) {

        Instock instock = new Instock();

        Product fish = new Product("Fish",7.60,1);
        Product fanta = new Product("Fanta",1.30,2);
        Product swheeps = new Product("Shweeps",1.20,3);
        Product meat = new Product("Meat",10.50,2);
        Product orange = new Product("Orange",1.30,2);

        instock.add(fish);
        instock.add(fanta);
        instock.add(swheeps);
        instock.add(meat);
        instock.add(orange);

        System.out.println(instock.findAllByPrice(1.30));
        System.out.println(instock.find(2));
        System.out.println(instock.findAllByQuantity(2));
        System.out.println(instock.getCount());
        System.out.println(instock.findByLabel("Fish"));
    }
}
