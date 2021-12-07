package GameState;


import java.io.IOException;
import java.util.ArrayList;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import Levels.Lvl1;
import Levels.Lvl2;
import Levels.Lvl3;
import Levels.Niveles;
import Main.GamePanel;
import Main.GameState;

public class GameStateManager {

	private ArrayList<GameState> gameStates;
	private int currentState;
	

	public static final int MENUSTATE = 0;
	public static final int NIVELES = 1;
	public static final int LVL1 = 2;
	public static final int LVL1_TEMA1 = 3;
	public static final int LVL1_TEMA2 = 4;
	public static final int LVL1_TEMA3 = 5;
	public static final int LVL2 = 6;
	public static final int LVL2_TEMA1 = 7;
	public static final int LVL2_TEMA2 = 8;
	public static final int LVL2_TEMA3 = 9;
	public static final int LVL3 = 10;
	public static final int LVL3_TEMA1 = 11;
	public static final int LVL3_TEMA2 = 12;
	public static final int LVL3_TEMA3 = 13;
	public static final int AYUDA = 14;
	

	public GameStateManager() throws LineUnavailableException, IOException, UnsupportedAudioFileException {
		
		gameStates = new ArrayList<GameState>();
		currentState = MENUSTATE;	
		
		gameStates.add(new MenuState(this));
		gameStates.add(new Niveles(this));
		gameStates.add(new Lvl1(this));
		gameStates.add(new Levels.LVL1_TEMA1(this));
		gameStates.add(new Levels.LVL1_TEMA2(this));
		gameStates.add(new Levels.LVL1_TEMA3(this));
		gameStates.add(new Lvl2(this));
		gameStates.add(new Levels.LVL2_TEMA1(this));
		gameStates.add(new Levels.LVL2_TEMA2(this));
		gameStates.add(new Levels.LVL2_TEMA3(this));
		gameStates.add(new Lvl3(this));
		gameStates.add(new Levels.LVL3_TEMA1(this));
		gameStates.add(new Levels.LVL3_TEMA2(this));
		gameStates.add(new Levels.LVL3_TEMA3(this));
		gameStates.add(new Ayuda(this));

	}

	public void setState(int state) {
		currentState = state;
		gameStates.get(state);
	}

	public void update() {
		gameStates.get(currentState).update();
	}

	public void draw(java.awt.Graphics2D g) {
		if (gameStates.get(currentState) != null)
			gameStates.get(currentState).draw(g);
		else {
			g.setColor(java.awt.Color.BLACK);
			g.fillRect(0, 0, GamePanel.WIDTH, GamePanel.HEIGHT);
		}
	}
	public void keyPressed(int k) throws LineUnavailableException, IOException, UnsupportedAudioFileException {
		gameStates.get(currentState).keyPressed(k);
	}
	public void keyReleased(int k) {
		gameStates.get(currentState).keyReleased(k);
	}
}