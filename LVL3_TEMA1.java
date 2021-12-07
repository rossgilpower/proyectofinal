package Levels;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JOptionPane;

import GameState.Audio;
import GameState.GameStateManager;
import Main.Background;
import Main.GameState;

public class LVL3_TEMA1 extends GameState{

	private Background bg;
	Font font = new Font("Verdana",Font.BOLD,20);
	private int selection = 0;
	private String[] questions = new String[3];
	
	public static int amistad_beto = 0;
	public static int cont_preguntas = 0;
	BufferedImage lapiz;
	private String [] respuestas1 = {"Run, eat, fly","Cook, play, dance","Buy, read, cut"};
	private String [] respuestas2 = {"Sell, create, laugh","Sit, fly, read","Finish, answer, ask"};
	private String [] respuestas3 = {"I danced","You danced","We danced"};
	
	public LVL3_TEMA1(GameStateManager gsm) throws FileNotFoundException, IOException {
		super(gsm);
		lapiz = ImageIO.read(new FileInputStream("C:\\Users\\PC\\eclipse-workspace\\Proyecto_Final\\src\\bg\\lapicito.png"));
		try {
		for(int j = 0; j<questions.length;j++) {
			questions[j] = "/bg/lvl3_tema1_pregunta"+(j+1)+".jpg";
		}
		bg = new Background(questions[cont_preguntas]);
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
		switch(cont_preguntas) {
		case 0: //pregunta 1
			g.setFont(font);	
			for(int i = 0; i<respuestas1.length;i++) {
				if(i==selection) {
					g.setColor(Color.BLUE);
				}else {
					g.setColor(Color.BLACK);
				}
				g.drawString(respuestas1[i], 100, 130+i*20);
			}
			g.drawString("Amistad con Beto:"+String.valueOf(amistad_beto), 240,280);
			break;
		case 1: //pregunta 2
			g.setFont(font);	
			for(int i = 0; i<respuestas2.length;i++) {
				if(i==selection) {
					g.setColor(Color.BLUE);
				}else {
					g.setColor(Color.BLACK);
				}
				g.drawString(respuestas2[i], 100, 130+i*20);
			}
			g.drawString("Amistad con Beto:"+String.valueOf(amistad_beto), 240,280);
			break;
		case 2: //pregunta 3
			g.setFont(font);	
			for(int i = 0; i<respuestas3.length;i++) {
				if(i==selection) {
					g.setColor(Color.BLUE);
				}else {
					g.setColor(Color.BLACK);
				}
				g.drawString(respuestas3[i], 100, 130+i*20);
			}
			g.drawString("Amistad con Beto:"+String.valueOf(amistad_beto), 240,280);
			break;
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

	private void select() throws LineUnavailableException, IOException, UnsupportedAudioFileException {
		switch(cont_preguntas) {
		case 0: //pregunta 1
			switch(selection) {
			case 0:
				Audio.playEffect("C:\\Users\\PC\\eclipse-workspace\\Proyecto_Final\\src\\incorrecto.wav");
				JOptionPane.showMessageDialog(null, "Sigue intentandolo!");
				break;
			case 1:
				Audio.playEffect("C:\\Users\\PC\\eclipse-workspace\\Proyecto_Final\\src\\correcto.wav");
				amistad_beto++;
				cont_preguntas++;
				
				bg = new Background(questions[cont_preguntas]);
				bg.setVector(-0.1, 0);
				break;
			case 2:
				Audio.playEffect("C:\\Users\\PC\\eclipse-workspace\\Proyecto_Final\\src\\incorrecto.wav");
				JOptionPane.showMessageDialog(null, "Sigue intentandolo!");
				break;
			}
			break;
		case 1: //pregunta 2
			switch(selection) {
			case 0:
				Audio.playEffect("C:\\Users\\PC\\eclipse-workspace\\Proyecto_Final\\src\\incorrecto.wav");
				JOptionPane.showMessageDialog(null, "Sigue intentandolo!");
				break;
			case 1:
				Audio.playEffect("C:\\Users\\PC\\eclipse-workspace\\Proyecto_Final\\src\\correcto.wav");
				amistad_beto++;
				cont_preguntas++;
				
				bg = new Background(questions[cont_preguntas]);
				bg.setVector(-0.1, 0);
				break;
			case 2:
				Audio.playEffect("C:\\Users\\PC\\eclipse-workspace\\Proyecto_Final\\src\\incorrecto.wav");
				JOptionPane.showMessageDialog(null, "Sigue intentandolo!");
				break;
			}
			break;
		case 2: // pregunta 3
			switch(selection) {
			case 0:
				Audio.playEffect("C:\\Users\\PC\\eclipse-workspace\\Proyecto_Final\\src\\correcto.wav");
				amistad_beto++;
				cont_preguntas++;
				bg = new Background(questions[0]);
				bg.setVector(-0.1, 0);
				cont_preguntas = 0;
				gsm.setState(GameStateManager.LVL3);
				break;
			case 1:
				Audio.playEffect("C:\\Users\\PC\\eclipse-workspace\\Proyecto_Final\\src\\incorrecto.wav");
				JOptionPane.showMessageDialog(null, "Sigue intentandolo!");
				break;
			case 2:
				Audio.playEffect("C:\\Users\\PC\\eclipse-workspace\\Proyecto_Final\\src\\incorrecto.wav");
				JOptionPane.showMessageDialog(null, "Sigue intentandolo!");
				break;
			}
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
				selection = respuestas1.length -1;
			}
			break;
		case(KeyEvent.VK_S):
			selection ++;
			if(selection == respuestas1.length) {
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
