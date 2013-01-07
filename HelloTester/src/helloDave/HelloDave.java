package helloDave;

import javax.swing.JOptionPane;

public class HelloDave {

	/**
	 * Author: Craig Ellis
	 * Date:   Oct 2011
	 */
	public static void main(String[] args) {
		
		String name = JOptionPane.showInputDialog("Hello there, what is your name?");
		String task = JOptionPane.showInputDialog("Hello " + name + " what would you like me to do?");
		JOptionPane.showMessageDialog(null, "Im sorry " + name + " I cant do that for you!");
	}

}
