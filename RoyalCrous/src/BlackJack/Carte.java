package BlackJack;

public class Carte {
	private Rank rank;
	private Color color;
	
	Carte(Rank rank, Color color) {
		this.rank = rank;
		this.color = color;
	}
	
	Rank getRank() {
		return this.rank;
	}
	
	Color getColor() {
		return this.color;
	}
	
	public String toString() {
		return("La carte est : " + getRank() + " de " + getColor());
	}
	
}
