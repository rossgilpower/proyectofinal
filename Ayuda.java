package GameState;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import Main.Background;
import Main.GameState;

public class Ayuda extends GameState{
	
		// Imagen de fondo en el juego
		private Background bg;
		
		//Fuente para el texto
		Font font = new Font("Verdana",Font.BOLD,20);
		BufferedImage lapiz ;
		//Array de opciones
		private String [] options = {"Volver"};
		private int selection = 0;
		
	public Ayuda(GameStateManager gsm) {
		super(gsm);

		try {
			lapiz = ImageIO.read(new FileInputStream("C:\\Users\\PC\\eclipse-workspace\\Proyecto_Final\\src\\bg\\lapicito.png"));
			bg = new Background("/bg/Fondo_Ayuda.jpg");
			bg.setVector(-0.1, 0);

		} catch (Exception e) {
			e.printStackTrace();
		}
		init();
	}
	private void select() {
		switch(selection) {
		case 0:
			gsm.setState(GameStateManager.MENUSTATE);
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
			g.drawString(options[i], 230, 270+i*20);
		}
		switch(selection) {
		case 0:
			g.drawImage(lapiz,190,250,null);
			break;
		}
	}

	@Override
	public void keyPressed(int k) throws LineUnavailableException, IOException, UnsupportedAudioFileException {
		switch(k) {
		case(KeyEvent.VK_ENTER):
			select();
			break;
		case(KeyEvent.VK_UP):
			selection--;
			if(selection == -1) {
				selection = options.length -1;
			}
			break;
		case(KeyEvent.VK_DOWN):
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
