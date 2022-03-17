package engine.process;

import config.GameConfiguration;
import engine.map.Block;
import engine.map.Map;
import engine.mobile.Guardian;
import engine.mobile.Player;

public class GameBuilder {

	public static Map buildMap() {
		return new Map(GameConfiguration.LINE_COUNT, GameConfiguration.COLUMN_COUNT);
	}

	public static MobileElementManager buildInitMobile(Map map) {
		MobileElementManager manager = new MobileElementManager(map);
		
		intializeGuardian(map, manager);
		
		return manager;
	}

	private static void intializeGuardian(Map map, MobileElementManager manager) {
		Block block = map.getBlock(1, 0);
		Player player = new Player(block);
		manager.set(player);
		Block blockGUARD = map.getBlock(8, 10);
		Block blockGUARD2 = map.getBlock(2, 26);
		/*Block blockGUARD3 = map.getBlock(14, 2);
		Block blockGUARD4 = map.getBlock(18, 0);
		Block blockGUARD5 = map.getBlock(14, 7);
		Block blockGUARD7 = map.getBlock(6, 12);
		Block blockGUARD8 = map.getBlock(8, 8);*/
		Guardian guardian = new Guardian(blockGUARD);
		Guardian guardian2 = new Guardian(blockGUARD2);
		/*Guardian guardian3 = new Guardian(blockGUARD3);
		Guardian guardian4 = new Guardian(blockGUARD4);
		Guardian guardian5 = new Guardian(blockGUARD5);
		Guardian guardian7 = new Guardian(blockGUARD7);
		Guardian guardian8 = new Guardian(blockGUARD8);*/
		manager.set(guardian);
		manager.addGuardian(guardian);
		manager.addGuardian(guardian2);
		/*manager.addGuardian(guardian3);
		manager.addGuardian(guardian4);
		manager.addGuardian(guardian5);
		manager.addGuardian(guardian7);
		manager.addGuardian(guardian8);*/
	}

}
