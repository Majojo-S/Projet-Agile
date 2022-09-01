package BlackJack;
import java.util.List;

public class Joueur {
	/**
	 * 
	 */
	int bourse;
	String name;
	int echelon;
	/*List<Carte> main=new Arraylist<Carte>;**/
	
		
		/**
		 * @param score
		 * @param name
		 * @param echelon
		 */
		public Joueur(int score, String name, int echelon) {
		super();
		this.bourse = score;
		this.name = name;
		this.echelon = echelon;
	}


	/**
	 * @return
	 */
	public int getScore() {
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
