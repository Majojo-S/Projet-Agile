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
	
	public String toStringJoueur() {
		return("Vous avez tiré un " + getRank() + " de " + getColor()+ "\n");
	}
	
	public String ToStringOrdi() {
		return("le croupier à tiré un "+ getRank() + " de " + getColor()+ "\n");
	}
	
}
