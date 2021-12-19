package blackJackmodule;
import java.util.*;

public class blackJackMain {

	public static void main(String[] args){
		BlackJack bj = new BlackJack();
		Scanner scan = new Scanner(System.in);
		String command = null;// input string given by the user
		String player = null;//player name
		String update = null;// return string
		int nop = 0;

		System.out.println("Welcome to BlackJack \n");
		System.out.println("Enter the number of players(max 3):");

		boolean flag = false;
		while(!flag) {
			try {
				nop = scan.nextInt();
				flag = true;
			}

			catch(Exception e){
				System.out.println("Invalid input: " +e);
				System.out.println("Please enter valid input: ");
				scan.next();
			}

		}

		for(int i=0; i<=nop; i++) {		//playing the game and storing the data
			update = "";

			if(i==nop) {		//if its time for dealer
				System.out.println("\n Dealer playing");
				player = "Dealer";		
			}
			else {
				System.out.print("Enter player name: ");
				player = scan.next();
			}

			Player p1 = new Player(player);
			p1.createDeck();
			bj.addPlayer(p1);


			System.out.print("Type Hit to start the game: ");
			command = bj.checkCommand(scan.next().toLowerCase());

			while(command.equals("hit")) {		//start when input is correct

				System.out.println("Card drawn: "+ p1.getCard());

				p1.getValue(p1.getCard());		//value of Ace 1 or 11
				p1.addCard(p1.getCard());

				if(p1.getScore() ==21) {		//if player got blackjack
					System.out.println(p1.getName() +" got a blackJack!");
					update = "BlackJack";
					p1.setUpdate("BlackJack");
					//break;
				}

				else if(p1.getScore()>21) {		//if player is bust
					System.out.println(p1.getName() +" got bust!");
					p1.setScore();
					update = "Bust";
					p1.setUpdate("Bust");
					//break;
				}

				System.out.println("Score is: " +p1.getScore() +"\n");
				if(update.equals("BlackJack") || update.equals("Bust")) {
					System.out.println("Used cards: "+Arrays.toString(p1.getUsedCards()) +"\n");
					break;
				}
				System.out.println("Hit or Stand: ");


				command = bj.checkCommand(scan.next().toLowerCase());

				if(command.equals("stand")) {
					System.out.println("Score is: " +p1.getScore());
					System.out.println("Used cards: "+Arrays.toString(p1.getUsedCards()) +"\n");
					p1.updateString(update);

				}
				System.out.println();
			}
		}

		//comparing the data and declaring the winners

		System.out.println(bj.checkBj());
		System.out.println(bj.finalReport());


		scan.close();
	}

}
