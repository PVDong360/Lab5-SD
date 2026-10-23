package Model;


public class GameModel {
	 private static final GameModel INSTANCE = new GameModel();

	    private Deck deck;

	    private GameModel() { }

	    public static GameModel getInstance() {
	        return INSTANCE;
	    }

	    public void newGame() {
	        deck = new Deck();
	    }

	    public Deck getDeck() { return deck; }
	}
