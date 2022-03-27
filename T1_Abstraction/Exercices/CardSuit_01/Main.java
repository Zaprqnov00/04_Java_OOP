package T1_Abstraction.Exercices.CardSuit_01;

public class Main {
    public static void main(String[] args) {

        System.out.println("Card Suits:");
        for (CardSuits card :CardSuits.values()) {
            System.out.printf("Ordinal value: %d; Name value: %s\n",card.ordinal(),card.name());
        }
    }
}
