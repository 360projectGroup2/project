package GUI;

import javax.swing.JComponent.*;
import javax.swing.*;

import java.awt.Dimension;
import java.awt.event.KeyEvent;

public class HSPBase extends JPanel {

	/**
	 * Create the panel.
	 */
	public HSPBase(JPanel p1, JPanel p2, JPanel p3, JPanel p4, int secLev) {

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.addTab("Patient info", null, p1, "Searches for the patient and pulls out all the records");
		tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);

		//JComponent panel2 = makeTextPanel("Panel #2");
		tabbedPane.addTab("Update Info", null, p2,  "Update patient information");
		tabbedPane.setMnemonicAt(1, KeyEvent.VK_2);

		
		p1.setPreferredSize(new Dimension(500, 500));
		p2.setPreferredSize(new Dimension(500, 500));
		add(tabbedPane);
		
		
	}

}
