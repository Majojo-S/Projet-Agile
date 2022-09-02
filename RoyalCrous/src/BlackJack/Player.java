package BlackJack;
import java.util.ArrayList;
import java.util.List;

public class Player {
	/**
	 * 
	 */
	int bourse;
	String name;
	int echelon;
	List<Card> main=new ArrayList<Card>();
	
		
		/**
		 * @param score
		 * @param name
		 * @param echelon
		 */
		public Player(int score, String name, int echelon) {
		super();
		this.bourse = score;
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
	
	
}
