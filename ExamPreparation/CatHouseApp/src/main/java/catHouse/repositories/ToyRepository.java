package catHouse.repositories;

import catHouse.entities.toys.Ball;
import catHouse.entities.toys.Mouse;
import catHouse.entities.toys.Toy;

import java.util.ArrayList;
import java.util.Collection;

public class ToyRepository implements Repository{
    private Collection<Toy> toys;

    public ToyRepository() {
        this.toys = new ArrayList<>();
    }

    @Override
    public void buyToy(Toy toy) {
        this.toys.add(toy);
    }

    @Override
    public boolean removeToy(Toy toy) {
        if (toys.contains(toy)){
            toys.remove(toy);
            return true;
        }
        return false;
    }

    @Override
    public Toy findFirst(String type) {
        return toys
                .stream()
                .filter(t -> t.getClass().getSimpleName().equals(type))
                .findFirst()
                .orElse(null);
    }
}
