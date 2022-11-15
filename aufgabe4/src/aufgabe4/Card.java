package aufgabe4;

import java.util.Arrays;
import java.util.Objects;

/**
 *
 * @author Julian Klimek
 * @since 18.04.22
 */

public abstract class Card<T> {
    //private int size;
    //private Element<T> fqTable[]; // oder nur <T> ??
    //private final int DEFAULT_SIZE = 100;

    public enum Suit {KARO, HEARTS, PIQUE, KROSS};
    public enum Rank {SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING, ACE};

    public Suit getSuit() {
        return this.suit;
    }

    public Rank getRank() {
        return this.rank;
    }

    public Suit suit;
    public Rank rank;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card<?> card = (Card<?>) o;
        return suit == card.suit && rank == card.rank;
    }

    @Override
    public int hashCode() {
        return Objects.hash(suit, rank);
    }

    @Override
    public String toString() {
        return "Card{" +
                "suit=" + suit +
                ", rank=" + rank +
                '}';
    }
}
