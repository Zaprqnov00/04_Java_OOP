package T2_Encapsulation.Exercices.ClassBox_01;

public class Box {
    private double length;
    private double width;
    private double height;

    public Box(double length, double width, double height) {
        setLength(length);
        setWidth(width);
        setHeight(height);
    }

    private void setLength(double length) {
        if (length > 0) {
            this.length = length;
        } else {
            throw new IllegalArgumentException("Length cannot be zero or negative.");
        }
    }

    private void setWidth(double width) {
        if (width > 0) {
            this.width = width;
        } else {
            throw new IllegalArgumentException("Width cannot be zero or negative.");
        }
    }

    private void setHeight(double height) {
        if (height > 0) {
            this.height = height;
        } else {
            throw new IllegalArgumentException("Height cannot be zero or negative.");
        }
    }

    public double calculateSurfaceArea() {
        //2lw + 2lh + 2wh
        return 2 * length * width + 2 * length * height + 2 * width * height;
    }

    public double calculateLateralSurfaceArea() {
        //2lh + 2wh
        return 2 * length * height + 2 * width * height;
    }

    public double calculateVolume() {
        //lhw
        return length * height * width;
    }

    @Override
    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("Surface Area - %.2f\n",calculateSurfaceArea()));
        stringBuilder.append(String.format("Lateral Surface Area - %.2f\n",calculateLateralSurfaceArea()));
        stringBuilder.append(String.format("Volume – %.2f",calculateVolume()));
        return stringBuilder.toString();
    }
}
