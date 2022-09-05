package Menu.Game.BlackJack;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import Menu.Game.Game;

public class RoyalCrous implements Game {

	public void start(Player player, Players players){
		Scanner scanner = new Scanner(System.in);
        System.out.println("Vous avez " + player.getBourse() + "jetons");
        
        Event event = new Event(0);
        
        System.out.println("Combien de paquet ? :");
        int nb = scanner.nextInt();
        
        int choix = 0;
        boolean fin = false;
        while(fin != true) {
        	Packet jeu = new Packet(nb);
        	System.out.println("Début du jeu ! ");
        	int bet = player.bet(scanner);
        	System.out.println("Vous avez misé : " + bet + " crédits");
        	clear();
        	player.hand.clear();
        	player.croupier.clear();
        	player.hand.add(jeu.PickCard());
	    	player.hand.add(jeu.PickCard());
	    	player.croupier.add(jeu.PickCard());

			System.out.println("Votre main :");

			afficherMainPlayer(player);

	    	System.out.println("Votre total : " + player.totalOfHand() + "\n");
	    	System.out.println("Main du croupier : ");

			afficherMainCroupier(player);

			System.out.println("Total du croupier : "+ player.totalOfCroupier()+ "\n");

	    	if(player.totalOfHand() == 21) {
	    		System.out.println("BLACKJACK ! Vous remportez cette partie !");
	    		choix = 0;
	    	}
	    	System.out.println("1 pour piocher et 2 pour rester, -1 pour quitter");
	    	choix = scanner.nextInt();
	        while(choix != 0) {
	        	if(choix == 0) {
	        		choix = 0;
	        		break;
	        	} else if(choix == 1 && player.totalOfHand() < 21){
	        		player.hand.add(jeu.PickCard());
	            	System.out.println("Votre main : ");
					afficherMainPlayer(player);
					System.out.println("Total : " + player.totalOfHand());
	            	if(player.totalOfHand() > 21) {
	            		handResult(Result.LOST);
						updateBourseLost(player, bet, players);
						event.setTimer(event.getTimer()+1);
	            		choix = 0;
	            		try {
							TimeUnit.SECONDS.sleep(3);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
	            		clear();
	            	} else {
	            		System.out.println("1 pour piocher et 2 pour rester");
	                	choix = scanner.nextInt();
	            	}
	        	} else if (choix == 2) {
	        		while(player.totalOfCroupier() < 17) {
	        			player.croupier.add(jeu.PickCard());
	        			System.out.println("Main du croupier : " );
						afficherMainCroupier(player);
						System.out.println("Total du croupier : "+ player.totalOfCroupier()+ "\n");
	        		}
	        		if (player.totalOfCroupier() < player.totalOfHand() || player.totalOfCroupier() > 21) {
	        			handResult(Result.WIN);
						updateBourseWin(player, bet, players);
						event.setTimer(event.getTimer()+1);						
						clear();
	            		choix = 0;
	            		try {
							TimeUnit.SECONDS.sleep(3);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
	            	} else if(player.totalOfHand() > 21 || player.totalOfCroupier() > player.totalOfHand() && player.totalOfCroupier() < 21) {
	            		handResult(Result.WIN);
						updateBourseWin(player, bet, players);
						event.setTimer(event.getTimer()+1);
						clear();
	            		choix = 0;
	            		try {
							TimeUnit.SECONDS.sleep(3);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
	            	} else if(player.totalOfCroupier() == player.totalOfHand()) {
	            		handResult(Result.DRAW);
	            		event.setTimer(event.getTimer()+1);
	            		choix = 0;
	            		clear();
	            		try {
							TimeUnit.SECONDS.sleep(3);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

	            	}
	        	}
	        }
        }
	        
        scanner.close();
    }

	private static void afficherMainCroupier(Player player){
		for(Card c : player.croupier){
			System.out.println(c.afficherNumber(c.getRank()) + c.afficherSymbole(c.getColor()));
		}
	}

	private static void afficherMainPlayer(Player player){
		for(Card c : player.hand){
			System.out.println(c.afficherNumber(c.getRank()) + c.afficherSymbole(c.getColor()));
		}
	}
	

    private static void clear(){
		for (int i = 0; i < 14; i++) {
			System.out.println("\n");
		}
	}
    
    private static void handResult(Result res) {
    	if(res == Result.WIN) {
    		System.out.println("Vous avez gagné");
    	} else if(res == Result.LOST) {
    		System.out.println("Vous avez perdu le Croupier Gagne");
    	} else {
    		System.out.println("Egalité vous recuperez votre mise");
    	}
    }

	private static void updateBourseWin(Player player, int coins, Players players){
		System.out.println("Vous avez gagné " + coins + " crédits");
		player.setBourse(player.getBourse() + coins);
		players.majProfil(player);
		System.out.println("Il vous reste " + player.getBourse() + "crédits");
	}

	private static void updateBourseLost(Player player, int coins, Players players){
		System.out.println("Vous avez perdu " + coins + " crédits");
		player.setBourse(player.getBourse() - coins);
		players.majProfil(player);
		System.out.println("Il vous reste " + player.getBourse() + "crédits");
	}

    
}
