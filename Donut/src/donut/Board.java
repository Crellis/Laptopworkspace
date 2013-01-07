package donut;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;

import javax.swing.JPanel;

public class Board extends JPanel{

	public void paint(Graphics gpu){
		super.paint(gpu);
		
		Graphics2D gpu2 = (Graphics2D) gpu;
		
		RenderingHints renderhint = 
				new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		renderhint.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
		
		gpu2.setRenderingHints(renderhint);
		
		Dimension size = getSize();
		double w = size.getWidth();
		double h = size.getHeight();
		
		Ellipse2D e = new Ellipse2D.Double(0, 0, 80, 130);
		gpu2.setStroke(new BasicStroke(1));
		gpu2.setColor(Color.green);
		
		for (double deg = 0; deg < 360; deg += 5) {
			AffineTransform at = AffineTransform.getTranslateInstance(w / 2, h / 2);
			at.rotate(Math.toRadians(deg));
			gpu2.draw(at.createTransformedShape(e));
		}
	}
}