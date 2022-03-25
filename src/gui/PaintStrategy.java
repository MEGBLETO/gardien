package gui;

import java.awt.Color;
import java.awt.Graphics;
import java.util.concurrent.ThreadLocalRandom;

import config.GameConfiguration;
import engine.map.Block;
import engine.map.Map;
import engine.mobile.Player;
import engine.mobile.Guardian;


public class PaintStrategy {
	
	public void paint(Map map, Graphics graphics, int lvl) {
		int blockSize = GameConfiguration.BLOCK_SIZE;
		Block[][] blocks = map.getBlocks();
		
		int level[][];
		if(lvl == 1) {
			level = GameConfiguration.level1;
		}else {
			level = GameConfiguration.level2;
		}
		

		for (int lineIndex = 0; lineIndex < map.getLineCount(); lineIndex++) {
			for (int columnIndex = 0; columnIndex < map.getColumnCount(); columnIndex++) {
				Block block = blocks[lineIndex][columnIndex];
				int randomNum = ThreadLocalRandom.current().nextInt(1, 4);
				if (level[lineIndex][columnIndex] == 1) {
					graphics.setColor(Color.WHITE);
					graphics.fillRect(block.getColumn() * blockSize, block.getLine() * blockSize, blockSize, blockSize);
				}else {
					graphics.setColor(Color.BLACK);
					graphics.fillRect(block.getColumn() * blockSize, block.getLine() * blockSize, blockSize, blockSize);
				}
				
				if (level[lineIndex][columnIndex] == 1) {
					graphics.setColor(Color.BLACK);
					graphics.fillRect(block.getColumn() * blockSize, block.getLine() * blockSize, blockSize, 1);
					graphics.setColor(Color.BLACK);
					graphics.fillRect(block.getColumn() * blockSize, block.getLine() * blockSize, 1, blockSize);
				}else {
					graphics.setColor(Color.WHITE);
					graphics.fillRect(block.getColumn() * blockSize, block.getLine() * blockSize, blockSize, 1);
					graphics.setColor(Color.WHITE);
					graphics.fillRect(block.getColumn() * blockSize, block.getLine() * blockSize, 1, blockSize);
				}
				
			}
		}
	}
	public void paint(Player player, Graphics graphics) {
		Block position = player.getPosition();
		int blockSize = GameConfiguration.BLOCK_SIZE;

		int y = position.getLine();
		int x = position.getColumn();

		graphics.setColor(Color.red);
		graphics.fillOval(x * blockSize, y * blockSize, blockSize, blockSize);
		graphics.setColor(Color.black);
		graphics.drawOval(x * blockSize, y * blockSize, blockSize, blockSize);

		//face
		graphics.setColor(Color.white);
		graphics.fillOval(x * blockSize+7,y * blockSize+8,13,13);
		graphics.fillOval(x * blockSize+21,y * blockSize+8,13,13);
		graphics.setColor(Color.black);
		graphics.fillOval(x * blockSize+11,y * blockSize+12,5,5);
		graphics.fillOval(x * blockSize+25,y * blockSize+12,5,5);

		//bouche
		graphics.setColor(Color.black);
		graphics.fillOval(x * blockSize+7,y * blockSize+24,27,7);
	}

	public void paint(Guardian guardian, Graphics graphics) {
		Block position = guardian.getPosition();
		int blockSize = GameConfiguration.BLOCK_SIZE;

		int y = position.getLine();
		int x = position.getColumn();

		graphics.setColor(Color.blue);
		graphics.fillRect(x * blockSize+2, y * blockSize+2, blockSize-4, blockSize-4);
		graphics.setColor(Color.black);
		graphics.drawRect(x * blockSize+2, y * blockSize+2, blockSize-4, blockSize-4);

		//face
		graphics.setColor(Color.white);
		graphics.fillOval(x * blockSize+7,y * blockSize+8,11,11);
		graphics.fillOval(x * blockSize+21,y * blockSize+8,11,11);
		graphics.setColor(Color.black);
		graphics.fillOval(x * blockSize+11,y * blockSize+12,3,3);
		graphics.fillOval(x * blockSize+25,y * blockSize+12,3,3);

		//bouche
		graphics.setColor(Color.black);
		graphics.fillOval(x * blockSize+7,y * blockSize+24,25,4);
	}
}
