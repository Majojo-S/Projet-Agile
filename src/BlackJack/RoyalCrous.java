package BlackJack;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import Menu.Menu;

public class RoyalCrous {

    public static void main(String[] args) throws InterruptedException {
    	Scanner scanner = new Scanner(System.in);
    	Menu menu = new Menu();
        Player player = menu.getCurrentPlayer();
        init(player);

        System.out.println("Vous avez " + player.getBourse() + "jetons");

        System.out.println(player.bet(scanner));
        
        System.out.println("Combien de paquet ? :");
        int nb = scanner.nextInt();
        int choix = 0;
        boolean fin = false;
        while(fin != true) {
        	System.out.println(fin);
        	Packet jeu = new Packet(nb);
        	System.out.println("Début du jeu ! ");
        	clear();
        	player.hand.clear();
        	player.croupier.clear();
        	player.hand.add(jeu.PickCard());
	    	player.hand.add(jeu.PickCard());
	    	player.croupier.add(jeu.PickCard());
	    	System.out.println("Votre main est : " + player.hand + "total : " + player.totalOfHand() + "\n");
	    	System.out.println("La carte du croupier est : " + player.croupier + "total : "+ player.totalOfCroupier()+ "\n");
	    	if(player.totalOfHand() == 21) {
	    		System.out.println("BLACKJACK ! Vous remportez cette partie !");
	    		choix = 0;
	    	}
	    	System.out.println("1 pour piocher et 2 pour rester");
	    	choix = scanner.nextInt();
	        while(choix != 0) {
	        	if(choix == 0) {
	        		System.out.println("Vous avez perdu le Croupier Gagne");
	        		choix = 0;
	        		fin = true;
	        	} else if(choix == 1 && player.totalOfHand() < 21){
	        		player.hand.add(jeu.PickCard());
	            	System.out.println("Votre main est : " + player.hand + "total : " + player.totalOfHand());
	            	if(player.totalOfHand() > 21) {
	            		System.out.println("Vous avez perdu le Croupier Gagne");
	            		choix = 0;
	            		TimeUnit.SECONDS.sleep(3);
	            	} else {
	            		System.out.println("1 pour piocher et 2 pour rester");
	                	choix = scanner.nextInt();
	            	}
	        	} else if (choix == 2) {
	        		while(player.totalOfCroupier() < 17) {
	        			player.croupier.add(jeu.PickCard());
	        			System.out.println("Les cartes du croupier est : " + player.croupier + "total : "+ player.totalOfCroupier()+ "\n");
	        		}
	        		if (player.totalOfCroupier() < player.totalOfHand() || player.totalOfCroupier() > 21) {
	            		System.out.println("Vous avez gagné");
	            		choix = 0;
	            		TimeUnit.SECONDS.sleep(3);
	            	} else if(player.totalOfHand() > 21 || player.totalOfCroupier() > player.totalOfHand() && player.totalOfCroupier() <= 21) {
	            		System.out.println("Vous avez perdu le Croupier Gagne");
	            		choix = 0;
	            		TimeUnit.SECONDS.sleep(3);
	            	} else if(player.totalOfCroupier() == player.totalOfHand()) {
	            		System.out.println("Egalité vous recuperez votre mise");
	            		choix = 0;
	            		TimeUnit.SECONDS.sleep(3);

	            	}
	        	}
	        }
        }
	        
        scanner.close();
    }

    private static void init(Player player ){
        Map<Integer,Integer> solde = new HashMap<>();
        solde.put(1, 100);
        solde.put(2, 200);
        solde.put(3, 300);
        solde.put(4, 400);
        solde.put(5, 500);
        solde.put(6, 600);

        Random random = new Random();
        int echelon = random.nextInt(6) + 1;
        int bourse = solde.get(echelon);

        player.echelon = echelon;
        player.bourse = bourse;

        System.out.println("Le crous vous a attribué l'échelon " + echelon + " \nVotre bourse s'élève à " + bourse);  
    }
    
    private static void clear(){
		for (int i = 0; i < 14; i++) {
			System.out.println("\n");
		}
	}

    
}
