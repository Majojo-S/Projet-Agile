package BlackJack;
import java.util.ArrayList;
import java.util.List;
import BlackJack.Card;

public class Player {
	/**
	 * 
	 */
	int bourse;
	String name;
	int echelon;
	List<Card> hand = new ArrayList<Card>();
	List<Card> croupier = new ArrayList<Card>();
		
		/**
		 * @param bourse
		 * @param name
		 * @param echelon
		 */
		public Player(int bourse, String name, int echelon) {
		super();
		this.bourse = bourse;
		this.name = name;
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
	
	public int totalOfHand() {
		int calcul = 0;
		for(int idx = 0; idx < this.hand.size(); idx ++) {
			calcul = calcul + hand.get(idx).getRank().points;
		}
		return calcul;
	}
	
	public int totalOfCroupier() {
		int calcul = 0;
		for(int idx = 0; idx < this.croupier.size(); idx ++) {
			calcul = calcul + croupier.get(idx).getRank().points;
		}
		return calcul;
	}

	
}
