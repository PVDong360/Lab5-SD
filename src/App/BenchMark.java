package App;

import flyWeight.Card;
import flyWeight.EagerCardFactory;
import flyWeight.LazyCardFactory;
import flyWeight.Rank;
import flyWeight.Suit;
import Model.GameModel;

public class BenchMark {
	  private static final int ROUNDS = 1_000_000;
	    private static final Suit[] SUITS = Suit.values();
	    private static final Rank[] RANKS = Rank.values();

	    private static long sink; 
	    private static long timeEager(int count) {
	        long start = System.currentTimeMillis();
	        for (int n = 0; n < ROUNDS; n++) {
	            EagerCardFactory f = new EagerCardFactory();
	            for (int i = 0; i < count; i++) {
	                sink += f.getCard(SUITS[i / 13], RANKS[i % 13]).hashCode();
	            }
	        }
	        return System.currentTimeMillis() - start;
	    }

	    private static long timeLazy(int count) {
	        long start = System.currentTimeMillis();
	        for (int n = 0; n < ROUNDS; n++) {
	            LazyCardFactory f = new LazyCardFactory();
	            for (int i = 0; i < count; i++) {
	                sink += f.getCard(SUITS[i / 13], RANKS[i % 13]).hashCode();
	            }
	        }
	        return System.currentTimeMillis() - start;
	    }

	    public static void main(String[] args) {
	        timeEager(52);
	        timeLazy(52);

	        System.out.println("So vong lap: " + ROUNDS);
	        System.out.println("--- Lay du 52 la ---");
	        System.out.println("Eager: " + timeEager(52) + " ms");
	        System.out.println("Lazy : " + timeLazy(52) + " ms");
	        System.out.println("--- Chi lay 5 la ---");
	        System.out.println("Eager: " + timeEager(5) + " ms");
	        System.out.println("Lazy : " + timeLazy(5) + " ms");
	        
	        LazyCardFactory f = new LazyCardFactory();
	        Card a = f.getCard(Suit.HEARTS, Rank.ACE);
	        Card b = f.getCard(Suit.HEARTS, Rank.ACE);
	        System.out.println("--- Kiem tra ---");
	        System.out.println("Cung 1 doi tuong Card: " + (a == b));

	        GameModel.getInstance().newGame();
	        System.out.println("Singleton: " + (GameModel.getInstance() == GameModel.getInstance()));
	        System.out.println("So la trong Deck: " + GameModel.getInstance().getDeck().size());
	    }
}
