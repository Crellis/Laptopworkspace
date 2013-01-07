package frameTester;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JTextField;

public class FrameTester {

	public static void main(String[] args) {

		JFrame frame = new JFrame();
		frame.setSize(400, 400);
		JTextField text = new JTextField("Hello Craig!");
		text.setBackground(Color.green);
		frame.add(text);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}
