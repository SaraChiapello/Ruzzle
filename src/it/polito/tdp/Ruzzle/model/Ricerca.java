package it.polito.tdp.Ruzzle.model;

import java.util.ArrayList;
import java.util.List;

public class Ricerca {
	public List<Pos> trovaParola(String parola,Board board) {
		for(Pos p:board.getPositions()) {
			if(board.getCellValueProperty(p).get().charAt(0)==parola.charAt(0)) {
				List<Pos> percorso=new ArrayList<>();
				percorso.add(p);
				if(cerca(parola,1, percorso,board))
					return percorso;
			}
		}
		return null;
		
	}
	public boolean cerca(String parola, int livello, List<Pos> percorso, Board board) {
		if(livello==parola.length()) { //caso terminale
			return true;
		}
		
		Pos ultima=percorso.get(percorso.size()-1);
		List<Pos> adiacenti=board.getAdiacenti(ultima);
		for(Pos nuova:adiacenti) {
			if(board.getCellValueProperty(nuova).get().charAt(0)==parola.charAt(livello)&&!percorso.contains(nuova)) {
				percorso.add(nuova);
				if(cerca(parola,livello+1,percorso,board))
					return true;
				percorso.remove(percorso.size()-1);
			}
				
		}
		return false;
		
	}

}
