package star;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import java.util.Timer;
import java.util.TimerTask;

public class Board extends JPanel{
	
	Image Star;
	Timer timer;
	int x, y;
	
	public Board() {
		setBackground(Color.BLACK);
		
		ImageIcon ii = new ImageIcon(this.getClass().getResource("star.jpg"));
		Star = ii.getImage();
		
		setDoubleBuffered(true);
		
		x = y = 10;
		timer = new Timer();
		timer.scheduleAtFixedRate(new ScheduleTask(), 100, 10);
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		
		Graphics2D g2d = (Graphics2D)g;
		g2d.drawImage(Star, x, y, this);
		Toolkit.getDefaultToolkit().sync();
		g.dispose();
	}
	
	class ScheduleTask extends TimerTask {
		
	
		public void run(){
		x += 1;
		y += 1;
		
			if (y > 240) {
			y = -45;
			x = -45;
			}
			repaint();
		}
	}
}