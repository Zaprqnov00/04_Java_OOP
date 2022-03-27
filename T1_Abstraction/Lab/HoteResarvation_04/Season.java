package T1_Abstraction.Lab.HoteResarvation_04;

public enum Season {
    Autumn(1),
    Spring(2),
    Winter(3),
    Summer(4);


    private int price;

    Season(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
}
