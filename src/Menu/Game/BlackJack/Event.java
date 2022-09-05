package Menu.Game.BlackJack;

import java.util.Random;

public class Event {
	private int timer = 0;
	
	public Event(int timer) {
		this.timer = timer;
	}
	
	public int getTimer() {
		return this.timer;
	}
	
	public void setTimer(int timer) {
		this.timer = timer;
	}
	
	public void Loyer(Player p) {
		if(timer == 30) {
			System.out.println("Il est temps de payer ses factures !");
			if(p.echelon < 3) {
				p.setBourse(p.getBourse() - 100);
			} else {
				p.setBourse(p.getBourse() - 250);
			}
		}
	}
	
	public void Bourses(Player p) {
		if(timer == 31) {
			System.out.println("Voila votre Bourse du mois !");
			p.setBourse(p.getBourse() + 250);
		}
	}
	
	public void RandomEvent(RandomTypeEvent rte) {
		System.out.println("C'est l'heure de l'évenement mystère !!");
		if(rte.equals(RandomTypeEvent.PH));
	}
	
	
	
	public RandomTypeEvent getRandEvent() {
		Random rand = new Random();
		if(rand.nextInt(50) == 0) {
			return RandomTypeEvent.PH;
		} else if(rand.nextInt(50) == 1){
			return RandomTypeEvent.BAR;
		}else if(rand.nextInt(50) == 2){
			return RandomTypeEvent.LUNCH;
		}else if(rand.nextInt(50) == 3){
			return RandomTypeEvent.SUP;
		}else if(rand.nextInt(50) == 4){
			return RandomTypeEvent.WORK;
		}else if(rand.nextInt(50) == 5){
			return RandomTypeEvent.AMENDE;
		}else if(rand.nextInt(50) == 6){
			return RandomTypeEvent.ABSENT;
		} else if(rand.nextInt(50) == 7) {
			return RandomTypeEvent.ECHELON;
		}else {
			return null;
		}
		
	}
	
}
