import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Hand  implements Comparable<Hand> {

    private List<Card> cards;

    public Hand() {
        this.cards = new ArrayList<>();
    }

    public void add(Card card) {
        cards.add(card);
    }

    public void print() {
        for (Card c : cards) {
            System.out.println(c);
        }
    }

    public void sort() {
        Collections.sort(cards);
    }

    @Override
    public int compareTo(Hand other) {
        int thisSum = 0;

        for (Card c : this.cards) {
            thisSum += c.getValue();
        }

        int otherSum = 0;
        for (Card c : other.cards) {
            otherSum += c.getValue();
        }

        return Integer.compare(thisSum, otherSum);
    }

    public void sortBySuit() {
        Collections.sort(cards, new BySuitInValueOrder());
    }
}
