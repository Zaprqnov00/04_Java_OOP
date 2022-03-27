package T5_Polymorphism.Lab.Shapes_02;

public class Rectangle extends Shape{
    private double height;
    private double width;

    public Rectangle(double height, double width) {
        this.height = height;
        this.width = width;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * height + 2 * width;
    }

    @Override
    public double calculateArea() {
        return height * width;
    }
}
