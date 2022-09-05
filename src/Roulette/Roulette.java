package Roulette;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class Roulette {

	//TODO : mettre 0 --> vert  
	// 0-36
	
	public Map<Integer,String>roulette;

	//Couleurs
	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_BLACK_BG = "\u001B[40m";
	public static final String ANSI_RED_BG = "\u001B[41m";

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

	public void start() {
		System.out.println("\nRoulette");
		remplir();
		afficherRoulette();
		int result = launch();
		System.out.println("\n1 choisir un nombre, 2 pour une couleur N ou R");
		String input = userInput.nextLine();
		switch (input) {
		case "1": {
			System.out.println("\nChoisis un nombre\n");
			input = userInput.nextLine();
			int entree = Integer.valueOf(input);
			if(resultatnombre(result, entree)){
				System.out.println("Vous avez gagné, le nombre était : " + result);
			}else {
				System.out.println("Vous avez perdu, le nombre était : " + result);
			}
			break;
		}
		case "2": {
			System.out.println("\nChoisis une couleur\n");
			input = userInput.nextLine();
			String entree = input;
			if(resultatcouleur(roulette.get(result), entree)){
				System.out.println("Vous avez gagné, la couleur était : " + roulette.get(result));
			}else {
				System.out.println("Vous avez perdu, la couleur était : " + roulette.get(result));
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

	public static void main(String[] args) {
		Roulette r = new Roulette();
		r.remplir();
		r.afficherRoulette();
		
	}
}