package T5_Polymorphism.Lab.Animals_03;

public class Dog extends Animal{
    public Dog(String name, String favouriteFood) {
        super(name, favouriteFood);
    }

    @Override
    public String explainSelf() {
        return String.format("I am %s and my favourite food is %s\nDJAAF",this.getName(),this.getFavouriteFood());
    }
}
