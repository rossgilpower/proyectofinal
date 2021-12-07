package Levels;

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

import GameState.GameStateManager;
import Main.Background;
import Main.GameState;

public class Lvl2 extends GameState {

	private Background bg;
	Font font = new Font("Verdana",Font.BOLD,20);
	private int selection = 0;
	BufferedImage lapiz;
	private String [] temas = {"Pronombres","Días de la semana","Meses del año","Volver"};
	
	public Lvl2(GameStateManager gsm) {
		super(gsm);
		try {
			lapiz = ImageIO.read(new FileInputStream("C:\\Users\\PC\\eclipse-workspace\\Proyecto_Final\\src\\bg\\lapicito.png"));
			bg = new Background("/bg/Fondo_Temas.jpg");
			bg.setVector(-0.1, 0);

		} catch (Exception e) {
			e.printStackTrace();
		}
		init();
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
		for(int i = 0; i<temas.length;i++) {
			if(i==selection) {
				g.setColor(Color.BLUE);
			}else {
				g.setColor(Color.BLACK);
			}
			g.drawString(temas[i], 200, 130+i*20);
		}
		
		switch(selection) {
		case 0:
			g.drawImage(lapiz,160,110,null);
			break;
		case 1:
			g.drawImage(lapiz,160,130,null);
			break;
		case 2:
			g.drawImage(lapiz,160,150,null);
			break;
		case 3:
			g.drawImage(lapiz,160,170,null);
			break;
		}
	}

	private void select() {
		switch(selection) {
		case 0:
			gsm.setState(GameStateManager.LVL2_TEMA1);
			break;
		case 1:
			gsm.setState(GameStateManager.LVL2_TEMA2);
			break;
		case 2:
			gsm.setState(GameStateManager.LVL2_TEMA3);
			break;
		case 3:
			gsm.setState(GameStateManager.NIVELES);
			break;
		}
	}
	@Override
	public void keyPressed(int k) throws LineUnavailableException, IOException, UnsupportedAudioFileException {
		switch(k) {
		case(KeyEvent.VK_ENTER):
			select();
			break;
		case(KeyEvent.VK_W):
			selection--;
			if(selection == -1) {
				selection = temas.length -1;
			}
			break;
		case(KeyEvent.VK_S):
			selection ++;
			if(selection == temas.length) {
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
