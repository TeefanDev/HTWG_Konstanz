package aufgabe4;

import java.util.Random;

/**
 *
 * @author Julian Klimek
 * @since 11.04.22
 */

public class BlackCard extends Card{
    private Random rand = new Random();

    public BlackCard(Suit suit, Rank rank) {
        if (suit == Suit.HEARTS || suit == Suit.KARO) {
            throw new IllegalArgumentException();
        }
        this.suit = suit;
        this.rank = rank;
    }

    public BlackCard() {
        int s = rand.nextInt(2);
        int r = rand.nextInt(8);

        if (s == 0) {
            suit = Suit.KROSS;
        } else {
            suit = Suit.PIQUE;
        }
        rank = Rank.values()[r];
    }
}
