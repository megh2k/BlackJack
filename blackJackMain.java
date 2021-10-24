package blackJackmodule;
import java.util.*;

public class blackJackMain {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		String command = null;// input string given by the user
		String player = null;//player name
		String update = null;// return string
		System.out.println("Welcome to BlackJack \n\n");


		System.out.print("Enter player name: ");
		player = scan.next();

//		System.out.print("Type Hit to start the game: ");
//		command = scan.next().toLowerCase();

		deck d1 = new deck();
		Cards c1 = new Cards();
		Player p1 = new Player(player, d1, c1);
		BlackJack bj = new BlackJack(p1);
		p1.getDeck().createDeck();

		for(int i=0; i<2; i++) {
			
			bj.addPlayer(p1);

			System.out.print("Type Hit to start the game: ");
			command = scan.next().toLowerCase();		
			boolean flag = command.equals("hit") || command.equals("stand");
			
			
			while(!flag) {
				
				try {
					throw new NonValidStringValue("Invalid Input");
				}

				catch(NonValidStringValue e) {
					System.out.println("Invalid Input");
				}

				finally{
					System.out.println("Hit or Stand: ");
					command = scan.next().toLowerCase();
					flag = command.equals("hit") || command.equals("stand");
				}
			}

			while(command.equals("hit")) {

				System.out.println("Card drawn: "+ p1.getCards().getCard());
				p1.getCards().getValue(p1.getCards().getCard());
				p1.getCards().addCard(p1.getCards().getCard());


				if(p1.getCards().getScore() ==21) {
					System.out.println(p1.getName() +" got a blackJack!");
					update = "BlackJack";
					break;
				}

				else if(p1.getCards().getScore()>21) {
					System.out.println(p1.getName() +" got bust!");
					update = "Bust";
					p1.getCards().setScore();
					System.out.println("Score is: " +p1.getCards().getScore() +"\n");
					break;
				}

				System.out.println("Score is: " +p1.getCards().getScore() +"\n");

				System.out.println("Hit or Stand: ");


				command = scan.next().toLowerCase();

				flag = command.equals("hit") || command.equals("stand");
				while(!flag) {
					try {
						throw new NonValidStringValue("Invalid Input");
					}

					catch(NonValidStringValue e) {
						System.out.println("Invalid Input");
					}

					finally{
						System.out.println("Hit or Stand: ");
						command = scan.next().toLowerCase();
						flag = command.equals("hit") || command.equals("stand");

					}
				}


				if(command.equals("stand")) {
					System.out.println("Score is: " +p1.getCards().getScore());
					System.out.println("Used cards: "+Arrays.toString(c1.getUsedCards()) +"\n");
					p1.updateString(update);

				}
				System.out.println();

			}
			if(i==0) {
				System.out.println("\n Dealer playing");
				d1 = new deck();
				c1 = new Cards();
				p1 = new Player("dealer", d1, c1);
				player = "Dealer";		

				p1.getDeck().createDeck();

			}

		}



		if(bj.getPlayer()[0].getCards().getScore()>bj.getPlayer()[1].getCards().getScore()) {

			if(bj.getPlayer()[0].getUpdate() == "BlackJack") {
				System.out.println("Player " +bj.getPlayer()[0].getName() +" has won because they got a BlackJack!");
			}
			else {
				System.out.println("Player " +bj.getPlayer()[0].getName() +" has won with a score of " +bj.getPlayer()[0].getCards().getScore());
			}
		}
		else if(bj.getPlayer()[0].getCards().getScore()<bj.getPlayer()[1].getCards().getScore()) {

			if(bj.getPlayer()[1].getUpdate() == "BlackJack") {
				System.out.println("Dealer has won because they got a BlackJack!");
			}

			else {
				System.out.println("Dealer has won with a score of " +bj.getPlayer()[1].getCards().getScore());
			}
		}
		else {
			System.out.println("Both individuals had same score of "+bj.getPlayer()[0].getCards().getScore() +". Tied round");
		}



		scan.close();
	}

}
