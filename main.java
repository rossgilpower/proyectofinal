package Main;



import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JFrame;

import GameState.Audio;


public class main {
	
	public static void main(String[] args) throws LineUnavailableException, IOException, UnsupportedAudioFileException{
		
		JFrame window = new JFrame("Learning English With Friends!");
		window.setContentPane(new GamePanel());
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		window.pack();
		window.setVisible(true);
		Audio.playMusic("C:\\Users\\PC\\eclipse-workspace\\Proyecto_Final\\src\\musicafondo.wav");
	}

}
