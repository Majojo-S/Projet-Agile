package BlackJack;

public class UnvalidBet extends Exception {
    public UnvalidBet() {
        super("Vous n'avez pas assez de jetons ! \nVeuillez miser une valeur inférieur à votre solde ! ");
    }
}