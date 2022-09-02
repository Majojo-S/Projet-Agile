package BlackJack;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;



public class Players {
	
	private ArrayList<Player> players;//
	File f=new File("src/Menu/Players.txt");
	
	public Players() {
		players=new ArrayList<Player>();
	}

	public boolean addPlayer(String name) {
		boolean existant=false;
		for(Player player:players) {
			if(name.equals(player.getName())){
				existant=true;
				System.out.println("Ce nom de Joueur existe déjà, entrez en un nouveau: ");
			}
		}
		
		if(!existant) {
			players.add(new Player(1000,name,1));
			try (FileWriter fw=new FileWriter(this.f)){
				StringBuilder sb=new StringBuilder();
				for(Player player:players) {
					sb.append(player.getName()+" "+player.getBourse()+"\n");
					
				}

				fw.write(sb.toString());
			}
			catch(FileNotFoundException ffe){
				System.out.println("Problème lecture de fichier");
			}catch(IOException e) {
				System.out.println("Interruption");
			}
			return true;
		}else {
			return false;
		}

	}
	public static void main(String[] args) {
		Players players= new Players();
		Player player = new Player(1, "test",2);
		players.addPlayer("oui");
	}
}
