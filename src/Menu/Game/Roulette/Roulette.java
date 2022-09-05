package Menu.Game.Roulette;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import Menu.Game.Game;
import Menu.Game.BlackJack.Player;
import Menu.Game.BlackJack.Players;
import Menu.Game.BlackJack.UnvalidBet;

public class Roulette implements Game{

	//TODO : mettre 0 --> vert  
	// 0-36
	
	public Map<Integer,String>roulette;

	//Couleurs
	public static final String ANSI_RESET = "\u001B[0m";
	//public static final String ANSI_BLACK_BG = "\u001B[40m";
	public static final String ANSI_BLACK_BG = "\033[47m"; // WHITE (pour black)
	public static final String ANSI_RED_BG = "\u001B[41m";
	public static final String ANSI_GREEN_BG = "\033[42m";

	private static Scanner userInput = new Scanner(System.in);

	public Roulette(){
		roulette=new HashMap<Integer, String>();

	}

	// Pairs = Noir ; Impairs = Rouge
	void remplir() {
		for(int i=1;i<37;i++) {
			if(i%2==0) {
				roulette.put(i, "N");
			}else {roulette.put(i,"R");
			}
		}
	}	

	public void afficherRoulette(){
			int lineReturn = 0 ;
			for(Map.Entry<Integer, String> r : roulette.entrySet()){
				if(lineReturn > 2){
					System.out.println();
					lineReturn = 0;
				}
				
				if(r.getValue().equals("N")){
					if(r.getKey() < 10){
						System.out.print(ANSI_BLACK_BG + "0" + ANSI_RESET);
					}
					System.out.print(ANSI_BLACK_BG + r.getKey() + ANSI_RESET + "   ");
				}else if (r.getValue().equals("R")){
					if(r.getKey() < 10){
						System.out.print(ANSI_RED_BG + "0" + ANSI_RESET);
					}
					System.out.print(ANSI_RED_BG + r.getKey() + ANSI_RESET + "   ");
				}
				lineReturn ++;
			}
		
	}

	


	int launch() {
		Random r=new Random();
		int rslt=r.nextInt(37)+1;
		return rslt;
	}

	public void start(Player player , Players players) throws UnvalidBet {

		//Affichage roulette 
		System.out.println("\nRoulette");
		remplir();
		afficherRoulette();
		System.out.println("\nVous avez " + player.getBourse() + "jetons");

		//Mise
		Scanner scanner = new Scanner(System.in);


		int bet = 0;
		boolean correct = false;
        	while(!correct) {
				try {
					bet = player.bet(scanner);
					correct = true;
				} catch (UnvalidBet e1) {
					System.out.println(e1.getMessage());	
				}
			}
		int result = launch();
		System.out.println("\n1 choisir un nombre, 2 pour une couleur N ou R");
		String input = userInput.nextLine();
		switch (input) {
		case "1": {
			System.out.println("\nChoisis un nombre\n");
			input = userInput.nextLine();
			int entree = Integer.valueOf(input);
			if(resultatnombre(result, entree)){
				afficherResultatNb(result);
				System.out.println("\nVous avez gagné, le nombre était : " + roulette.get(entree));
				this.winByNumber(player, bet);

			}else {
				afficherResultatNb(result);
				System.out.println("\nVous avez perdu, le nombre était : " + result);
				this.lost(player, bet);
			}
			break;
		}
		case "2": {
			System.out.println("\nChoisis une couleur\n");
			input = userInput.nextLine();
			String entree = input;
			if(resultatcouleur(roulette.get(result), entree)){
				afficherResultatCouleur(result);
				try {
					TimeUnit.SECONDS.sleep(2);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("\nVous avez gagné, la couleur était : " + roulette.get(result));
				this.winByColor(player, bet);
			}else {
				afficherResultatCouleur(result);
				try {
					TimeUnit.SECONDS.sleep(2);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("\nVous avez perdu, la couleur était : " + roulette.get(result));
				this.lost(player, bet);
			}
			break;
		}
		}
		
	}

	String getColor(int key) {
		return roulette.get(key);

	}
	
	Boolean resultatnombre(int hasard,int entree) {
		return hasard==entree;

	}
	
	Boolean resultatcouleur(String color,String entree) {
		return color.equals(entree);
	}

	private void winByNumber(Player player, int bet){
		player.setBourse(player.getBourse() + bet * 36);
		System.out.println("`nVotre solde : " + player.getBourse());
	}

	private void winByColor(Player player, int bet){
		player.setBourse(player.getBourse() + bet);
		System.out.println("`nVotre solde : " + player.getBourse());
	}

	private void lost(Player player , int bet){
		player.setBourse(player.getBourse() - bet);
		System.out.println("`nVotre solde : " + player.getBourse());
	}

	private void afficherResultatCouleur(int result){
		Random random = new Random();
		int nb = random.nextInt(6) + 4 ;
		for(int i = 0 ; i < nb ; i++){
			int alea = random.nextInt(2);
			if(alea == 0){
				System.out.print(ANSI_BLACK_BG + " " + ANSI_RESET + "  ");
				try {
					TimeUnit.SECONDS.sleep(1);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else{
				System.out.print(ANSI_RED_BG + " " + ANSI_RESET + "  ");
				try {
					TimeUnit.SECONDS.sleep(1);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(getColor(result).equals("N")){
			System.out.print("  " + ANSI_BLACK_BG + " " + ANSI_RESET);
		}else{
			System.out.print("  " + ANSI_RED_BG + " " + ANSI_RESET);
		}

	}

	private void afficherResultatNb(int result){
		Random random = new Random();
		int nb = random.nextInt(6) + 4 ;
		for(int i = 0 ; i < nb ; i++){
			int alea = random.nextInt(37);
			if(alea == 0){
				System.out.print(" " + ANSI_GREEN_BG + alea + " " + ANSI_RESET);
			}
			if(alea % 2 == 0 && alea != 0){
				if(alea < 10){
					System.out.print(" " + ANSI_BLACK_BG + alea + " " + ANSI_RESET);
				}else{
					System.out.print(" " + ANSI_BLACK_BG + alea + ANSI_RESET);
				}
			}else{
				if(alea < 10){
					System.out.print(" " + ANSI_BLACK_BG + alea + " " + ANSI_RESET);
				}else{
				System.out.print(" " + ANSI_RED_BG + alea + ANSI_RESET);
				}
			}
				try {
					TimeUnit.SECONDS.sleep(1);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(result == 0){
				System.out.print("  " + ANSI_GREEN_BG + result + ANSI_RESET);
			}
			if(result%2 == 0 && result != 0){
				System.out.print("  " + ANSI_BLACK_BG + result + ANSI_RESET);
			}else{
				System.out.print("  " + ANSI_RED_BG + result + ANSI_RESET);
			}
		}
	
	

	public static void main(String[] args) {
		Roulette r = new Roulette();
		r.remplir();
		r.afficherRoulette();

		Player p = new Player("r");
		Players players = new Players();

		//r.start(p, players);
		
	}
}