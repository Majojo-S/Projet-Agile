package BlackJack;

public class Card {
	private Rank rank;
	private Color color;
	
	Card(Rank rank, Color color) {
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
