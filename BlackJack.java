package blackJackmodule;

public class BlackJack {

	private Player[] storeNames;
	private int nop;

	public BlackJack(Player p) {
		this.nop = 0;
		this.storeNames = new Player[2];
	}

	public void addPlayer(Player p) {
		this.storeNames[this.nop] = p;
		this.nop++;
	}

	public Player[] getPlayer() {
		Player[] temp = new Player[this.nop];

		for(int i=0; i<this.nop; i++) {
			temp[i] = this.storeNames[i];
		}
		return temp;
	}

}
