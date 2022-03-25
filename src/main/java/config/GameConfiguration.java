package config;

public class GameConfiguration {
	public static final int WINDOW_WIDTH = 1040;
	public static final int WINDOW_HEIGHT = 700;
	
	public static final int BLOCK_SIZE = 36;
	
	public static final int LINE_COUNT = WINDOW_HEIGHT / BLOCK_SIZE;
	public static final int COLUMN_COUNT = WINDOW_WIDTH / BLOCK_SIZE;
	
	public static final int GAME_SPEED = 1000;
	
	public static final int[][] level1 = {{ 0,0,0,0,1,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0},
			   { 1,1,1,1,1,0,0,0,0,1,0,0,0,1,1,1,1,1,1,0,1,0,0,0,0,0,1,0},
			   { 0,0,0,1,0,0,0,1,1,1,1,0,0,1,0,0,1,0,0,0,1,1,1,1,1,1,1,0},
			   { 0,0,0,1,0,1,1,1,0,0,1,0,0,1,0,0,1,0,1,1,1,0,0,0,0,1,0,0},
			   { 0,0,0,1,0,0,1,0,0,0,1,0,0,1,0,0,1,1,1,0,1,1,1,0,1,1,1,0},
			   { 0,1,1,1,0,1,1,0,0,0,1,1,1,1,0,0,0,0,0,0,1,0,1,0,1,0,0,0},
			   { 0,1,0,0,0,1,0,0,0,0,0,0,1,1,1,1,1,0,0,1,1,0,1,0,1,1,1,0},
			   { 0,1,1,1,0,1,0,0,0,0,0,0,0,0,0,0,1,0,0,1,0,0,1,0,0,0,1,0},
			   { 0,0,0,1,0,1,1,1,1,1,1,0,0,0,1,0,0,0,0,1,0,1,1,0,0,0,1,0},
			   { 1,1,1,1,0,1,0,0,0,0,1,0,0,0,1,1,1,1,0,0,0,0,0,0,0,0,1,0},
			   { 0,1,0,0,0,1,0,0,0,0,1,1,1,1,1,0,0,1,0,0,1,0,0,1,1,1,1,0},
			   { 0,1,0,0,0,1,0,1,0,0,1,0,0,1,0,0,0,1,0,0,1,0,0,0,1,0,1,0},
			   { 0,1,0,1,1,1,0,1,0,0,0,0,0,1,0,0,0,0,0,0,1,1,1,1,1,0,1,0},
			   { 0,1,0,0,0,1,0,1,0,0,0,1,1,1,0,0,0,0,0,0,1,0,1,0,0,0,1,0},
			   { 0,1,1,1,0,1,0,1,0,0,0,0,0,1,0,0,1,1,1,0,1,0,1,0,0,0,1,0},
			   { 0,1,0,0,0,1,1,1,1,0,1,0,1,1,0,0,1,0,1,0,1,0,1,1,1,0,0,0},
			   { 0,1,0,0,0,1,0,0,0,0,1,0,1,0,0,1,1,0,1,0,1,0,1,0,1,0,0,0},
			   { 0,1,1,1,1,1,0,0,0,0,1,1,1,0,0,1,0,0,1,1,1,0,1,0,1,1,1,1},
			   { 1,1,0,0,0,0,0,0,0,0,0,0,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0}};

	public static final int[][] level2 = {{ 0,0,0,0,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
					  { 1,1,1,0,0,1,0,0,0,0,0,0,0,1,1,1,0,0,0,0,0,0,0,0,1,0,0,0},
					  { 0,0,1,1,1,1,0,0,1,1,1,1,1,1,0,1,1,1,1,1,1,0,0,0,1,0,0,0},
					  { 0,0,0,0,0,1,0,0,1,0,1,0,0,0,0,0,0,0,1,0,0,0,0,1,1,0,0,0},
					  { 0,0,0,0,0,1,1,1,1,0,1,0,0,1,0,0,0,0,0,0,0,0,1,1,0,0,0,0},
					  { 0,0,0,0,0,1,0,0,0,0,1,0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,0},
					  { 0,0,0,1,1,1,0,0,0,0,1,0,0,1,0,0,0,0,1,0,0,0,1,1,1,1,1,0},
					  { 0,0,0,1,0,0,0,1,1,1,1,0,1,1,1,1,1,0,1,0,0,0,1,0,0,0,0,0},
					  { 0,1,1,1,0,0,1,1,0,0,1,0,1,0,0,0,1,0,1,0,0,0,0,0,0,0,0,0},
					  { 0,0,0,1,1,0,1,0,0,0,1,0,1,0,1,0,1,0,1,0,0,0,0,0,1,0,0,0},
					  { 0,0,0,0,0,0,0,0,0,0,1,1,1,0,1,0,0,0,1,0,0,1,1,1,1,1,1,0},
					  { 0,1,1,1,0,0,0,1,0,0,0,1,0,0,1,1,1,0,1,1,1,1,0,0,0,0,1,0},
					  { 0,1,0,0,0,0,0,1,0,0,0,1,0,0,1,0,1,0,1,0,0,0,0,0,0,0,0,0},
					  { 0,1,0,0,1,0,0,1,1,1,1,1,0,0,1,0,1,0,1,0,0,0,0,0,1,1,1,0},
					  { 0,1,0,0,1,0,0,0,0,0,0,0,0,1,1,0,1,1,1,0,0,1,0,1,1,0,1,0},
					  { 0,1,0,1,1,1,1,1,1,1,1,1,1,1,0,0,0,0,1,1,1,1,0,1,0,0,1,0},
					  { 0,1,1,1,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,1,0,0,0,0},
					  { 0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,1,1,1,1,1,1,0,0,1,1},
					  { 0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,0,0,0,0,1,1,1,1,0}};
	

}