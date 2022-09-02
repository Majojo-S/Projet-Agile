package Menu;


import java.io.IOException;
import java.util.Collections;
import java.util.Scanner;

import BlackJack.Game;
import BlackJack.Player;
import BlackJack.Players;
import BlackJack.RoyalCrous;





public class Menu {
	private static Players players= new Players();
	private static Player p1;
	




	private static Scanner userInput = new Scanner(System.in);




	public static void main(String[] args) throws IOException{
		players.loadPlayers();
		boolean exit = false;
		String input;
		while(!exit) {
			clear();
			mainMenu();
			input = userInput.nextLine();
			clear();
			switch (input) {
			case "1": {
				try {
					playMenu();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				break;
			}case "2":{
				exitMenu();
				exit = true;
				break;
			}
			default:
				break;
			}
		}
		userInput.close();
	}



	private static void exitMenu() {
		System.out.println("Merci d'avoir joué !");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private static void LoadingMenu() throws InterruptedException {
		System.out.println("Loading game...");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
		}
		boolean exit = false;
		String input;
		while(!exit) {
			clear();

			String [] best=new String [5];
			for (int i = 0; i < best.length; i++) {
				best[i]="n°"+Integer.sum(i, 1)+" no one";
			}
			Collections.sort(players.getPlayers());
			for (int i = 0; i < players.getPlayers().size(); i++) {
				best[i]="n°"+Integer.sum(i, 1)+" "+players.getPlayers().get(i).toString();
				if(i==4)break;
			}


			System.out.print("╔━╤━━━━━━━━━━━━╗\n"
					+"┃1┃ BlackJack  ┃\n"
					+"╠═╬════════════╣\n"
					+"┃2┃ Back       ┃\n"
					+"╚═╧════════════╝\n"
					+"               \n"
					+"Faites un choix : ");
			input = userInput.nextLine();
			play(input);
			exit=true;


		}
	}


	private static void playMenu() throws IOException, InterruptedException{
		boolean exit = false;
		String input;
		while(!exit) {
			clear();
			System.out.print("╔━╤━━━━━━━━━━━━╗\n"
					+"┃1┃ Newplayer  ┃\n"
					+"╠━╫━━━━━━━━━━━━╣\n"
					+"┃2┃ LoadPlayers┃\n"
					+"╠═╬════════════╣\n"
					+"┃3┃ Ranking    ┃\n"
					+"╠═╧════════════╣\n"
					+"┃4┃ Back       ┃\n"
					+"╚═╧════════════╝\n"
					+"               \n"
					+"Faites un choix : ");
			input = userInput.nextLine();
			clear();

			switch (input) {
			case "1":

				System.err.println(" Bienvenue dans Royal Crous \n"
						+ "Quelle est ton prénom ?  ");

				String nom= userInput.nextLine();


				while(!players.addPlayer(nom)) {
					nom= userInput.nextLine();

				}
				System.out.println(nom);

				p1=new Player(1000,nom,1);

				play();
				exit = false;
				break;
			case "2":
				System.err.println(" Mais qui revoila ici dans le meilleur jeu ,\n"
						+ "euh rappel moi ton nom de joueur : ");
				String nomLoad= userInput.nextLine();


				try {
					if(players.existingName(nomLoad)) {
						System.out.println("cool de te revoir "+nomLoad);
						p1=players.loadPlayer(nomLoad);
					}
					else { System.out.println("mais je ne t'ai jamais vu ici "+nomLoad+"  !");
					try {
						Thread.sleep(3000);
					} catch (Exception e) {
					}
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				play();

				exit = true;
				break;
			
			case "3":

				rankingMenu();
				break;
			
			case "4":

				exit = true;
				break;
			default:
				break;
			}
		}
	}





	/*@SuppressWarnings("unused")
	private static String askName(String string) {
		System.out.print(string+" enter your name : ");
		return userInput.nextLine();
	}*/

	private static void mainMenu() {
		System.out.print("    ╔━╤━━━━━━━━━━━╗\n"
				+"    ┃1┃ Play      ┃\n"
				+"    ╠━╫━━━━━━━━━━━╣\n"
				+"    ┃2┃ Exit      ┃\n"
				+"    ╚═╧═══════════╝\n"
				+"                   \n"
				+"Make your choice : ");
	}

	private static void clear(){
		for (int i = 0; i < 14; i++) {
			System.out.println("\n");
		}
	}



	private static void play( ) throws InterruptedException {
		LoadingMenu();


	}
	private static void play(String choix ) throws InterruptedException {
		switch (choix) {
		case "1":
			clear();
			Game a= new Game();
			String[] args = null;
			RoyalCrous.main(args);
			players.updateTxt();

			LoadingMenu();
			break;
		default:
			break;
		}


	}

	private static void rankingMenu() {
		String [] best=new String [5];
		for (int i = 0; i < best.length; i++) {
			best[i]="n°"+Integer.sum(i, 1)+" no one";
		}
		Collections.sort(players.getPlayers());
		for (int i = 0; i < players.getPlayers().size(); i++) {
			best[i]="n°"+Integer.sum(i, 1)+" "+players.getPlayers().get(i).toString();
			if(i==4)break;
		}
		System.out.println(best[0]
				+"\n"+best[1]
				+"\n"+best[2]
				+"\n"+best[3]
				+"\n"+best[4]);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	

}
