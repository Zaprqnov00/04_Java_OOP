package T1_Abstraction.Exercices.CardsWithPower_03;

import T1_Abstraction.Exercices.CardRank_02.CardRanks;
import T1_Abstraction.Exercices.CardSuit_01.CardSuits;

public class CardsPower {

    private CardSuits cardSuits;
    private CardRanks cardRanks;

    public CardsPower(CardSuits cardSuits, CardRanks cardRanks) {
        this.cardSuits = cardSuits;
        this.cardRanks = cardRanks;
    }

    public int calculatePower(CardSuits cardSuits,CardRanks cardRanks){
        return cardSuits.getSuitPower() + cardRanks.getRankPower();
    }
}
