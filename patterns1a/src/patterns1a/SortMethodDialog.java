package patterns1a;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JRadioButton;

import net.miginfocom.swing.MigLayout;

public class SortMethodDialog extends JDialog {
	
	private JRadioButton quickSortRadioButton = new JRadioButton("Quick sort");
	private JRadioButton mergeSortRadioButton = new JRadioButton("Merge sort");
	private ButtonGroup sortButtonGroup = new ButtonGroup();
	private JButton okButton = new JButton("OK");
	private JButton cancelButton = new JButton("Cancel");
	private boolean okButtonPressed = false;
	private SortMethod sortMethod = SortMethod.QUICK_SORT;

	public SortMethodDialog(Frame owner, String title, boolean modal) {
		super(owner, title, modal);
		this.setLayout(new MigLayout("insets 30"));
		this.add(quickSortRadioButton, "wrap");
		this.add(mergeSortRadioButton, "wrap paragraph");
		sortButtonGroup.add(quickSortRadioButton);
		sortButtonGroup.add(mergeSortRadioButton);
		quickSortRadioButton.setSelected(true);
		this.add(okButton, "split 2, tag ok");
		this.add(cancelButton, "tag cancel");
		this.pack();
		okButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				SortMethodDialog.this.setVisible(false);
				okButtonPressed = true;
				if (mergeSortRadioButton.isSelected()) {
					sortMethod = SortMethod.MERGE_SORT;
				}
				
			}
			
		});
		cancelButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				SortMethodDialog.this.setVisible(false);
				
			}
			
		});
	}
	
	public boolean isOkButtonPressed() {
		return okButtonPressed;
	}

	public SortMethod getSortMethod() {
		return sortMethod;
	}

}
