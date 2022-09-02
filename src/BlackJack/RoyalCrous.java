package BlackJack;

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

        int bourse = 1000; // TODO : changer en aleatoire
        int echelon = 1; // TODO : changer en aleatoire

        Player player = new Player(bourse, name, echelon);

<<<<<<< HEAD
        init(player);

        System.out.println(player.bet(scanner));

        //System.out.println("Vous avez " + player.getBourse() + "jetons");
=======
        System.out.println("Vous avez " + player.getBourse() + "jetons");
>>>>>>> 99cb235aaa6286d6ca9efa37e035ce49b1cb391e
        
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

    //private void displayBourse(){
      //  System.out.println("Vous avez " + player.getBourse() + "jetons");
    //}


    
}
