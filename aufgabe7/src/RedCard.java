import java.util.Random;

/**
 *
 * @author Julian Klimek
 * @since 11.04.22
 */

public class RedCard extends Card{
    private Random rand = new Random();

    public RedCard(Suit suit, Rank rank) {
        if (suit == Suit.PIQUE || suit == Suit.KROSS) {
            throw new IllegalArgumentException();
        }
        this.suit = suit;
        this.rank = rank;
    }

    public RedCard() {
        int s = rand.nextInt(2);
        int r = rand.nextInt(8);

        if (s == 0) {
            suit = Suit.HEARTS;
        } else {
            suit = Suit.KARO;
        }
        rank = Rank.values()[r];
    }

    @Override
    public int compareTo(Card o) {

        if (this.getRank().ordinal() < o.getRank().ordinal()) {
            return -1;
        }
        else if (this.getRank().ordinal() == o.getRank().ordinal()) {
            return 0;
        }
        return 1;
    }
}
