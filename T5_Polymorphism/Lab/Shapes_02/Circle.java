package T5_Polymorphism.Lab.Shapes_02;

public class Circle extends Shape{
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double calculatePerimeter() {
        return radius / 2;
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }
}
