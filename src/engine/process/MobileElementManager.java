package engine.process;

import java.util.ArrayList;
import java.util.List;

import config.GameConfiguration;
import engine.map.Block;
import engine.map.Map;
import engine.mobile.Guardian;
import engine.mobile.Player;
import gui.GameDisplay;
import javax.swing.JOptionPane;
import java.util.Random;


public class MobileElementManager {
	private Map map;


	private Player player;
	private Guardian guard;
	private List<Guardian> guardians = new ArrayList<Guardian>();
	private int level =1;
	
	
	
	public MobileElementManager(Map map) {
		this.map = map;
	}

	public void set(Player player) {
		this.player = player;
	}
	
	public void set(Guardian guardian) {
		this.guard = guardian;
	}
	
	
	public void setLevel (int level) {
		this.level=level;
	}
	
	public int getLevel() {
		return level;
	}
	
	public Guardian getGuard() {
		return guard;
	}

	public Player getPlayer() {
		return player;
	}

	public List<Guardian> getGuardian() {
		return guardians;
	}
	
	public void addGuardian(Guardian guardian) {
		guardians.add(guardian);
	}

	private static int getRandomNumber(int min, int max) {
		return (int) (Math.random() * (max + 1 - min)) + min;
	}

	public void definedPath(int k) {
		ArrayList<Character> moveGardien = guardians.get(k).getListe();
		
		guardians.get(k).setListeMove(moveGardien);
		
		int j=0;
		while(true){
			/*while (i.hasNext()) {
		       char guardian_path = this.mouvement.get(i);
			}*/
			if(j == moveGardien.size()) {
				j=0;
			}
			char guardian_path = moveGardien.get(j);
			/*nextMoveGardien(guardian_path);*/
			j=+1;
			
		}
	}
	
	public void pathGardien() {
		for(int pg = 0; pg < guardians.size(); pg++) {
			definedPath(pg);
		}
	}

	public void moveLeftPlayer() {
		Block position = player.getPosition();
		
		int lvl = getLevel();
		int[][] lvlMap;
		
		if(lvl == 1) {
			lvlMap = GameConfiguration.level1;
		}else {
			lvlMap= GameConfiguration.level2;
		}
		
		if (lvlMap[position.getLine()][position.getColumn() - 1] == 1) {
			if (position.getColumn() > 0) {
				Block newPosition = map.getBlock(position.getLine(), position.getColumn() - 1);
				player.setPosition(newPosition);
			}
		}

	}

	public void moveRightPlayer() {
		Block position = player.getPosition();
		
		int lvl = getLevel();
		int[][] lvlMap;
		
		if(lvl == 1) {
			lvlMap = GameConfiguration.level1;
		}else {
			lvlMap= GameConfiguration.level2;
		}
		
		if (lvlMap[position.getLine()][position.getColumn() + 1] == 1) {
			if (position.getColumn() < GameConfiguration.COLUMN_COUNT - 1) {
				Block newPosition = map.getBlock(position.getLine(), position.getColumn() + 1);
				player.setPosition(newPosition);
			}
		}
	}

	public void moveUpPlayer() {
		Block position = player.getPosition();
		
		int lvl = getLevel();
		int[][] lvlMap;
		
		if(lvl == 1) {
			lvlMap = GameConfiguration.level1;
		}else {
			lvlMap= GameConfiguration.level2;
		}

		if (lvlMap[position.getLine()-1][position.getColumn()] == 1) {
			Block newPosition = map.getBlock(position.getLine()-1, position.getColumn());
			player.setPosition(newPosition);
		}

	}

	public void moveDownPlayer() {
		Block position = player.getPosition();
		
		int lvl = getLevel();
		int[][] lvlMap;
		
		if(lvl == 1) {
			lvlMap = GameConfiguration.level1;
		}else {
			lvlMap= GameConfiguration.level2;
		}
		
		if (lvlMap[position.getLine()+1][position.getColumn()] == 1) {
			Block newPosition = map.getBlock(position.getLine() + 1, position.getColumn());
			player.setPosition(newPosition);
		}
	}
	
	public void nxtLevel() {
		Block position = player.getPosition();
		
		if(position.getColumn() == GameConfiguration.COLUMN_COUNT - 1 && position.getLine() == GameConfiguration.LINE_COUNT-2) {
			level++;
		}
	}

	public void impact() {
		Block position=player.getPosition();
		for (Guardian guardian : guardians) {
			if (guardian.getPosition() == position) {
				Gameover();
			}

		}
	}

	public void Gameover() {
		JOptionPane.showMessageDialog(null, "You loose");
		System.exit(0);
	}

	public void nextRound() {
		nxtLevel();
		moveGuardians();
		impact();
	}


	private void moveGuardians() {
		for (Guardian guardian : guardians) {
			Block position = guardian.getPosition();
			
			Block newPosition = new Block(0,0);
			
			Random r = new Random();
			
			int lvl = getLevel();
			int[][] lvlMap;
			
			if(lvl == 1) {
				lvlMap = GameConfiguration.level1;
			}else {
				lvlMap= GameConfiguration.level2;
			}
						
			String orientation = "NESO";
	        char pos = orientation.charAt(r.nextInt(orientation.length()));
	        if(pos == 'S') {
	        	if (position.getLine()+1 < GameConfiguration.LINE_COUNT) {
	        		if(lvlMap[position.getLine()+1][position.getColumn()] == 0) {
		        	 	newPosition = map.getBlock(position.getLine()+1, position.getColumn());
		        	 	guardian.setPosition(newPosition);
	        		}
	        	}
	        }
	       if(pos == 'N') {
	    	   if(position.getLine()-1 >= 0) {
		        	if (lvlMap[position.getLine()-1][position.getColumn()] == 1) {
		        	 	newPosition = map.getBlock(position.getLine()-1, position.getColumn());
		        	 	guardian.setPosition(newPosition);
		        	}
	    	   }
	        }else if(pos == 'S') {
	        	if (position.getLine()+1 < GameConfiguration.LINE_COUNT) {
	        		if(lvlMap[position.getLine()+1][position.getColumn()] == 1) {
		        	 	newPosition = map.getBlock(position.getLine()+1, position.getColumn());
		        	 	guardian.setPosition(newPosition);
	        		}
	        	}
	        }else if(pos == 'E'){
	        	if(position.getColumn()-1 >= 0){
		        	if (lvlMap[position.getLine()][position.getColumn()-1] == 1) {
		        	 	newPosition = map.getBlock(position.getLine(), position.getColumn()-1);
		        	 	guardian.setPosition(newPosition);
		        	}
		        }
	        }
	        else if(pos == 'O') {
	        	if(position.getColumn()+1 < GameConfiguration.COLUMN_COUNT) {
		        	if (lvlMap[position.getLine()+1][position.getColumn()] == 1) {
		        	 	newPosition = map.getBlock(position.getLine(), position.getColumn()+1);
		        	 	guardian.setPosition(newPosition);
		        	}
		        }
	        }
		}
	}




	}