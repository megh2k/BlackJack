package blackJackmodule;

import java.util.List;

public class Player {
	private String name;
	private deck newDeck;
	private Cards newCard;
	private String str;
	private int balance;
	
	public Player(String s) {
		this.name =s;
		deck d = new deck();
		Cards c = new Cards();
		this.newCard = c;
		this.newDeck = d;
		this.str = "";
	}

	public String getBalance() {
		return String.format("$%d", this.balance);
	}

	public deck getDeck() {
		return this.newDeck;
	}
	
	public void createDeck() {
		this.newDeck.createDeck();
	}

	public String getName() {
		return this.name;
	}

	public String getUpdate() {
		return this.str;
	}
	public void setUpdate(String s) {
		this.str = s;
	}

	public void updateString(String s) {
		this.str = s;
	}

	public int getScore() {
		return this.newCard.getScore();
	}
	
	public String[] getUsedCards() {
		return this.newCard.getUsedCards();
	}
	
	public void setScore() {
		this.newCard.setScore();
	}
	
	public String getCard() {
		return this.newCard.getCard();
	}
	
	public int getValue(String numcard){
		
		return this.newCard.getValue(numcard);
	}
	
	public void addCard(String s) {
		this.newCard.addCard(s);
	}
	
	public List<String> getremainingCards(){
		return deck.getFinalDeck();
	}
	













}
