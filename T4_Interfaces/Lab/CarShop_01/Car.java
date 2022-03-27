package T4_Interfaces.Lab.CarShop_01;

public interface Car extends Serializable {
    int TIRES = 4;
    String getModel();
    String getColor();
    Integer getHorsePower();
    String countryProduced();
}
