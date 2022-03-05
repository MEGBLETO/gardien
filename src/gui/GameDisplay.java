package gui;

import java.awt.Graphics;

import javax.swing.JPanel;

import engine.map.Map;
import engine.mobile.Player;
import engine.mobile.Guardian;
import engine.process.MobileElementManager;

public class GameDisplay extends JPanel {

	private static final long serialVersionUID = 1L;

	private Map map;
	private MobileElementManager manager;
	private PaintStrategy paintStrategy = new PaintStrategy();

	public GameDisplay(Map map, MobileElementManager manager) {
		this.map = map;
		this.manager = manager;
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		paintStrategy.paint(map, g);

		Player player = manager.getPlayer();
		Guardian guard = manager.getGuard();
		paintStrategy.paint(player, g);
		paintStrategy.paint(guard, g);
		
		
		for (Guardian guardian : manager.getGuardian()) {
			paintStrategy.paint(guardian, g);
		}
	}

}
