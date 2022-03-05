package engine.mobile;

import engine.map.Block;
import java.util.ArrayList;
import java.util.Random;

public class Guardian extends MobileElement{
	ArrayList<Character> mouvement = new ArrayList<Character>();
	
	int moveActuel;
	
	public Guardian(Block position) {
		super(position);
	}
	
	public void setMoveActuel(int MoveActuel) {
		this.moveActuel = moveActuel;
	}
	
	public int getMoveActuel() {
		return this.moveActuel;
	}
	
	public ArrayList<Character> getListe() {
		return mouvement;
	}
	
	public void setListeMove(ArrayList<Character> mouvement) {
		this.mouvement = mouvement;
		
		Random r = new Random();

	    String orientation = "NESO";
	    for (int i = 0; i < 20; i++) {
	        char pos = orientation.charAt(r.nextInt(orientation.length()));
	        this.mouvement.add(pos);
	    } 

	}
	
	public Character getMove(int j, ArrayList<Character> mouvement) {
		this.mouvement = mouvement;
		
		return mouvement.get(j);
	}
	
	public Character nextMove(Guardian g) throws IndexOutOfBoundsException{
		
		char nextMove;
		
		try {
			nextMove = g.mouvement.get(g.getMoveActuel());
			g.setMoveActuel(g.getMoveActuel() + 1);
			
		}catch( IndexOutOfBoundsException e){
			nextMove = g.mouvement.get(0);
			g.setMoveActuel(1);
		}
		
		return nextMove;
	}
	
	
	/*public void path(ArrayList<Character> mouvement) {
		this.mouvement = mouvement;
		
		setListeMove(this.mouvement);
		
		Iterator i = this.mouvement.iterator();
		
		while(i<100){
			while (i.hasNext()) {
		       char guardian_path = this.mouvement.get(i);
			}
		}
	}*/

}
