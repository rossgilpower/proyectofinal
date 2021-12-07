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

public class Niveles extends GameState {
	public static int amistad_charlie = 0;
	private Background bg;
	BufferedImage lapiz, charlie, anna, beto;
	Font font = new Font("Verdana",Font.BOLD,20);
	private String [] options = {"Nivel 1","Nivel 2","Nivel 3","Volver"};
	private int selection = 0;
	
	public Niveles(GameStateManager gsm) throws LineUnavailableException, IOException, UnsupportedAudioFileException {
		super(gsm);
		
		try {
			lapiz = ImageIO.read(new FileInputStream("C:\\Users\\PC\\eclipse-workspace\\Proyecto_Final\\src\\bg\\lapicito.png"));
			charlie = ImageIO.read(new FileInputStream("C:\\Users\\PC\\eclipse-workspace\\Proyecto_Final\\src\\bg\\charliePlaceHolder.png"));
			anna = ImageIO.read(new FileInputStream("C:\\Users\\PC\\eclipse-workspace\\Proyecto_Final\\src\\bg\\annaPlaceHolder.png"));
			beto = ImageIO.read(new FileInputStream("C:\\Users\\PC\\eclipse-workspace\\Proyecto_Final\\src\\bg\\betoPlaceHolder.png"));
			bg = new Background("/bg/Fondo_Niveles.jpg");
			bg.setVector(-0.1, 0);

		} catch (Exception e) {
			e.printStackTrace();
		}
		init();
	}

	private void select() {
		switch(selection) {
		case 0:
			gsm.setState(GameStateManager.LVL1);
			break;
		case 1:
			gsm.setState(GameStateManager.LVL2);
			break;
		case 2:
			gsm.setState(GameStateManager.LVL3);
			break;
		case 3:
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
			g.drawString(options[i], 100, 130+i*20);
		}
		switch(selection) {
		case 0:
			g.drawImage(lapiz,60,110,null);
			g.drawImage(charlie,200,30,null);
			break;
		case 1:
			g.drawImage(lapiz,60,130,null);
			g.drawImage(anna,200,30,null);
			break;
		case 2:
			g.drawImage(lapiz,60,150,null);
			g.drawImage(beto,200,30,null);
			break;
		case 3:
			g.drawImage(lapiz,60,170,null);
			break;
		}
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
