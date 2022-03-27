package T2_Encapsulation.Exercices.FootballTeamGenerator_05;

import java.util.ArrayList;
import java.util.List;

public class Team {
    private String name;
    private List<Player> players;

    public Team(String name) {
        setName(name);
        this.players = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()){
            throw new IllegalArgumentException("A name should not be empty.");
        }
        this.name = name;
    }

    public void addPlayer(Player player,String teamName){
        if (this.name.equals(teamName)){
            players.add(player);
        }else {
            throw new IllegalArgumentException("Team " + teamName +" does not exist.");
        }

    }

    public void removePlayer(String name, String teamName){
        boolean search = true;
        for (Player player :players) {
            if (this.name.equals(teamName) && player.getName().equals(name)){
                players.remove(player);
                search = false;
                break;
            }
        }
        if (search){
            throw new IllegalArgumentException("Player " + name + " is not in " + teamName + " team.");
        }
    }

    public double getRating(){
        return players.stream().mapToDouble(Player::overallSkillLevel).sum();
    }

    @Override
    public String toString(){
       return String.format("%s - %.0f",this.name,this.getRating());
    }
}

