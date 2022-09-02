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

        int bourse = 1000; // TODO : changer en aleatoire
        int echelon = 1; // TODO : changer en aleatoire

        Player player = new Player(bourse, name, echelon);

        init(player);

        //System.out.println("Vous avez " + player.getBourse() + "jetons");
        
        System.out.println("Combien de paquet ? :");
        int nb = scanner.nextInt();
        Packet jeu = new Packet(nb);
        String choix = "";
        while(choix != "fin") {
        	System.out.println("Votre carte est : " + jeu.PickCard());
        	System.out.println("voulez vous re-piochez ?" + "\n");
        	choix = scanner.nextLine();
        	if(choix == "non" || choix == "NON" || choix == "fin" || choix == "FIN") {
        		choix = "fin";
        	}
        }
        scanner.close();
    }

    //private void displayBourse(){
      //  System.out.println("Vous avez " + player.getBourse() + "jetons");
    //}

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
