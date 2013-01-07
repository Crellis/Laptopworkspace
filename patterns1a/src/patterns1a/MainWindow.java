package patterns1a;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;

import net.miginfocom.swing.MigLayout;

public class MainWindow extends JFrame {
	
	private NamesDatabase namesDatabase = new NamesDatabase();
	private JMenuBar menuBar = new JMenuBar();
	private JMenu namesMenu = new JMenu("Names");
	private JMenuItem addNameMenuItem = new JMenuItem("Add name...");
	private JMenu settingsMenu = new JMenu("Settings");
	private JMenuItem setSortMethodMenuItem = new JMenuItem("Set sort method...");
	private JLabel namesLabel = new JLabel("Names");
	private JTextArea namesTextArea = new JTextArea(10, 30);
	private JButton sortButton = new JButton("Sort");
	
	public MainWindow() {
		this.setLayout(new MigLayout("insets 30"));
		this.setJMenuBar(menuBar);
		menuBar.add(namesMenu);
		namesMenu.add(addNameMenuItem);
		menuBar.add(settingsMenu);
		settingsMenu.add(setSortMethodMenuItem);
		this.add(namesLabel, "wrap");
		this.add(namesTextArea, "wrap paragraph");
		this.add(sortButton, "alignx center");
		addNameMenuItem.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				String name = JOptionPane.showInputDialog(MainWindow.this, "Enter name");
				if (name != null) {
					namesDatabase.addName(name);
					MainWindow.this.refreshTextArea();
				}
				
			}
			
		});
		setSortMethodMenuItem.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				SortMethodDialog dialog = new SortMethodDialog(MainWindow.this, "Choose a sort method", true);
				dialog.setLocationRelativeTo(MainWindow.this);
				dialog.setVisible(true);
				if (dialog.isOkButtonPressed()) {
					SortMethod method = dialog.getSortMethod();
					namesDatabase.setSortMethod(method);
				}
			}
		});
		sortButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				namesDatabase.sort();
				MainWindow.this.refreshTextArea();
			}
			
		});
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String systemLookAndFeelClassName = UIManager.getSystemLookAndFeelClassName();
		try {
			UIManager.setLookAndFeel(systemLookAndFeelClassName);
		}
		catch (Exception ignored) {}
		MainWindow window = new MainWindow();
		window.setDefaultCloseOperation(EXIT_ON_CLOSE);
		window.pack();
		window.setLocationRelativeTo(null);
		window.setVisible(true);
	}
	
	private void refreshTextArea() {
		List<String> names = namesDatabase.getNames();
		String namesList = "";
		for (String name : names) {
			namesList += name + "\n";
		}
		namesTextArea.setText(namesList);
	}

}
