package BlackJack;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import BlackJack.Card;

public class Player {
	/**
	 * 
	 */
	int bourse;
	String name;
	int echelon;
	List<Card> packet = new ArrayList<Card>();
	
	
	public Player(String name){
		this.name = name;
	}

	/**
	 * @param bourse
	 * @param name
	 * @param echelon
	 */
	public Player(int bourse, String name, int echelon) {
		this(name);
		this.bourse = bourse;
		this.echelon = echelon;
	}


	/**
	 * @return
	 */
	public int getBourse() {
		return bourse;
	}


	/**
	 * @return
	 */
	public String getName() {
		return name;
	}


	/**
	 * @return
	 */
	public int getEchelon() {
		return echelon;
	}


	/**
	 * @param score
	 */
	public void setScore(int score) {
		this.bourse = score;
	}

	//TODO : exception unvalid bet
	public int bet(){
		System.out.println("Entrez votre mise : ");
		Scanner sc = new Scanner(System.in);
		int coins = sc.nextInt();
		sc.close();
		return coins;
	}

	
}
