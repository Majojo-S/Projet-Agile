package BlackJack;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class RoyalCrous {

    public static void main(String[] args) {
        System.out.println("Voulez-vous commencer une partie ? Entrez oui ou non");

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        if(input.equals("oui")){
            System.out.println("La partie commence");
            //Inserer methode init
        }

        
        System.out.println("Entrez votre nom");
        String name = scanner.nextLine();

        Player player = new Player(name);
        init(player);

        System.out.println("Vous avez " + player.getBourse() + "jetons");

        System.out.println(player.bet(scanner));
        
        System.out.println("Combien de paquet ? :");
        int nb = scanner.nextInt();
        Packet jeu = new Packet(nb);
        int choix = 0;
        player.hand.add(jeu.PickCard());
    	player.hand.add(jeu.PickCard());
    	player.croupier.add(jeu.PickCard());
    	System.out.println("Votre main est : " + player.hand + "total : " + player.totalOfHand() + "\n");
    	System.out.println("La carte du croupier est : " + player.croupier + "total : "+ player.totalOfCroupier()+ "\n");
    	System.out.println("Voulez-vous re-piochez ? 1 ou 2");
    	choix = scanner.nextInt();
    	System.out.println(choix);
        while(choix != 0 || choix != 0) {
        	if(choix == 0) {
        		System.out.println("Vous avez perdu le Croupier Gagne");
        		choix = 0;
        	} else if(choix == 1 && player.totalOfHand() < 21){
        		player.hand.add(jeu.PickCard());
            	System.out.println("Votre main est : " + player.hand + "total : " + player.totalOfHand());
            	if(player.totalOfHand() > 21) {
            		System.out.println("Vous avez perdu le Croupier Gagne");
            		choix = 0;
            	}
            	System.out.println("Voulez-vous re-piochez ? 1 ou 2");
            	choix = scanner.nextInt();
        	} else if (choix == 2) {
        		
        	} else if (player.totalOfHand() == 21 && player.totalOfCroupier() < player.totalOfHand()) {
        		System.out.println("Vous avez gagné");
        		choix = 0;
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

    
}
