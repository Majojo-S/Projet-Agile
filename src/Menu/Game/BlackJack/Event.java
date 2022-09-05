package Menu.Game.BlackJack;

import java.util.Random;
import java.util.concurrent.TimeUnit;

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
			System.out.println("Il est temps de payer ses factures ! \\n");
			if(p.echelon < 3) {
				p.setBourse(p.getBourse() - 100);
			} else {
				p.setBourse(p.getBourse() - 250);
			}
		}
	}
	
	public void Bourses(Player p) {
		if(timer == 31) {
			System.out.println("Voila votre Bourse du mois ! \\n");
			p.setBourse(p.getBourse() + 250);
		}
	}
	
	public void RandomEvent(RandomTypeEvent rte, Player p) throws InterruptedException {
		int min = 50;
		int max = 300;
		Random rand = new Random();
		System.out.println("C'est l'heure de l'évenement mystère !! \\n");
		if(rte.equals(RandomTypeEvent.PH)) {
			p.setBourse(p.getBourse() + rand.nextInt((max - min)+1)-min);
			System.out.println("Vous recevez un virement de vos parents !" + rand.nextInt((max - min)+1) + "de crédits ps: remerciez les quand même \\n");
		} else if(rte.equals(RandomTypeEvent.WORK)) {
			System.out.println("Pour votre bon service, le CROUS vous octroie un salaire pour le travail réalisé ! + 150 crédits \\n");
		} else if(rte.equals(RandomTypeEvent.SUP)) {
			p.setBourse(p.getBourse() + rand.nextInt((max - min)+1)-min);
			System.out.println("C'est votre jour de chance !!! Le CROUS vous à selectionez pour vous attribuez un supplément de bourse !! + " + rand.nextInt((max - min)+1) + "de solde pour vous ! \\n");
		} else if(rte.equals(RandomTypeEvent.LUNCH)) {
			p.setBourse(p.getBourse() - 50);
			System.out.println("Les repas du CROUS vous ont était facturé... -50 crédits");
		} else if(rte.equals(RandomTypeEvent.ECHELON)) {
			p.setEchelon(rand.nextInt(6)+1);
			System.out.println("Allez vous avoir de la chance ou non ? allez vous prendre un echelon ou plutot en perdre, ah ah t'elle est la question");
			TimeUnit.SECONDS.sleep(3);
			System.out.println("Vous êtes desormais echelon" + p.getEchelon() + "\\n");
		} else if(rte.equals(RandomTypeEvent.BAR)) {
			p.setBourse(p.getBourse() - 75);
			System.out.println("Aie grosse soirée hier hein ? Consommez avec modération... - 75 crédits pour vous \\n");
		} else if(rte.equals(RandomTypeEvent.AMENDE)) {
			p.setBourse(p.getBourse() - 50);
			System.out.println("OOF, la grosse amende dans les dents, attention la prochaine fois... - 50 crédits \\n");
		} else if(rte.equals(RandomTypeEvent.ABSENT)) {
			p.setBourse(p.getBourse() - 150);
			System.out.println("Le CROUS n'est pas contend la, vous avez était trop absent en cour récemment ils vous enlèvent donc 150 crédits (plutôt que vous enlevez votre bourse) \\n");
		}
	}
	
	
	
	public RandomTypeEvent getRandEvent() {
		Random rand = new Random();
		if(rand.nextInt(10) == 1) {
			return RandomTypeEvent.PH;
		} else if(rand.nextInt(10) == 2){
			return RandomTypeEvent.BAR;
		}else if(rand.nextInt(10) == 3){
			return RandomTypeEvent.LUNCH;
		}else if(rand.nextInt(10) == 4){
			return RandomTypeEvent.SUP;
		}else if(rand.nextInt(10) == 5){
			return RandomTypeEvent.WORK;
		}else if(rand.nextInt(10) == 6){
			return RandomTypeEvent.AMENDE;
		}else if(rand.nextInt(10) == 7){
			return RandomTypeEvent.ABSENT;
		} else if(rand.nextInt(10) == 8) {
			return RandomTypeEvent.ECHELON;
		}else {
			return null;
		}
		
	}
	
}
