package BlackJack;

enum Rank {

	DEUX(2), TROIS(3), QUATRE(4), CINQ(5), SIX(6), SEPT(7), HUIT(8), NEUF(9), VALET(10), ROI(13), DAME(12), ACE(1);
	
	
	int points;
	Rank(int i) {
		points = i;
	}
	
}