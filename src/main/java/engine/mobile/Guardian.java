package engine.mobile;

import engine.map.Block;
import java.util.ArrayList;
import java.util.Random;

public class Guardian extends MobileElement{
	ArrayList<Character> mouvement = new ArrayList<Character>();
	
	int moveActuel=0;
	
	public Guardian(Block position) {
		super(position);
	}
	
	public void setMoveActuel(int moveActuel) {
		this.moveActuel = moveActuel;
	}
	
	public int getMoveActuel() {
		return this.moveActuel;
	}
	
	public ArrayList<Character> getListe() {
		return this.mouvement;
	}
	
	/*public void setListeMove(ArrayList<Character> mouvement) {
		this.mouvement = mouvement;
		
		Random r = new Random();

	    String orientation = "NESO";
	    for (int i = 0; i < 20; i++) {
	        char pos = orientation.charAt(r.nextInt(orientation.length()));
	        this.mouvement.add(pos);
	    } 

	}*/
	
	public void setListeMove(ArrayList<Character> mouvement, int numGuard) {
		this.mouvement = mouvement;
		
		String path ="";
		
		/*Random r = new Random();

	    String orientation = "NESO";
	    for (int i = 0; i < 20; i++) {
	        char pos = orientation.charAt(r.nextInt(orientation.length()));
	        this.mouvement.add(pos);
	    } */
	    
	    if(numGuard == 1) {
	    	path = "SSEEESSSOOEENNNENNSSOOOONN";
	    }else if(numGuard == 2) {
	    	path = "OOOOOOSSEEOONNEEEEESSOSSNNENNE";
	    }
	    
	    for (int i = 0; i < path.length(); i++) {
	        char pos = path.charAt(i);
	        this.mouvement.add(pos);
	    } 

	}
	
	/*public Character getMove(int j, ArrayList<Character> mouvement) {
		this.mouvement = mouvement;
		
		return mouvement.get(j);
	}*/
	
	public Character nextMove(ArrayList<Character> mouvement) throws IndexOutOfBoundsException{
		
		char nextMove;
		this.mouvement = mouvement;
		
		try {
			nextMove = this.mouvement.get(getMoveActuel());
			setMoveActuel(getMoveActuel() + 1);
			
		}catch( IndexOutOfBoundsException e){
			nextMove = this.mouvement.get(0);
			setMoveActuel(1);
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
