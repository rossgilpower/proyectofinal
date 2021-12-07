package GameState;


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.imageio.ImageIO;

import Main.Background;
import Main.GameState;

public class MenuState extends GameState{
	
	// Imagen de fondo en el juego
	private Background bg;
	
	//Fuente para el texto
	Font font = new Font("Verdana",Font.BOLD,20);
	BufferedImage lapiz ;
	//Array de opciones
	private String [] options = {"Jugar","Ayuda","Salir"};
	private int selection = 0;
	
	public MenuState(GameStateManager gsm) throws LineUnavailableException, IOException, UnsupportedAudioFileException {
		super(gsm);

		try {
			lapiz = ImageIO.read(new FileInputStream("C:\\Users\\PC\\eclipse-workspace\\Proyecto_Final\\src\\bg\\lapicito.png"));
			bg = new Background("/bg/Fondo1.jpg");
			bg.setVector(-0.1, 0);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		init();
		
	}
	
	public void draw(Graphics2D g) {
		// Dibujar background
		bg.draw(g);
		//Dibujar las opciones del menú
		g.setFont(font);
		for(int i = 0; i<options.length;i++) {
			if(i==selection) {
				g.setColor(Color.BLUE);
			}else {
				g.setColor(Color.BLACK);
			}
			g.drawString(options[i], 100, 130+i*20);
		}
		
		switch(selection) {
		case 0:
			g.drawImage(lapiz,60,110,null);
			break;
		case 1:
			g.drawImage(lapiz,60,130,null);
			break;
		case 2:
			g.drawImage(lapiz,60,150,null);
			break;
		}
		
	}
	private void select() {
		switch(selection) {
		case 0:
			gsm.setState(GameStateManager.NIVELES);
			break;
		case 1:
			gsm.setState(GameStateManager.AYUDA);
			break;
		case 2:
			System.exit(0);
			break;
		}
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void keyPressed(int k) {
		switch(k) {
		case(KeyEvent.VK_ENTER):
			select();
			break;
		case(KeyEvent.VK_W):
			selection--;
			if(selection == -1) {
				selection = options.length -1;
			}
			break;
		case(KeyEvent.VK_S):
			selection ++;
			if(selection == options.length) {
				selection = 0;
			}
			break;
		}
		
	}

	@Override
	public void keyReleased(int k) {
		// TODO Auto-generated method stub
		
	}

}
