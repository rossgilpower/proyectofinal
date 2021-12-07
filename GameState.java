package Main;

import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import GameState.GameStateManager;

public abstract class GameState {
	
	protected GameStateManager gsm;
	
	
	public GameState(GameStateManager gsm) {
		this.gsm = gsm;
	}
	
	public abstract void init();
	public abstract void update();
	public abstract void draw(java.awt.Graphics2D g);
	public abstract void keyPressed(int k) throws LineUnavailableException, IOException, UnsupportedAudioFileException;
	public abstract void keyReleased(int k);
}