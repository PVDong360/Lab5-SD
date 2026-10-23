package flyWeight;

public class EagerCardFactory {
    private final Card[] cards = new Card[52];

    public EagerCardFactory() {
        for (Suit s : Suit.values()) {
            for (Rank r : Rank.values()) {
                cards[index(s, r)] = new Card(r, s);
            }
        }
    }

    public Card getCard(Suit suit, Rank rank) {
        return cards[index(suit, rank)];
    }

    private static int index(Suit s, Rank r) {
        return s.ordinal() * 13 + r.ordinal();
    }
}
