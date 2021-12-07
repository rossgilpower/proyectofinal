	package Main;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JPanel;

import GameState.GameStateManager;

public class GamePanel extends JPanel implements Runnable, KeyListener {

	//Atributos
	
	
	// Dimensiones

	private static final long serialVersionUID = 1L;
	
	public static final int WIDTH = 500;
	public static final int HEIGHT = 300;
	public static final int SCALE = 2;

	// FPS, condiciones, etc del juego (thread)
	private Thread thread;
	private boolean running;
	private int FPS = 60;
	private long targetTime = 1000 / FPS;

	// Imagenes

	private BufferedImage image;
	private Graphics2D g;

	
	
	//Constructor
//-----------------------------------------------------------------
	
	//director del estado del juego
	private GameStateManager gsm;
	
	public GamePanel() {
		super();
		setPreferredSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
		setFocusable(true);
		requestFocus();

	}
	
	//Metodos
//---------------------------------------------------------------------
	
	public void addNotify() {
		super.addNotify();
		if(thread == null) {
			thread = new Thread(this);
			addKeyListener(this);
			thread.start();
		}
	}
	
	public void init() throws LineUnavailableException, IOException, UnsupportedAudioFileException {
		
		image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
		
		g = (Graphics2D) image.getGraphics();
		
		running = true;
		
		
		gsm = new GameStateManager();
		
		
		
	}
	
	public void run() {
		
		try {
			init();
		} catch (LineUnavailableException | IOException | UnsupportedAudioFileException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		long start;
		long elapsed;
		long wait;
		
		// game loop
		while(running) {
			
			start = System.nanoTime();
			
			update();
			draw();
			drawToScreen();
			
			elapsed = System.nanoTime() - start;
			
			wait = targetTime - elapsed / 1000000;
			if(wait < 0) wait = 5;
			
			try {
				Thread.sleep(wait);
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			
		}
		
	}
	
	
	private void update() {
		gsm.update();
	};
	
	
	private void draw() {
		
		gsm.draw(g);
		
	};
	
	
	private void drawToScreen() {
		Graphics g2 = getGraphics();
		g2.drawImage(image, 0, 0, WIDTH * SCALE, HEIGHT * SCALE, null);
		g2.dispose();
		
	}
	
	
	
	public void keyPressed(KeyEvent key) {
		try {
			gsm.keyPressed(key.getKeyCode());
		} catch (LineUnavailableException | IOException | UnsupportedAudioFileException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	public void keyReleased(KeyEvent key) {
		gsm.keyReleased(key.getKeyCode());
	}

	public void keyTyped(KeyEvent key) {
		
	}
	
	
}
