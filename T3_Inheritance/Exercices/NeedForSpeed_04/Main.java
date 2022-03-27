package T3_Inheritance.Exercices.NeedForSpeed_04;

public class Main {
    public static void main(String[] args) {

        SportCar bmw = new SportCar(20.5,150);
        FamilyCar tesla = new FamilyCar(20,120);

        if (bmw.getHorsePower() > tesla.getHorsePower()){
            System.out.println("BMW is the best");
        }else {
            System.out.println("Tesla is the best");
        }
    }
}
