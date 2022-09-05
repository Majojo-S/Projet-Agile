package Menu.Game.BlackJack;

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import Menu.Menu;

public class Event {
	/**
	 *
	 */
	private static final String FELICITATIONS = "Felicitations ";
	private int timer = 0;
	
	public Event(int timer) {
		this.timer = timer;
	}
	public String red= "\033[0;31m";
	public String green = "\033[0;32m";
	public static final String ANSI_RESET = "\u001B[0m";
	public String blue="\033[0;34m";
	public int getTimer() {
		return this.timer;
	}
	
	public void setTimer(int timer) {
		this.timer = timer;
	}
	
	public void Loyer(Player p) {
		if(timer == 30) {
			System.out.println("Il est temps de payer ses factures ! \n");
			if(p.echelon < 3) {
				p.setBourse(p.getBourse() - 100);
			} else {
				p.setBourse(p.getBourse() - 250);
			}
		}
	}
	
	public void Bourses(Player p) {
		if(timer == 31) {
			System.out.println("Voila votre Bourse du mois ! \n");
			p.setBourse(p.getBourse() + 250);
		}
	}
	
	public void RandomEvent(RandomTypeEvent rte, Player p) throws InterruptedException {
		int min = 50;
		int max = 300;
		Random rand = new Random();
		System.out.println("C'est l'heure de l'évenement mystère !! \n");
		if(rte.equals(RandomTypeEvent.PH)) {
			p.setBourse(p.getBourse() + rand.nextInt(max)+min);
			System.out.println (green +" Vous recevez un virement de vos parents !" + (rand.nextInt(max)+min) + "de crédits ps: remerciez les quand même \n" + ANSI_RESET);
		} else if(rte.equals(RandomTypeEvent.WORK)) {
			System.out.println( green+"Pour votre bon service, le CROUS vous octroie un salaire pour le travail réalisé ! + 150 crédits \n"+ANSI_RESET);
		} else if(rte.equals(RandomTypeEvent.SUP)) {
			p.setBourse(p.getBourse() + rand.nextInt(max)+min);
			System.out.println(green+"C'est votre jour de chance !!! Le CROUS vous à selectionez pour vous attribuez un supplément de bourse !! + " + (rand.nextInt(max)+min) + "de solde pour vous ! \n"+ANSI_RESET);
		} else if(rte.equals(RandomTypeEvent.LUNCH)) {
			p.setBourse(p.getBourse() - 50);
			System.out.println(red+"Les repas du CROUS vous ont était facturé... -50 crédits \n"+ANSI_RESET);
		} else if(rte.equals(RandomTypeEvent.ECHELON)) {
			p.setEchelon(rand.nextInt(6)+1);
			System.out.println(blue+"Allez vous avoir de la chance ou non ? allez vous prendre un echelon ou plutot en perdre, ah ah t'elle est la question \n"+ANSI_RESET);
			TimeUnit.SECONDS.sleep(3);
			System.out.println("Vous êtes desormais echelon" + p.getEchelon() + "\n");
		} else if(rte.equals(RandomTypeEvent.BAR)) {
			p.setBourse(p.getBourse() - 75);
			System.out.println(red+"Aie grosse soirée hier hein ? Consommez avec modération... - 75 crédits pour vous \n"+ANSI_RESET);
		} else if(rte.equals(RandomTypeEvent.AMENDE)) {
			p.setBourse(p.getBourse() - 50);
			System.out.println(red+"OOF, la grosse amende dans les dents, attention la prochaine fois... - 50 crédits \n"+ANSI_RESET);
		} else if(rte.equals(RandomTypeEvent.ABSENT)) {
			p.setBourse(p.getBourse() - 150);
			System.out.println(red+"Le CROUS n'est pas content la, vous avez était trop absent en cour récemment ils vous enlèvent donc 150 crédits (plutôt que vous enlevez votre bourse) \n"+ANSI_RESET);
		} else {
			System.out.println(blue+"Bah non ya rien"+ANSI_RESET);
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
			return RandomTypeEvent.RIEN;
		}
		
	}

	public boolean WinTheGame(int bourse){
		if(bourse >= 8000){
			System.out.println("\nVous avez atteint les 8000 crédits , le Crous a explosé !");

			//TODO : EXPLOSION


			try {
				TimeUnit.SECONDS.sleep(3);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return true;
		}
		return false;
	}

	public boolean LostTheGame(int bourse){
		String [] args = null;
		if(bourse <= 0){
			System.out.println("\nLe Crous vous a dépouillé , vous n'avez plus de crédits !");
			try {
				try {
					TimeUnit.SECONDS.sleep(5);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					Menu.main(args);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return true;
		}
		return false;
	}
	
}
