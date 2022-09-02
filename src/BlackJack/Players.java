package BlackJack;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Players {
	private List<Player> players;//
	File f=new File("src/Menu/Players.txt");

	public Players() {
		players=new ArrayList<Player>();
	}

	public boolean addPlayer(String name) {
		boolean existant=false;
		for(Player prof:players) {
			if(name.equals(prof.getName())){
				existant=true;
				System.out.println("Ce nom de Joueur existe déjà, entrez en un nouveau: ");
			}
		}
		if(!existant) {
			players.add(new Player(1000,name,1));
			try (FileWriter fw=new FileWriter(this.f)){
				StringBuilder sb=new StringBuilder();
				for(Player prof:players) {
					sb.append(prof.getName()+" "+prof.getBourse()+"\n");
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

	public boolean existingName(String name) throws IOException { //Vérifie si le nom en paramètre existe
		BufferedReader lecteurAvecBuffer = null;
		String ligne;
		try{
			lecteurAvecBuffer = new BufferedReader(new FileReader(this.f));
		}
		catch(FileNotFoundException exc) {
			System.out.println("Erreur d'ouverture");
		}
		while ((ligne = lecteurAvecBuffer.readLine()) != null) {
			char c=ligne.charAt(ligne.length()-1);
			while(c!=' ') {
				ligne=ligne.substring(0,ligne.length()-1);
				c=ligne.charAt(ligne.length()-1);
			}
			ligne=ligne.substring(0,ligne.length()-1);	    	
			if(ligne.equals(name)) {
				lecteurAvecBuffer.close();
				return true;
			}
		}

		lecteurAvecBuffer.close();
		return false;
	}

	public Player loadPlayer(String name) throws IOException { //Retourne le profil correspondant au nom ou null s'il n'existe pas
		for(Player prof:players) {
			if(existingName(name)) {
				if(prof.getName().equals(name)) {
					return prof;
				}
			}
		}
		return null;
	}

	public List<Player> getPlayers() {
		return players;
	}

	public void loadPlayers() throws IOException { //Ajoute les profils du fichier.txt à l'ArrayList profils
		BufferedReader lecteurAvecBuffer = null;
		String ligne;
		int cpt=0;
		String buildName="";
		String score="";		
		try{
			lecteurAvecBuffer = new BufferedReader(new FileReader(this.f));
		}
		catch(FileNotFoundException exc) {
			System.out.println("Erreur d'ouverture");
		}
		while ((ligne = lecteurAvecBuffer.readLine()) != null) {
			char c=ligne.charAt(cpt);
			while(c!=' ') {
				buildName+=c;
				cpt++;
				c=ligne.charAt(cpt);
			}
			score=ligne.substring(cpt+1,ligne.length());
			players.add(new Player(Integer.parseInt(score),buildName,1));
			buildName="";
			cpt=0;

		}	      
		lecteurAvecBuffer.close();
	}
	
	public void majProfil(Player p,Player p1) {
		int idx=players.indexOf(p);
		
		players.set(idx, p1);

		updateTxt();
	}
	
	public void updateTxt() {
		//Collections.sort(players);
		// System.out.println("liste ordonnée des profils selon l'argent dans le wallet:\n");
		  for(Player e:players) {
		   System.out.println(e);
		 }
		try (FileWriter fw=new FileWriter(this.f)){
			StringBuilder sb=new StringBuilder();
			for(Player prof:players) {
				sb.append(prof.getName()+" "+prof.getBourse()+"\n");
			}

			fw.write(sb.toString());
		}
		catch(FileNotFoundException ffe){
			System.out.println("Problème lecture de fichier");
		}catch(IOException e) {
			System.out.println("Interruption");
		}
	}
	
	public void bestProfil() {
		
		
		
	}
	
	


}
