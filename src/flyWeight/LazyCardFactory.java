package flyWeight;

public class LazyCardFactory {
    private final Card[] cards = new Card[52];

    public Card getCard(Suit suit, Rank rank) {
        int i = suit.ordinal() * 13 + rank.ordinal();
        if (cards[i] == null) {
            cards[i] = new Card(rank, suit);
        }
        return cards[i];
    }
}
