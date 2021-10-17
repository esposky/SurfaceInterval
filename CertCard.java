package nauiTables;
import java.awt.image.*;
import java.io.*;

import javax.imageio.ImageIO;

public class CertCard {
	private BufferedImage imgFront = null;
	private BufferedImage imgBack = null;
	private String type;
	
	CertCard(String fileFront, String fileBack, String type){
		setCard(fileFront, fileBack);
		setType(type);
	}
	
	private void setCard(String fileFront, String fileBack){
		try {
			imgFront = ImageIO.read(new File(fileFront));
			imgBack = ImageIO.read(new File(fileBack));
			System.out.println("File read successful");
		}
		catch(IOException e){
			System.out.println(e.getMessage());
		}
	}
	
	public BufferedImage getCardFront() {
		return imgFront;
	}
	
	public BufferedImage getCardBack() {
		return imgBack;
	}
	
	private void setType(String type) {
		this.type = type;
	}
	
	public String getType() {
		String temp = type;
		return temp;
	}
	
	public String toString() {
		return "Image Type: " + type;
	}
}
