package blackJackmodule;

public class Player {
	private String name;
	private deck newDeck;
	private Cards newCard;
	private String str;
	private int balance;

	public Player(String s, deck d, Cards c) {
		this.name = s;
		this.newDeck = d;
		this.newCard = c;
		this.str = "";
		this.balance = 20;

	}

	public void makeBet(int x) throws BalanceTooLow {

		if(this.balance-x<0) {
			throw new BalanceTooLow("Balance too low");
		}
		else {
			this.balance -= x;
		}
	}


	public String getBalance() {
		return String.format("$%d", this.balance);
	}


	public deck getDeck() {
		return this.newDeck;
	}

	public Cards getCards() {
		return this.newCard;
	}

	public String getName() {
		return this.name;
	}

	public String getUpdate() {
		return this.str;
	}

	public void updateString(String s) {
		this.str = s;
	}















}
