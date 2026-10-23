package Model;

import java.util.ArrayList;
import java.util.List;

import flyWeight.Card;
import flyWeight.LazyCardFactory;
import flyWeight.Rank;
import flyWeight.Suit;

public class Deck {
    private static final LazyCardFactory FACTORY = new LazyCardFactory();

    private final List<Card> cards = new ArrayList<>();

    public Deck() {
        for (Suit s : Suit.values()) {
            for (Rank r : Rank.values()) {
                cards.add(FACTORY.getCard(s, r));
            }
        }
    }

    public int size() { return cards.size(); }
    public Card get(int i) { return cards.get(i); }
}
