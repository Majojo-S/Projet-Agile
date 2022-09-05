package Menu;


import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import BlackJack.Player;
import BlackJack.Players;
import BlackJack.Roulette;
import BlackJack.RoyalCrous;





public class Menu {
	private static Players players= new Players();
	private static Player p1;





	private static Scanner userInput = new Scanner(System.in);




	public static void main(String[] args) throws IOException{
		titleMenu();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
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
			}	
			
			case "2":{
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
					+"┃2┃ Roulette   ┃\n"
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

	private static void titleMenu() {
		System.out.println(" |  __ \\                 | |  / ____|                    \n" + 
				" | |__) |___  _   _  __ _| | | |     _ __ ___  _   _ ___ \n" + 
				" |  _  // _ \\| | | |/ _` | | | |    | '__/ _ \\| | | / __|\n" + 
				" | | \\ \\ (_) | |_| | (_| | | | |____| | | (_) | |_| \\__ \\\n" + 
				" |_|  \\_\\___/ \\__, |\\__,_|_|  \\_____|_|  \\___/ \\__,_|___/\n" + 
				"               __/ |                                     \n" + 
				"              |___/                                   ");
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
					+"╠═╬════════════╣\n"
					+"┃4┃ Back       ┃\n"
					+"╚═╧════════════╝\n"
					+"               \n"
					+"Faites un choix : ");
			input = userInput.nextLine();
			clear();

			switch (input) {
			case "1":

				System.err.println("Bienvenue dans Royal Crous \n"
						+ "Quelle est ton prénom ?  ");

				String nom= userInput.nextLine();

				p1=new Player(100,nom,1);

				init(p1);
				
				while(!players.addPlayer(p1)) {
					nom= userInput.nextLine();
				}
				System.out.println(players);
				System.out.println(nom);

				

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
		for (int i = 0; i < 10; i++) {
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
			RoyalCrous.start(p1, players);
			players.updateTxt();
			LoadingMenu();
			break;
		case "2":
			clear();
			Roulette roulette = new Roulette();
			roulette.start();
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

	private static void init(Player player){
		Map<Integer,Integer> solde = new HashMap<>();
		solde.put(1, 100);
		solde.put(2, 200);
		solde.put(3, 300);
		solde.put(4, 400);
		solde.put(5, 500);
		solde.put(6, 600);

		Random random = new Random();
		int echelon = random.nextInt(6) + 1;
		int bourse = solde.get(echelon);

		p1.setEchelon(echelon);
		p1.setBourse(bourse);
		System.out.println(p1);
		
		System.out.println("\nLe crous vous a attribué l'échelon " + echelon + " \nVotre bourse s'élève à " + bourse);  
	}

}
