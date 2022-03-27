package T1_Abstraction.Exercices.CardsWithPower_03;

import T1_Abstraction.Exercices.CardRank_02.CardRanks;
import T1_Abstraction.Exercices.CardSuit_01.CardSuits;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String cardRankInput = scanner.nextLine();
        String cardSuitInput = scanner.nextLine();

        CardRanks cardRanks = CardRanks.valueOf(cardRankInput);
        CardSuits cardSuits = CardSuits.valueOf(cardSuitInput);

        CardsPower cardsPower = new CardsPower(cardSuits, cardRanks);

        int power = cardsPower.calculatePower(cardSuits,cardRanks);

        System.out.printf("Card name: %s of %s; Card power: %d\n",cardRankInput,cardSuitInput,power);
    }
}
