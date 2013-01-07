package cat;

import java.awt.Graphics;
import java.awt.Graphics2D;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Board extends JPanel{

	Image cat;
	
	public Board(){
		ImageIcon ii = new ImageIcon(this.getClass(). getResource("cat.jpg"));
		cat = ii.getImage();
	}
	
	public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.drawImage(cat, 10, 10, null);
	}
}
