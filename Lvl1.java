package Levels;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;

import javax.imageio.ImageIO;

import GameState.GameStateManager;
import Main.Background;
import Main.GameState;

public class Lvl1 extends GameState {
	
	private Background bg;
	Font font = new Font("Verdana",Font.BOLD,20);
	private int selection = 0;
	BufferedImage lapiz;
	private String [] temas = {"Saludos en Inglés","Despedidas en Inglés","Números en Inglés","Volver"};
	

	public Lvl1(GameStateManager gsm) {
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
			gsm.setState(GameStateManager.LVL1_TEMA1);
			break;
		case 1:
			gsm.setState(GameStateManager.LVL1_TEMA2);
			break;
		case 2:
			gsm.setState(GameStateManager.LVL1_TEMA3);
			break;
		case 3:
			gsm.setState(GameStateManager.NIVELES);
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
