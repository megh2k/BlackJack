package blackJackmodule;

import java.util.*;

public class Cards {

	private int value;
	private String[] usedCards;
	private String card;
	static int noc;
	private int score;

	Random rand = new Random();
	Scanner scan = new Scanner(System.in);

	public Cards() {
		Cards.noc =0;
		usedCards = new String[52];
	}
	
	public String getCard() {
		this.card = deck.finalDeck.get(noc);
		return this.card;
	}

	public void addCard(String s) {
		this.usedCards[Cards.noc] = s;
		Cards.noc++;
	}

	public void removeCard(String s) {
		deck.finalDeck.remove(s);
	}

	public String[] getUsedCards() {

		String[] newC = new String[Cards.noc];
		for(int i=0; i<Cards.noc; i++) {
			newC[i] = this.usedCards[i];
		}
		return newC;
	}

	public int getNumberOfCards() {
		return Cards.noc;
	}


	public int getValue(String numberedCard) {

		if(this.card.contains("2")){
			value = 2;
		}
		else if(this.card.contains("3")){
			value = 3;
		}
		else if(this.card.contains("4")){
			value = 4;
		}
		else if(this.card.contains("5")){
			value = 5;
		}
		else if(this.card.contains("6")){
			value = 6;
		}
		else if(this.card.contains("7")){
			value = 7;
		}
		else if(this.card.contains("8")){
			value = 8;
		}
		else if(this.card.contains("9")){
			value = 9;
		}
		else if(this.card.contains("10")){
			value = 10;
		}
		else if(this.card.contains("Jack")){
			value = 10;
		}
		else if(this.card.contains("Queen")){
			value = 10;
		}
		else if(this.card.contains("King")){
			value = 10;
		}
		
		else {
			System.out.print("Drawn card is an Ace. Value should be 1 or 11? ");
						value = scan.nextInt();
		}
		
		this.score +=value;
		
		return value;
	}

	public int getScore() {
		
		return this.score;
	}
	
	public void setScore() {
		this.score = 0;
	}

	@Override
	public String toString() {
		return "Drawn card is "+this.card; 
	}
}
