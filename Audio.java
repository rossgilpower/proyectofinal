package GameState;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Audio {
	public static String filepath;
	public static void playMusic(String filepath) throws LineUnavailableException, IOException, UnsupportedAudioFileException {
		
		File file = new File(filepath);
		
		AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
		Clip clip = AudioSystem.getClip();
		clip.open(audioStream);
		clip.start();
		clip.loop(Clip.LOOP_CONTINUOUSLY);
	}
	
	public static void playEffect(String filepath) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		File file = new File(filepath);
		AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
		Clip clip = AudioSystem.getClip();
		clip.open(audioStream);
		clip.start();
	}

}
