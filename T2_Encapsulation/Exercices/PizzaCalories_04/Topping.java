package T2_Encapsulation.Exercices.PizzaCalories_04;

public class Topping {
    private String toppingType;
    private double weight;

    public Topping(String toppingType, double weight) {
        setToppingType(toppingType);
        setWeight(weight);
    }

    private void setToppingType(String toppingType) {
        if (toppingType.equals("Meat") || toppingType.equals("Veggies") || toppingType.equals("Cheese") || toppingType.equals("Sauce")) {
            this.toppingType = toppingType;
        }else {
            throw new IllegalArgumentException("Cannot place " + toppingType + " on top of your pizza.");
        }
    }

    private void setWeight(double weight) {
        if (weight < 1 || weight > 50){
            throw new IllegalArgumentException(this.toppingType + " weight should be in the range [1..50].");
        }
        this.weight = weight;
    }

    public double calculateCalories(){
        double toppingValue = 0;

        if (this.toppingType.equals("Meat")){
            toppingValue = 1.2;
        }else if (this.toppingType.equals("Veggies")){
            toppingValue = 0.8;
        }else if (this.toppingType.equals("Cheese")){
            toppingValue = 1.1;
        }else {
            toppingValue = 0.9;
        }
        return (2 * weight) * toppingValue;
    }
}
