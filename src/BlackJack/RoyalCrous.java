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

        scanner.close();
    }

    //private void displayBourse(){
      //  System.out.println("Vous avez " + player.getBourse() + "jetons");
    //}


    
}
