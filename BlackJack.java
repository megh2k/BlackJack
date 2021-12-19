package blackJackmodule;

import java.util.Scanner;

public class BlackJack {
	Scanner scan = new Scanner(System.in);

	private Player[] storeNames;
	private int nop;

	public BlackJack() {
		this.nop = 0;
		this.storeNames = new Player[4];
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

	public String checkCommand(String command) {

		boolean flag = command.equals("hit") || command.equals("stand");


		while(!flag) {		//if command is not Hit in the 1st call, ask again 

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

		return command;

	}

	//	public boolean checkInput(String s) {		//get a valid input from the user
	//		if(s.equals("hit") || s.equals("stand")) {
	//			return true;
	//		}
	//		else {
	//			System.out.println("Invalid Input");
	//			System.out.println("Hit or Stand: ");
	//			s = scan.next().toLowerCase();
	//			return checkInput(s);
	//			
	//		}
	//	}

	public String finalReport() {	

		Player[] temp = new Player[this.nop];		//all players that entered the game

		for(int i=0; i<this.nop; i++) {
			temp[i] = this.storeNames[i];
		}

		int[] scores = new int[temp.length];

		for(int i=0; i<temp.length; i++) {
			scores[i] = temp[i].getScore();
		}
		String winners = "";

		int tempInt = 0;

		for (int i = 0; i <  temp.length - 1 ; i++) {
			for (int j = 0; j < temp.length - i - 1; j++) {
				if (scores[j] < scores[j+1]) 
				{
					tempInt = scores[j];
					scores[j] = scores[j+1];
					scores[j+1] = tempInt;
				}
			}
		}
		winners = "The winners are: ";
		
		for(int i=0; i<temp.length; i++) {
			if(temp[i].getScore() == scores[0]) {
				winners += temp[i].getName() + " ";
			}
		}

		return winners;
	}

	public String checkBj() {

		Player[] temp = new Player[this.nop];

		for(int i=0; i<this.nop; i++) {
			temp[i] = this.storeNames[i];
		}

		String name = "";
		String finalInput = "";
		int nobj = 0;
		int nobust = 0;

		for(int i=0; i<this.nop; i++) {
			if(temp[i].getUpdate().equals("BlackJack")) {
				nobj++;
			}
			else if(temp[i].getUpdate().equals("Bust")) {
				nobust++;
			}
		}

		finalInput = String.format("There are %d players who has BlackJack. \n",nobj);
		if(nobj != 0) {
			finalInput += "Players are : ";
		}

		for(int i=0; i<this.nop; i++) {

			if(temp[i].getUpdate().equals("BlackJack")) {
				name += temp[i].getName() + " ";
			}
		}
		finalInput += name +"\n";
		name = "";

		finalInput += String.format("There are %d players who got bust. \n",nobust);
		if(nobust != 0) {
			finalInput += "Players are : ";
		}

		for(int i=0; i<this.nop; i++) {

			if(temp[i].getUpdate().equals("Bust")) {
				name += temp[i].getName() + " ";		
			}

		}
		finalInput += name + "\n";
		name = "";



		return finalInput;
	}

}
