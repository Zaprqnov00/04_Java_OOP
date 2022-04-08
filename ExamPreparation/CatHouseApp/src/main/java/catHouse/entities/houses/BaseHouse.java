package catHouse.entities.houses;

import catHouse.common.ConstantMessages;
import catHouse.common.ExceptionMessages;
import catHouse.entities.cat.Cat;
import catHouse.entities.toys.Toy;

import java.util.ArrayList;
import java.util.Collection;

public abstract class BaseHouse implements House {
    private String name;
    private int capacity;
    private Collection<Toy> toys;
    private Collection<Cat> cats;

    protected BaseHouse(String name, int capacity) {
        setName(name);
        setCapacity(capacity);
        this.toys = new ArrayList<>();
        this.cats = new ArrayList<>();
    }

    private void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public int sumSoftness() {
        return toys.
                stream()
                .mapToInt(Toy::getSoftness)
                .sum();
    }

    @Override
    public void addCat(Cat cat) {
        if (this.capacity <= this.cats.size()) {
            throw new IllegalStateException(ConstantMessages.NOT_ENOUGH_CAPACITY_FOR_CAT);
        }
        this.cats.add(cat);
    }

    @Override
    public void removeCat(Cat cat) {
        this.cats.remove(cat);
    }

    @Override
    public void buyToy(Toy toy) {
        this.toys.add(toy);
    }

    @Override
    public void feeding() {
        this.cats.forEach(Cat::eating);
    }

    @Override
    public String getStatistics() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(this.name).append(" ").append(this.getClass().getSimpleName()).append(":").append("\n");
        if (cats.isEmpty()) {
            stringBuilder.append("Cats: none").append("\n");
            stringBuilder.append("Toys: ").append(toys.size());
            stringBuilder.append(" Softness: ").append(sumSoftness()).append("\n");
        } else {
            stringBuilder.append("Cats: ");
            for (Cat cat : cats) {
                stringBuilder.append(cat.getName()).append(" ");
            }
            stringBuilder.append("\n");
            stringBuilder.append("Toys: ").append(toys.size());
            stringBuilder.append(" Softness: ").append(sumSoftness()).append("\n");
        }
        return stringBuilder.toString().trim();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(ExceptionMessages.HOUSE_NAME_CANNOT_BE_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    @Override
    public Collection<Cat> getCats() {
        return this.cats;
    }

    @Override
    public Collection<Toy> getToys() {
        return this.toys;
    }
}
