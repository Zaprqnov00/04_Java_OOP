package T2_Encapsulation.Exercices.FootballTeamGenerator_05;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] inputTeam = scanner.nextLine().split(";");
        String teamName = inputTeam[1];

        Team team = new Team(teamName);

        String command = scanner.nextLine();
        while (!command.equals("END")){
            String[] input = command.split(";");
            String teamNameSearch = input[1];

            switch (input[0]){
                case "Add":
                String playerName = input[2];
                int endurance = Integer.parseInt(input[3]);
                int sprint = Integer.parseInt(input[4]);
                int dribble = Integer.parseInt(input[5]);
                int passing = Integer.parseInt(input[6]);
                int shooting = Integer.parseInt(input[7]);

                Player player = new Player(playerName,endurance,sprint,dribble,passing,shooting);
                team.addPlayer(player,teamName);
                    break;
                case "Remove":
                    String removePlayerByName = input[2];
                    team.removePlayer(removePlayerByName,teamNameSearch);
                    break;
                case "Rating":
                    if (team.getName().equals(teamNameSearch)) {
                        System.out.println(team);
                    }else {
                        throw new IllegalArgumentException("Team " + teamNameSearch + " does not exist.");
                    }
                    break;
            }
            command = scanner.nextLine();
        }
    }
}
