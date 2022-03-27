package T2_Encapsulation.Lab.FirstAndReserveTeam_04;

import T2_Encapsulation.Lab.SalaryIncrease_02.Person;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Team {
    private String name;
    private List<Person> firstTeam;
    private List<Person> reserveTeam;

    public Team(String name) {
        setName(name);
        this.firstTeam = new ArrayList<>();
        this.reserveTeam = new ArrayList<>();
    }

    public void setName(String name) {
        if (name.length() >= 3) {
            this.name = name;
        }else {
            throw new IllegalArgumentException("Name cannot be less than 3 symbols");
        }
    }

    public String getName() {
        return name;
    }

    public List<Person> getFirstTeam() {
        return Collections.unmodifiableList(this.firstTeam);
    }

    public List<Person> getReserveTeam() {
        return Collections.unmodifiableList(this.reserveTeam);
    }

    public void addPlayer(Person person){
        if (person.getAge() >= 40){
            this.reserveTeam.add(person);
        }else {
            this.firstTeam.add(person);
        }
    }

    @Override
    public String toString() {
        return String.format("First team have %d players\nReserve team have %d players",this.firstTeam.size(),this.reserveTeam.size());
    }
}
