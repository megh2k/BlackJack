package blackJackmodule;
import java.util.*;

public class deck {

	public static String[] Deck;
	public static HashSet<String> newDeck;
	public static ArrayList<String> newDeckList;
	public static ArrayList<String> finalDeck;
	private String[] suits = {"Club", "Diamonds", "Hearts", "Spades"};
	private String[] cards = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"}; 
	Random rand = new Random();


	public deck() {
		deck.Deck = new String[52];
		deck.newDeck = new HashSet<String>();

	}

	public void createDeck() {
		for(int j=0; j<this.suits.length; j++) {
			String suit1 = this.suits[j];

			for(int l =0; l<this.cards.length; l++) {
				String cardnum1 = this.cards[l];
				String card1 = String.format("%s of %s", cardnum1, suit1);
				deck.newDeck.add(card1);				
			}
		}
		deck.newDeckList = new ArrayList<String>(deck.newDeck);
		deck.finalDeck = new ArrayList<String>(deck.newDeckList);

		for(int i = 0; i<deck.newDeckList.size(); i++) {
			deck.finalDeck.set(i,null);
		}

		for(int i=0; i< deck.newDeckList.size(); i++) {
			int r = rand.nextInt(52);

			if(deck.finalDeck.get(r) ==null) {
				deck.finalDeck.set(r, deck.newDeckList.get(i));
			}
			else {
				i--;
			}
		}
	}


	public static List<String> getFinalDeck(){
		return deck.finalDeck;
	}

}
