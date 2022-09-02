package BlackJack;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Roulette {
	public Map<Integer,String>roulette;

	Roulette(){
		roulette=new HashMap<Integer, String>();

	}

	void remplir() {
		for(int i=1;i<37;i++) {
			if(i%2==0) {
				roulette.put(i, "N");
			}else {roulette.put(i,"R");
				}
			}
		}	
	

	int launch() {
		Random r=new Random();
		int rslt=r.nextInt(37)+1;
		return rslt;
	}
	
	String getColor(int key) {
		return roulette.get(key);
		
	}
	Boolean resultatnombre(int hasard,int entree) {
		return hasard==entree;
		
	}
	Boolean resultatcouleur(String color,String entree) {
		return color.equals(entree);
	}
}