package T5_Polymorphism.Lab.MathOperation_01;

public class Main {
    public static void main(String[] args) {

        MathOperation mathOperation = new MathOperation();
        System.out.println(mathOperation.add(2,2));
        System.out.println(mathOperation.add(5,2,2));
        System.out.println(mathOperation.add(4,4,4,4));
    }
}
