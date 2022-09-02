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

        System.out.println("Vous avez " + player.getBourse() + "jetons");
        
        System.out.println("Combien de paquet ? :");
        int nb = scanner.nextInt();
        Packet jeu = new Packet(nb);
        String choix = "";
        while(choix != "fin") {
        	System.out.println("Votre carte est : " + jeu.PickCard());
        	System.out.println("voulez vous re-piochez ?" + "\n");
        	choix = scanner.nextLine();
        	if(choix.equalsIgnoreCase("non") || choix.equalsIgnoreCase("fin")) {
        		choix = "fin";
        	}
        }
        scanner.close();
    }

    //private void displayBourse(){
      //  System.out.println("Vous avez " + player.getBourse() + "jetons");
    //}


    
}
