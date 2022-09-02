package BlackJack;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class RoyalCrous {

	
	
	public static void main(Player[] args) throws InterruptedException {
     
        Scanner scanner = new Scanner(System.in);

 
        Player player = args[0];

        System.out.println("Vous avez " + player.getBourse() + "jetons");
        
        System.out.println("Combien de paquet ? :");
        int nb = scanner.nextInt();
        
        int choix = 0;
        boolean fin = false;
        while(fin != true) {
        	Packet jeu = new Packet(nb);
        	System.out.println("Début du jeu ! ");
        	System.out.println(player.bet(scanner));
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
	        		handResult(Result.LOST);
	        		choix = 0;
	        		fin = true;
	        	} else if(choix == 1 && player.totalOfHand() < 21){
	        		player.hand.add(jeu.PickCard());
	            	System.out.println("Votre main est : " + player.hand + "total : " + player.totalOfHand());
	            	if(player.totalOfHand() > 21) {
	            		handResult(Result.LOST);
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
	        			handResult(Result.WIN);
	            		choix = 0;
	            		TimeUnit.SECONDS.sleep(3);
	            	} else if(player.totalOfHand() > 21 || player.totalOfCroupier() > player.totalOfHand() && player.totalOfCroupier() < 21) {
	            		handResult(Result.WIN);
	            		choix = 0;
	            		TimeUnit.SECONDS.sleep(3);
	            	} else if(player.totalOfCroupier() == player.totalOfHand()) {
	            		handResult(Result.DRAW);
	            		choix = 0;
	            		TimeUnit.SECONDS.sleep(3);

	            	}
	        	}
	        }
        }
	        
        scanner.close();
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

    
}
