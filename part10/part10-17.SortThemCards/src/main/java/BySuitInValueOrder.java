import java.util.Comparator;

public class BySuitInValueOrder implements Comparator<Card> {
    
    @Override
    public int compare(Card c1, Card c2) {
        // First after colour, than after value

        if (c1.getSuit() == c2.getSuit()) {
            return Integer.compare(c1.getValue(), c2.getValue());
        } else {
            return c1.getSuit().compareTo(c2.getSuit());
        }
    }
}
