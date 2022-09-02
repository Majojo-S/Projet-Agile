package Menu;

import java.io.IOException;
import java.util.Scanner;

import BlackJack.Player;



public class Menu {

	private static Scanner userInput = new Scanner(System.in);
	//private static AllPlayer all= new AllPlayer();
	private static Player p1;

	private static void clear(){
		for (int i = 0; i < 10; i++) {
			System.out.println("\n");
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
	
	private static void exitMenu() {
		System.out.println("Merci d'avoir joué !");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	private static void playMenu() throws IOException, InterruptedException {
		boolean exit = false;
		String input;
		while(!exit) {
			clear();
			System.out.print("╔━╤━━━━━━━━━━━━╗\n"
					+"┃1┃ Newplayer  ┃\n"
					+"╠═╬════════════╣\n"
					+"┃2┃   Quit     ┃\n"
					+"╚═╧════════════╝\n"
					+"               \n"
					+"Make your choice : ");
			input = userInput.nextLine();
			clear();

			switch (input) {
			case "1":

				System.out.println(" Bienvenue dans Royal Crous \n"
						+ "Quelle est ton prénom ?  ");

				String nom= userInput.nextLine();

				System.out.println(nom);

				p1=new Player(100,nom,1);


				exit = false;
				break;

			case "2":

				exit = true;
				break;
			default:
				break;
			}
		}
	}
	public static void main(String[] args) throws IOException, InterruptedException {
		mainMenu();
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
		
}
