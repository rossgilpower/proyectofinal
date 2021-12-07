package Main;


import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class Background {
	
	private BufferedImage image;
	
	private double X;
	private double Y;
	private double dX;
	private double dY;
	
	
	private int width;
	private int height;
	
	public Background(String s){

		try {
			image = ImageIO.read(
					getClass().getResourceAsStream(s)
					);
			width = image.getWidth();
			height = image.getHeight();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	public void setVector(double dX, double dY) {
		this.dX = dX;
		this.dY = dY;
	}
	
	
	public void draw(Graphics2D g) {
		
		
		g.drawImage(image, (int) X, (int) Y, null);
		if (X < 0) {
			g.drawImage(image, (int) X + GamePanel.WIDTH, (int) Y, null);
		}
		
		if (X > 0) {
			g.drawImage(image, (int) X - GamePanel.HEIGHT, (int) Y, null);
		}
	}
	
	
	
}
