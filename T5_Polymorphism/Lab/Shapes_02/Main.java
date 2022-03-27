package T5_Polymorphism.Lab.Shapes_02;

public class Main {
    public static void main(String[] args) {

        Rectangle rectangle = new Rectangle(10,5);
        System.out.println(rectangle.calculateArea());
        System.out.println(rectangle.calculatePerimeter());

        Circle circle = new Circle(20);
        System.out.println(circle.calculateArea());
        System.out.println(circle.calculatePerimeter());
    }
}
