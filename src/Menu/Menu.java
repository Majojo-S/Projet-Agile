package Menu;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import Menu.Game.BlackJack.Player;
import Menu.Game.BlackJack.Players;
import Menu.Game.BlackJack.RoyalCrous;
import Menu.Game.BlackJack.SecretPlayer;
import Menu.Game.BlackJack.UnvalidBet;
import Menu.Game.Roulette.Roulette;





public class Menu {
	private static Players players= new Players();
	private static Player p1;
	private static List<String> secretPlayer= new ArrayList<String>();



	private static Scanner userInput = new Scanner(System.in);




	public static void main(String[] args) throws IOException, InterruptedException{
		titleMenu();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		players.loadPlayers();
		boolean exit = false;
		String input;
		while(!exit) {
			clear();
			mainMenu();
			input = userInput.nextLine();
			clear();
			switch (input) {
			case "1": {
				try {
					playMenu();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			}	
			
			case "2":{
				exitMenu();
				exit = true;
				break;
			}
			default:
				break;
			}
		}
		userInput.close();
	}



	private static void exitMenu() {
		System.out.println("Merci d'avoir joué !");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void LoadingMenu() throws InterruptedException, IOException {
		System.out.println("Loading game...");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
		}
		boolean exit = false;
		String input;
		while(!exit) {
			clear();

			String [] best=new String [5];
			for (int i = 0; i < best.length; i++) {
				best[i]="n°"+Integer.sum(i, 1)+" no one";
			}
			Collections.sort(players.getPlayers());
			for (int i = 0; i < players.getPlayers().size(); i++) {
				best[i]="n°"+Integer.sum(i, 1)+" "+players.getPlayers().get(i).toString();
				if(i==4)break;
			}


			System.out.print("╔━╤━━━━━━━━━━━━╗\n"
					+"┃1┃ BlackJack  ┃\n"
					+"╠═╬════════════╣\n"
					+"┃2┃ Roulette   ┃\n"
					+"╠═╬════════════╣\n"
					+"┃3┃ Back       ┃\n"
					+"╚═╧════════════╝\n"
					+"               \n"
					+"Faites un choix : ");
			
			input = userInput.nextLine();
			if(Integer.valueOf(input) == 3 ) {
				playMenu();
			}
			play(input);
			exit=true;


		}
	}

	private static void titleMenu() throws InterruptedException {
		
		System.out.println("Vous etes un jeune bachelier, le jour de votre rentrée vous n'avez pas reçu votre bourse");
		TimeUnit.SECONDS.sleep(4);
		System.out.println("Malheuresement cette argent devait servir a soigner votre perroquet");
		TimeUnit.SECONDS.sleep(3);
		System.out.println("A cause de ce retard, PIOU PIOU il est mort");
		TimeUnit.SECONDS.sleep(4);
		System.out.println("Du coup vous decidez donc de vous venger de cette organisation maléfique");
		TimeUnit.SECONDS.sleep(3);
		System.out.println("Votre plan est d'aller au casino avec l'argent du Crous pour acheter un BAZOOKA et détruire les méchants");
		TimeUnit.SECONDS.sleep(3);
		System.out.println("L'armurier de los santos vous a dit que le bazooka valait 8000 balles");
		TimeUnit.SECONDS.sleep(4);
		
		System.out.println(Roulette.ANSI_RED_BG+"░░▒▒▒▒▓▓▒▒▒▒▒▒▒▒░░░░▒▒▓▓██▓▓░░▒▒░░░░▒▒░░░░▓▓░░░░▒▒▒▒▓▓▒▒▒▒▒▒░░░░░░▒▒░░▒▒░░▒▒░░▒▒░░░░▒▒  ▒▒▒▒░░░░▒▒▒▒▒▒░░░░    ▒▒▒▒▒▒  ░░▒▒░░▓▓▓▓▒▒▒▒░░▒▒▒▒░░▒▒██▓▓▓▓▒▒░░░░░░░░▓▓▓▓▓▓▓▓▓▓░░  ▒▒▓▓▓▓░░░░\n" + 
				"▒▒▒▒▓▓▓▓░░░░░░▒▒▒▒▓▓░░  ▓▓▒▒▒▒░░    ▒▒▒▒▒▒▒▒▒▒░░▒▒░░▒▒▓▓░░▒▒░░░░░░░░▒▒  ▒▒▒▒░░░░░░░░▒▒░░░░░░░░░░            ░░  ▓▓▒▒  ░░▒▒░░▒▒▓▓▒▒  ▒▒▒▒░░░░▒▒▒▒▓▓▓▓▓▓▒▒▒▒▒▒▒▒▓▓▓▓██░░  ▒▒▒▒▒▒▒▒  ░░▒▒\n" + 
				"▒▒▓▓▓▓▒▒░░░░░░░░░░▓▓▓▓▓▓░░░░░░░░    ░░▒▒▒▒▒▒▒▒▒▒░░░░▓▓▓▓▓▓▒▒░░░░░░░░░░░░▒▒▒▒░░░░░░▒▒▒▒▒▒  ▒▒░░░░            ░░░░▒▒▒▒░░▒▒░░▓▓▓▓▓▓  ▒▒▒▒░░░░░░░░▒▒▓▓▓▓██▓▓▒▒▒▒▒▒▒▒░░  ░░▓▓▓▓░░░░▒▒▒▒░░░░\n" + 
				"▒▒▓▓▓▓░░▒▒▒▒░░░░▒▒▒▒░░▒▒▓▓▓▓░░  ░░░░  ░░░░░░▒▒▒▒▒▒░░▓▓▓▓▓▓▒▒░░░░░░░░░░░░▒▒░░▒▒░░░░▒▒▒▒▒▒  ▒▒░░  ░░  ▒▒▒▒▓▓  ░░░░  ▒▒▒▒░░▒▒▓▓██░░░░▒▒░░░░░░░░░░░░▒▒▓▓▓▓▓▓▓▓░░░░  ░░░░░░░░░░░░░░░░░░░░  \n" + 
				"▓▓▓▓▒▒░░▒▒▒▒▒▒▓▓▒▒▒▒░░░░░░▒▒▓▓▓▓░░░░▒▒▒▒░░░░▒▒░░▒▒▒▒  ▓▓██▒▒░░░░░░░░░░▓▓▒▒▒▒░░░░░░░░▒▒▒▒  ▒▒▒▒  ░░  ▒▒▓▓▒▒▒▒░░░░░░▒▒▒▒░░▒▒▓▓▒▒░░▒▒    ░░░░  ░░░░░░▒▒▓▓▓▓░░  ▒▒▒▒░░░░░░  ▒▒░░▒▒▒▒      \n" + 
				"▓▓▒▒▒▒░░░░░░▓▓▓▓▒▒▒▒░░▒▒░░░░░░▒▒▒▒▒▒░░░░░░░░░░░░░░▒▒▒▒  ▓▓▒▒░░░░▒▒░░  ▓▓▒▒▒▒░░░░░░░░░░░░  ▒▒▒▒  ░░  ▒▒▓▓▒▒▒▒░░░░░░▒▒▓▓  ██▒▒░░▒▒▒▒░░░░░░░░▒▒░░░░░░░░░░  ▒▒▒▒▒▒▒▒░░  ░░░░░░▓▓░░░░░░    \n" + 
				"▓▓▒▒▒▒▒▒░░▓▓▒▒▓▓▒▒▒▒░░░░░░▒▒░░▒▒▒▒▒▒▒▒▒▒░░░░░░░░▒▒░░▒▒▒▒  ▒▒░░░░▒▒▒▒░░▒▒░░▒▒░░░░░░░░░░░░░░░░▒▒░░░░    ▒▒░░  ░░░░  ▒▒▒▒  ▓▓░░▒▒▒▒░░░░░░░░▒▒▓▓▒▒░░    ▒▒▒▒▒▒░░▒▒▓▓▒▒░░  ▒▒▒▒▓▓▓▓░░░░    \n" + 
				"░░▒▒▒▒░░▒▒▓▓▓▓▓▓▒▒▒▒░░  ░░░░░░▒▒▒▒░░░░▒▒▒▒▒▒░░  ░░░░  ▓▓░░▒▒▒▒▒▒▒▒░░▒▒▒▒░░▒▒  ░░░░░░░░  ░░░░░░░░░░  ░░            ░░▒▒  ▒▒░░░░░░░░░░░░░░▒▒▓▓░░  ▒▒░░▒▒░░░░  ░░▓▓▓▓░░▒▒▓▓░░▒▒▒▒▓▓░░░░  \n" + 
				"░░░░▒▒░░▒▒▓▓██▓▓▒▒░░░░░░▒▒░░  ▒▒░░▒▒░░░░░░▒▒░░▓▓░░  ░░░░▒▒▓▓▒▒░░░░░░▓▓▓▓░░░░░░  ░░░░░░      ░░░░░░  ░░      ░░░░▒▒▒▒░░  ░░▓▓▒▒░░░░░░░░  ░░  ▒▒░░▒▒░░░░  ░░  ░░▓▓▓▓▒▒░░░░░░▓▓▒▒▓▓▓▓▒▒  \n" + 
				"▒▒░░▓▓██▓▓██▓▓▒▒░░░░░░░░░░▒▒▒▒░░  ░░▒▒░░▒▒░░░░░░░░░░      ░░░░      ░░░░░░▒▒░░░░░░  ░░░░░░  ▒▒░░░░░░░░░░      ░░        ░░░░  ░░░░▒▒░░  ▓▓▒▒▒▒░░░░  ░░░░    ░░▓▓▓▓▒▒░░░░░░▒▒▓▓▓▓▓▓▒▒  \n" + 
				"▒▒░░▒▒▓▓▓▓██▒▒▒▒░░░░░░▒▒▒▒▒▒▒▒▒▒░░    ░░░░░░░░  ░░  ░░                    ░░  ░░░░░░░░░░░░  ▒▒░░    ░░▒▒░░                      ░░  ▒▒  ▒▒░░░░░░░░░░        ▒▒▓▓▒▒▓▓░░░░░░░░░░████▒▒  \n" + 
				"▒▒▒▒▒▒▓▓▓▓▒▒░░░░░░▒▒░░░░▒▒▒▒▒▒▒▒  ░░░░░░░░░░░░▒▒  ░░                          ░░░░░░░░▒▒░░▒▒▒▒░░▒▒▓▓▒▒                              ░░▒▒    ░░      ░░░░    ░░▒▒▒▒▓▓▒▒░░▒▒▒▒▓▓██▒▒▒▒░░\n" + 
				"▒▒░░▒▒▒▒▒▒▓▓░░░░▒▒░░░░░░░░░░░░░░░░░░░░░░░░▒▒░░                                  ░░▒▒░░░░░░  ▒▒░░▓▓▒▒                                      ▒▒░░░░  ▒▒▒▒▒▒▒▒    ▒▒▒▒▓▓▓▓░░░░▓▓██▓▓██▓▓▒▒\n" + 
				"░░░░░░░░▒▒▓▓▒▒▒▒░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░                                      ▓▓▒▒▒▒░░░░▒▒▒▒                                        ░░      ▒▒▓▓▒▒▒▒    ░░▒▒▓▓▓▓░░░░░░░░▒▒░░░░░░\n" + 
				"░░▒▒▒▒▒▒▒▒░░▒▒▒▒▒▒▒▒░░░░░░░░░░░░░░░░░░░░▒▒░░                                        ░░▓▓░░░░▒▒▒▒                                            ▒▒    ▒▒▒▒▒▒░░  ░░  ░░▒▒▒▒▒▒░░░░░░▒▒░░  ▓▓\n" + 
				"▒▒░░██▓▓▓▓▒▒░░░░▒▒▒▒▒▒▒▒░░▒▒▒▒░░░░░░░░░░░░░░                                          ░░░░▒▒▒▒                                              ░░          ░░░░░░  ▒▒  ▒▒▒▒▒▒▓▓░░░░░░░░▒▒\n" + 
				"░░▒▒▓▓██▓▓▒▒  ░░░░░░▒▒▒▒▒▒▒▒░░▒▒▒▒░░░░▒▒░░                                              ░░▓▓  ░░                                              ▒▒    ░░░░░░░░░░░░░░▒▒▒▒▒▒░░░░░░░░░░▒▒▒▒\n" + 
				"▒▒▒▒████▒▒░░░░░░  ░░░░░░▒▒▒▒▒▒▒▒░░▒▒░░░░░░                                                  ░░                                                ░░  ░░░░░░░░░░▒▒▒▒▓▓▒▒░░░░▓▓░░░░░░░░▒▒▓▓\n" + 
				"██████▓▓▒▒░░░░░░░░░░▒▒▒▒░░░░▒▒▒▒▒▒▒▒▓▓░░                                                                                                        ▒▒    ░░▒▒▒▒▓▓▒▒░░░░▒▒▓▓▓▓░░▒▒▓▓░░▓▓▓▓\n" + 
				"░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░  $$$$$$$$                            $$$        $$$$$$\\                                               ░░░░▒▒▒▒▒▒▒▒    ░░░░▒▒▓▓▒▒▒▒░░░░░░▒▒▓▓\n" + 
				"▒▒░░▒▒▓▓▓▓▓▓▓▓▓▓▓▓▓▓▒▒▒▒▒▒▒▒▒▒░░▒▒▒▒▒▒░░  $$  __$$$                           $$ |      $$  __$$\\                                                ▒▒▒▒▒▒  ░░░░  ░░░░  ░░░░░░░░░░░░░░░░\n" + 
				"░░░░▒▒▒▒░░░░░░░░░░▒▒▒▒▒▒░░░░░░░░░░  ▒▒    $$ |  $$ |$$$$$$$ $$$   $$$ $$$$$$$ $$ |      $$ l  l__|$$$$$$$  $$$$$$$ $$$   $$$ $$$$$$$$             ░░░░░░▒▒▒▒▒▒▒▒▒▒▒▒▓▓▓▓▓▓▓▓▒▒▒▒▒▒▓▓▓▓\n" + 
				"░░░░▓▓▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒░░  ▒▒    $$$$$$$  $$  __$$$$$ |  $$ |$____$$$$$ |      $$ |     $$  __$$l$$  __$$l$$ |  $$ $$  _____|          ░░  ▒▒██▒▒░░▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒░░▒▒▒▒▒▒\n" + 
				"░░░░▓▓▒▒▒▒  ░░░░░░░░░░░░░░░░░░      ▒▒    $$  __$$<$$ $  $$ $$ |  $$ |$$$$$$$ $$ |      $$ |     $$ |  l__$$ /  $$ $$ |  $$ l$$$$$$l            ░░░░░░░░░░  ░░░░░░░░░░▒▒▓▓▒▒░░░░░░░░▒▒\n" + 
				"▒▒▓▓▓▓▒▒▒▒░░  ░░░░░░▒▒▒▒░░          ▒▒    $$ |  $$ $$ |  $$ $$ |  $$ $$  __$$ $$ |      $$ |  $$l$$ |     $$ |  $$ $$ |  $$ |l____$$l           ░░░░░░░░░░░░░░░░░░░░▒▒▒▒▓▓▒▒░░░░░░░░▓▓\n" + 
				"░░▒▒▓▓▒▒▒▒░░░░░░░░▓▓▒▒▒▒▒▒      ░░  ░░░░  $$ |  $$ l$$$$$$  l$$$$$$$ l$$$$$$$ $$ |      l$$$$$$  $$ |     l$$$$$$  l$$$$$$  $$$$$$$  |          ░░  ░░    ░░░░░░░░░░▒▒▓▓▓▓▒▒░░▓▓▒▒▓▓██\n" + 
				"▒▒██▒▒██░░░░░░  ░░▓▓▒▒▒▒▒▒░░  ░░░░▒▒░░░░  l$$|  %__|l______% l____$$ |l_______l__|       l______%l__|      l______% l______%l_______%           ░░░░    ▒▒▒▒▓▓  ░░░░▒▒▓▓▒▒▒▒░░▒▒░░▓▓██\n" + 
				"░░▓▓▓▓██▒▒░░░░  ▒▒░░▓▓▒▒░░  ░░▒▒▒▒▓▓▓▓░░                    $$l   $$ |                                                                          ░░░░░░░░▒▒██▒▒░░░░░░▒▒▒▒██▒▒░░░░▒▒▓▓▓▓\n" + 
				"░░▒▒▓▓▓▓▒▒    ░░░░░░  ░░▒▒▒▒▒▒▒▒░░░░░░░░                    l$$$$$$  |                                                                            ░░░░░░▒▒▒▒▓▓░░  ░░▓▓▓▓▓▓▒▒░░░░░░▓▓▓▓\n" + 
				"▓▓▓▓▓▓▓▓▒▒░░      ░░▒▒▒▒▒▒░░░░░░░░  ░░▒▒                     l______l                                                                          ░░░░░    ░░▒▒░░░░  ░░▓▓▓▓▓▓▒▒▒▒░░░░▓▓▓▓\n" + 
				"██▓▓▒▒▒▒░░░░░░▒▒▓▓▓▓▒▒▒▒▒▒▒▒▒▒▒▒  ░░  ░░                                                                                                      ░░░░░░░░░░░░░░░░░░░░░░▓▓▓▓▓▓░░▒▒▒▒▒▒▓▓▓▓\n" + 
				"▒▒▓▓▒▒  ░░▓▓▓▓▓▓▒▒░░▒▒░░▒▒░░▒▒░░░░░░░░░░░░                                                                                                  ▒▒  ░░░░░░░░░░░░░░░░  ░░▒▒▓▓▓▓░░░░▓▓██▓▓▓▓\n" + 
				"░░░░▒▒▓▓▒▒▓▓░░░░▒▒▒▒▒▒▒▒░░░░░░░░░░░░░░░░░░░░                                                                                              ░░░░░░░░░░▒▒░░▒▒▒▒▒▒▒▒░░░░░░▒▒▒▒▒▒░░░░▓▓▓▓▓▓\n" + 
				"▒▒▒▒░░░░▒▒▒▒░░▒▒▒▒▒▒░░  ▒▒▒▒░░░░░░░░░░░░░░▓▓░░                                                                                            ▒▒░░░░░░▒▒▓▓▒▒▓▓▒▒▓▓▓▓▒▒▓▓▓▓▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒\n" + 
				"▒▒░░░░▒▒▒▒▒▒▒▒░░░░░░▒▒▒▒▒▒▒▒▒▒░░░░░░░░░░▒▒▒▒░░▒▒                                                                                      ░░░░░░░░  ░░▒▒▒▒▒▒▒▒▒▒▒▒▒▒░░▒▒▒▒▒▒░░▒▒▒▒░░▒▒▒▒░░\n" + 
				"░░░░░░░░▓▓▒▒▒▒▒▒░░░░░░▒▒▒▒▒▒▓▓░░░░░░  ▒▒▒▒░░    ▒▒░░                                                                                ▒▒░░▒▒░░░░░░░░▒▒▒▒░░░░░░▒▒▒▒▒▒▒▒▒▒░░░░░░░░░░▒▒▒▒▒▒\n" + 
				"░░░░░░░░▓▓▓▓▒▒▒▒░░░░░░▒▒▒▒▒▒░░░░░░░░▒▒▓▓░░░░░░░░░░▒▒░░                                                                          ░░▒▒  ░░░░  ▒▒░░░░░░    ░░░░▒▒▓▓▓▓▓▓▒▒░░░░▒▒░░▒▒▒▒▒▒▓▓\n" + 
				"░░▒▒▒▒░░▓▓▓▓▒▒▒▒▒▒░░░░░░░░░░░░░░  ▒▒▒▒░░░░░░░░  ░░░░░░░░░░                                                                    ▒▒░░    ▓▓▒▒▓▓░░░░▒▒░░░░░░░░▒▒▒▒▓▓██▒▒░░▓▓▓▓░░░░▒▒▒▒░░░░\n" + 
				"▓▓░░░░░░▒▒▒▒██▓▓▒▒░░░░░░░░░░  ░░▒▒▒▒░░░░░░░░░░░░░░░░░░░░░░░░                                                              ░░▒▒    ░░░░░░▒▒▒▒▒▒▒▒░░░░░░░░░░▒▒▓▓▓▓▒▒▒▒░░░░░░▓▓██▒▒▒▒░░░░\n" + 
				"▓▓░░░░░░░░▓▓▓▓▓▓▒▒░░░░░░░░░░░░░░▒▒▒▒▒▒▒▒░░░░  ░░░░░░  ░░░░▒▒░░                                                          ▒▒░░░░░░  ░░▒▒▒▒  ░░▒▒▒▒▓▓▒▒░░░░░░▓▓▓▓▓▓▒▒▒▒░░▒▒░░▒▒██▒▒▒▒  ░░\n" + 
				"▓▓▒▒░░▒▒░░▒▒██▓▓▒▒░░░░▒▒░░░░░░▓▓▒▒░░▒▒▒▒░░░░░░░░░░░░  ░░▒▒░░▒▒  ░░                                                ░░▓▓  ▒▒░░░░░░░░▓▓▓▓██▒▒░░  ░░▒▒▓▓▒▒░░░░▓▓▓▓░░▒▒▒▒░░░░▓▓▒▒▓▓▒▒▒▒░░░░\n" + 
				"▓▓▒▒▒▒▒▒░░▒▒████▒▒░░░░▓▓▒▒░░▓▓▒▒░░░░░░░░▒▒▒▒▒▒░░░░░░░░▒▒▒▒▒▒▓▓░░░░▒▒                                            ░░▒▒▒▒▒▒  ▒▒░░░░░░▓▓▒▒░░░░▒▒░░░░  ▒▒▓▓▓▓▒▒▒▒▒▒░░▒▒▒▒░░▒▒▓▓██▓▓░░░░░░░░\n" + 
				"▓▓▒▒▒▒▒▒▓▓██▓▓▒▒▒▒▓▓▒▒▒▒  ▓▓▓▓░░▒▒░░░░▒▒▒▒▒▒▓▓░░░░░░▒▒▒▒▒▒▒▒░░░░░░  ░░░░                                      ░░░░  ░░░░▒▒░░░░▒▒░░  ▒▒  ▒▒▒▒▒▒░░░░░░░░▒▒▒▒▒▒▒▒░░░░▓▓▓▓▓▓████▒▒▒▒░░░░░░\n" + 
				"▓▓▓▓░░░░░░▒▒▓▓▓▓▒▒▓▓▒▒░░▓▓▓▓  ▒▒░░░░▒▒░░▒▒▒▒▒▒░░░░▒▒▒▒▒▒▒▒▒▒░░        ░░▒▒░░                                ▒▒  ░░░░  ░░░░░░░░░░░░▒▒░░░░  ▒▒▒▒▒▒░░░░░░░░░░▒▒▒▒▒▒░░▓▓▓▓▓▓▓▓▒▒▒▒░░░░░░░░\n" + 
				"▓▓▒▒▒▒▒▒▒▒▒▒▒▒▓▓░░  ░░▒▒▓▓░░░░░░░░░░░░░░░░▒▒░░░░░░░░░░▒▒▓▓░░    ░░    ▒▒░░▓▓▒▒░░                          ▒▒    ░░░░░░░░  ░░░░░░░░░░    ░░  ▒▒▒▒▒▒░░░░░░  ░░░░▒▒▒▒▒▒██▒▒▒▒▒▒░░░░░░░░░░\n" + 
				"░░▒▒▒▒▒▒▒▒▒▒░░░░░░░░▒▒▓▓▒▒▒▒▒▒▒▒░░░░░░░░░░░░░░░░░░░░▒▒▓▓░░▒▒  ░░░░  ░░▒▒▒▒▓▓░░░░                        ▒▒    ░░    ░░░░░░▒▒▒▒░░░░  ░░░░▓▓▒▒  ▒▒▒▒▒▒░░    ░░▒▒░░░░▓▓░░▓▓░░░░░░░░░░░░░░\n" + 
				"▓▓▓▓▒▒▒▒░░░░░░░░░░░░░░▒▒▒▒▒▒▒▒▒▒▒▒░░░░░░  ░░░░▒▒░░▒▒▓▓  ▒▒▒▒▒▒░░░░░░▒▒░░▒▒░░░░  ░░                  ░░░░      ▒▒▓▓▒▒  ░░░░░░▒▒▒▒░░▒▒░░▓▓▓▓▓▓▓▓░░▒▒▓▓░░░░  ▒▒▓▓▓▓▓▓░░░░▓▓▒▒▒▒░░▒▒░░░░░░\n" + 
				"▒▒░░░░▒▒▓▓▒▒░░░░░░▒▒▒▒░░░░▒▒▓▓▒▒▒▒▒▒░░░░░░░░░░░░▒▒▓▓░░░░▒▒▒▒░░░░░░▒▒░░▒▒▓▓░░      ░░              ░░░░  ░░░░  ▒▒▓▓▓▓░░  ░░░░░░▒▒▒▒░░▒▒▓▓▓▓▓▓▒▒░░░░▒▒▒▒░░░░▓▓▓▓▓▓▒▒░░░░  ▒▒▓▓▒▒▒▒░░░░░░\n" + 
				"░░░░░░▓▓▓▓▓▓▒▒  ▒▒▒▒░░░░░░▒▒▓▓▓▓▓▓▓▓▒▒░░░░░░░░▒▒▒▒░░▒▒▒▒▒▒▓▓░░░░░░▒▒▒▒▓▓░░░░        ░░          ▒▒▒▒░░  ░░░░  ▒▒▒▒▒▒  ░░  ░░░░░░▒▒▒▒  ▓▓▒▒▒▒▒▒░░  ░░▒▒░░▒▒▓▓▓▓░░░░░░░░░░░░░░▒▒▒▒▒▒▒▒  \n" + 
				"    ░░▒▒▓▓▓▓  ▓▓▒▒░░░░░░▓▓░░▒▒▓▓▓▓██▓▓▒▒░░░░▒▒▒▒                     __,-~~/~    `---.\n" + 
				"                   _/_,---(      ,    )\n" + 
				"               __ /        <    /   )  \\___\n" + 
				"- ------===;;;'====------------------===;;;===----- -  -\n" + 
				"                  \\/  ~\"~\"~\"~\"~\"~\\~\"~)~\"/\n" + 
				"                  (_ (   \\  (     >    \\)\n" + 
				"                   \\_( _ <         >_>'\n" + 
				"                      ~ `-i' ::>|--\"\n" + 
				"                          I;|.|.|\n" + 
				"                         <|i::|i|`.\n" + 
				"                        (` ^'\"`-' \")▒▒░░  ░░░░░░░░░░░░░░▒▒▒▒░░        ░░  ░░        ░░▒▒▓▓▒▒░░░░░░░░▒▒░░    ░░░░▒▒▒▒▒▒▒▒▒▒    ▒▒▒▒░░░░  ▒▒▒▒▒▒▒▒░░░░▒▒░░░░░░░░▓▓▒▒░░▓▓▒▒▒▒\n" + 
				"▒▒    ░░▒▒░░▒▒▓▓▒▒▓▓░░░░▒▒▒▒▒▒▒▒▓▓▓▓▓▓▒▒░░░░▒▒▒▒░░  ░░  ░░░░░░░░░░▒▒▒▒░░░░  ░░  ░░░░  ▒▒▒▒    ▒▒▒▒░░▒▒▓▓▒▒░░░░░░    ░░░░▒▒▒▒▒▒▓▓▓▓▒▒▒▒░░  ▒▒░░░░░░▒▒  ▒▒▒▒▒▒░░▒▒░░░░░░▓▓▒▒▓▓▒▒▒▒░░░░▓▓\n" + 
				"▓▓      ░░▒▒▓▓░░▒▒▓▓▓▓▒▒░░░░░░▒▒▒▒▓▓▓▓▒▒▒▒▒▒▓▓░░▒▒░░    ░░░░░░░░▒▒▓▓░░▒▒  ░░  ░░░░░░▒▒▒▒▒▒░░░░  ░░▒▒░░▒▒▓▓░░░░      ░░▒▒▓▓▓▓▓▓▓▓▒▒░░░░▒▒░░░░▒▒▒▒▓▓▒▒▓▓  ▒▒░░░░▒▒▓▓░░▓▓▓▓▓▓▒▒░░▒▒  ░░  \n" + 
				"▒▒  ░░  ░░▒▒░░  ▒▒▓▓▓▓▓▓▒▒▒▒▒▒░░░░▓▓▓▓██▓▓▓▓░░▒▒▒▒▒▒░░    ░░░░░░░░▒▒░░▒▒░░░░░░  ▒▒▒▒▒▒  ░░░░  ░░░░░░░░░░▓▓▒▒░░  ░░░░▒▒▓▓▒▒██▓▓▒▒░░░░░░░░░░░░▒▒▓▓▓▓██▓▓░░  ▒▒░░▒▒██▓▓▓▓▓▓██░░░░░░  ░░░░\n" + 
				"░░░░░░░░▒▒░░░░░░▒▒▒▒▓▓▓▓▓▓▒▒▒▒▒▒▒▒▓▓▓▓▓▓▒▒░░▒▒██▓▓▒▒░░░░░░░░░░▒▒▓▓░░░░░░░░    ▒▒▒▒░░░░▒▒░░  ▒▒  ░░░░░░░░▒▒▒▒▒▒▒▒  ▒▒▓▓▓▓██▓▓▒▒░░▒▒░░░░░░░░▓▓░░▓▓██▓▓▒▒▒▒░░░░▒▒▒▒▓▓▓▓██▓▓░░▒▒░░      ░░\n" + 
				"  ░░░░▒▒▒▒░░░░░░░░▒▒▓▓▓▓██▓▓▒▒░░░░░░░░▒▒▒▒░░▒▒▒▒▓▓██▓▓▒▒░░░░▒▒▓▓░░░░░░░░  ░░▒▒▒▒░░░░░░        ░░  ░░░░░░░░▒▒▓▓░░░░▓▓▓▓▓▓▓▓▒▒░░░░▓▓▒▒░░░░░░▓▓▓▓░░▒▒▒▒░░  ░░  ░░░░██▒▒▒▒▒▒░░        ░░  \n" + 
				"  ░░▒▒▒▒░░░░░░  ░░░░▒▒▓▓▓▓▓▓▓▓░░░░░░▒▒▒▒▒▒▓▓░░▓▓▓▓▓▓██▓▓▒▒░░▒▒▒▒░░      ▓▓▒▒▒▒▒▒▒▒░░▒▒        ░░░░  ░░░░    ▒▒▒▒▒▒▒▒▓▓░░▒▒░░░░░░░░▒▒▒▒▓▓▒▒░░▓▓▓▓  ░░░░░░    ░░░░▒▒▒▒░░          ░░░░▒▒\n" + 
				"  ▒▒▒▒░░░░▒▒░░░░░░░░░░▒▒▓▓▓▓▓▓▓▓▒▒▒▒▒▒░░░░░░░░░░▒▒▒▒▓▓▓▓▒▒▒▒▓▓░░    ░░▓▓▓▓░░░░▒▒░░░░    ░░      ▒▒░░    ░░    ▒▒▒▒▒▒▒▒░░▒▒░░▒▒▒▒▒▒▒▒▓▓▒▒▒▒░░░░▓▓▓▓  ░░    ▒▒░░░░▒▒░░░░  ░░░░░░░░░░▒▒▒▒\n" + 
				"▒▒▒▒▒▒  ░░  ░░▓▓▒▒░░░░░░░░▒▒▒▒▒▒▒▒▒▒░░▓▓░░░░░░▒▒░░░░██▓▓▓▓░░░░░░  ▓▓▓▓▒▒░░░░▒▒░░░░░░░░░░          ░░░░      ▒▒░░▓▓▒▒▒▒░░▓▓░░▒▒▓▓▒▒▓▓▒▒▒▒▒▒░░░░░░▓▓▒▒  ░░░░▒▒░░▒▒  ▒▒░░░░░░  ░░░░▒▒▒▒░░\n" + 
				"▒▒▒▒░░░░    ▒▒▓▓▒▒░░  ░░░░░░  ▒▒▓▓  ▓▓▒▒▓▓░░▒▒▒▒▒▒▓▓▓▓▒▒▒▒▒▒░░░░▓▓▓▓░░▒▒▒▒░░░░░░▒▒▒▒▒▒░░          ░░░░  ░░░░░░▒▒░░▒▒▒▒░░▓▓▓▓▒▒▓▓██▓▓░░▒▒░░░░▒▒░░░░▓▓▒▒░░  ▒▒▒▒▒▒▒▒  ▒▒▒▒░░░░░░░░  ▒▒░░\n" + 
				"░░▒▒░░░░░░  ▓▓▓▓▒▒░░░░░░░░░░▓▓▓▓░░▒▒░░▓▓▓▓▓▓▒▒▒▒▒▒░░░░░░▒▒░░▒▒▓▓▓▓░░░░▒▒░░░░░░░░░░▒▒▒▒░░░░░░  ░░▒▒░░▓▓  ░░▒▒▓▓▓▓░░░░▒▒░░▓▓▓▓▓▓██▓▓▒▒▒▒░░░░  ░░▒▒▒▒▒▒▒▒░░░░░░▓▓▒▒▒▒░░  ▓▓▒▒░░░░  ░░  ░░\n" + 
				"░░  ▒▒░░░░  ▒▒▒▒▓▓░░░░░░░░▓▓▓▓░░░░░░░░▓▓▒▒▓▓▓▓░░░░░░▒▒░░░░░░░░░░▒▒▒▒░░░░    ░░▒▒▒▒▒▒▒▒░░░░░░░░░░▒▒░░▒▒▒▒░░▓▓▒▒▓▓░░░░░░▓▓▓▓▓▓██▓▓░░▒▒░░░░  ░░  ░░░░░░▒▒▒▒  ░░░░▒▒      ░░▒▒▓▓      ░░  \n" + 
				""+Roulette.ANSI_RESET);
		System.out.println();
	}

	private static void playMenu() throws IOException, InterruptedException{
		initSecretPlayer();
		boolean exit = false;
		String input;
		while(!exit) {
			clear();
			System.out.print("╔━╤━━━━━━━━━━━━╗\n"
					+"┃1┃ Newplayer  ┃\n"
					+"╠━╫━━━━━━━━━━━━╣\n"
					+"┃2┃ LoadPlayers┃\n"
					+"╠═╬════════════╣\n"
					+"┃3┃ Ranking    ┃\n"
					+"╠═╬════════════╣\n"
					+"┃4┃ Back       ┃\n"
					+"╚═╧════════════╝\n"
					+"               \n"
					+"Faites un choix : ");
			input = userInput.nextLine();
			clear();

			switch (input) {
			case "1":

				
				System.err.println("Bienvenue dans Royal Crous \n"
						+ "Quelle est ton prénom ?  ");

				String nom= userInput.nextLine();

				while(players.existingName(nom)) {
					System.out.println("Votre nom est déjà pris veuillez en choisir un autre.");
					nom= userInput.nextLine();
				}
				
				if(secretPlayer.contains(nom)) {
					p1 = new SecretPlayer(nom);
				}else {
					p1=new Player(100,nom,1);
					init(p1);
				}
				
				while(!players.addPlayer(p1)) {
					nom= userInput.nextLine();
				}

				play();
				exit = false;
				break;
			case "2":
				System.err.println(" Mais qui revoila ici dans le meilleur jeu ,\n"
						+ "euh rappel moi ton nom de joueur : ");
				String nomLoad= userInput.nextLine();


				try {
					if(players.existingName(nomLoad)) {
						System.out.println("cool de te revoir "+nomLoad);
						p1=players.loadPlayer(nomLoad);
					}
					else { System.out.println("mais je ne t'ai jamais vu ici "+nomLoad+"  !");
					try {
						Thread.sleep(3000);
						exit = true;
						break;
					} catch (Exception e) {
						}
					}
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				play();

				exit = true;
				break;

			case "3":

				rankingMenu();
				break;

			case "4":

				exit = true;
				break;
			default:
				break;
			}
		}
	}





	private static void mainMenu() {
		System.out.print("    ╔━╤━━━━━━━━━━━╗\n"
				+"    ┃1┃ Play      ┃\n"
				+"    ╠━╫━━━━━━━━━━━╣\n"
				+"    ┃2┃ Exit      ┃\n"
				+"    ╚═╧═══════════╝\n"
				+"                   \n"
				+"Make your choice : ");
	}

	private static void clear(){
		for (int i = 0; i < 10; i++) {
			System.out.println("\n");
		}
	}



	private static void play( ) throws InterruptedException, IOException {
		LoadingMenu();
		
	}
	
	private static void play(String choix ) throws InterruptedException, IOException {
		switch (choix) {
		case "1":
			clear();
			RoyalCrous blackJack = new RoyalCrous();
			blackJack.start(p1, players);
			players.updateTxt();
			LoadingMenu();
			break;
		case "2":
			clear();
			Roulette roulette = new Roulette();
				try {
					roulette.start(p1,players);
				} catch (UnvalidBet e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			LoadingMenu();
			break;
		default:
			break;
		}
	}


	private static void rankingMenu() {
		String [] best=new String [5];
		for (int i = 0; i < best.length; i++) {
			best[i]="n°"+Integer.sum(i, 1)+" no one";
		}
		Collections.sort(players.getPlayers());
		for (int i = 0; i < players.getPlayers().size(); i++) {
			best[i]="n°"+Integer.sum(i, 1)+" "+players.getPlayers().get(i).toString();
			if(i==4)break;
		}
		System.out.println(best[0]
				+"\n"+best[1]
						+"\n"+best[2]
								+"\n"+best[3]
										+"\n"+best[4]);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private static void init(Player player){
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

		p1.setEchelon(echelon);
		p1.setBourse(bourse);
		System.out.println(p1);
		
		System.out.println("\nLe crous vous a attribué l'échelon " + echelon + " \nVotre bourse s'élève à " + bourse);  
	}

	private static void initSecretPlayer(){
		List<String> list = new ArrayList<String>();
		list.add("test");
		secretPlayer = list;
	}
}
