package T2_Encapsulation.Exercices.PizzaCalories_04;

public class Dough {
    private String flourType;
    private String bakingTechnique;
    private double weight;

    public Dough(String flourType, String bakingTechnique, double weight) {
       setFlourType(flourType);
       setBakingTechnique(bakingTechnique);
       setWeight(weight);
    }

    private void setFlourType(String flourType) {
        if (flourType.equals("White") || flourType.equals("Wholegrain")){
            this.flourType = flourType;
        }else {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
    }

    private void setBakingTechnique(String bakingTechnique) {
        if (bakingTechnique.equals("Crispy") || bakingTechnique.equals("Chewy") || bakingTechnique.equals("Homemade")) {
            this.bakingTechnique = bakingTechnique;
        }else {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
    }

    private void setWeight(double weight) {
        if (weight < 1 || weight > 200){
            throw new IllegalArgumentException("Dough weight should be in the range [1..200].");
        }
        this.weight = weight;
    }

    public double calculateCalories(){
        double flourTypeValue = 0;
        double backingTechniqueValue = 0;

        if (this.flourType.equals("White")){
            flourTypeValue = 1.5;
        }else if (this.flourType.equals("Wholegrain")){
            flourTypeValue = 1.0;
        }

        if (this.bakingTechnique.equals("Crispy")){
            backingTechniqueValue = 0.9;
        }else if (this.bakingTechnique.equals("Chewy")){
            backingTechniqueValue = 1.1;
        }else if (this.bakingTechnique.equals("Homemade")){
            backingTechniqueValue = 1.0;
        }

        return (2 * weight) * flourTypeValue * backingTechniqueValue;
    }
}
