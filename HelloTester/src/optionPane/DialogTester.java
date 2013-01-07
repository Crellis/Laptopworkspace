package optionPane;

import javax.swing.JOptionPane;

public class DialogTester {

	/**
	 * Author: Craig Ellis
	 * Date:   October 2011
	 */
	public static void main(String[] args) {
		
		String name = JOptionPane.showInputDialog("What is your name?");
		JOptionPane.showMessageDialog(null, "Hello " + name);
		System.exit(0);

	}

}
