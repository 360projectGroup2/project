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
		tabbedPane.addTab("Search Patient", null, p1, "Searches for the patient and lets you use several functions");
		tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);

		//JComponent panel2 = makeTextPanel("Panel #2");
		tabbedPane.addTab("Manage APT", null, p2,  "Manages Appointments");
		tabbedPane.setMnemonicAt(1, KeyEvent.VK_2);

		//JComponent panel3 = makeTextPanel("Panel #3");
		tabbedPane.addTab("Information", null, p3, "Lists some information about the user");
		tabbedPane.setMnemonicAt(2, KeyEvent.VK_3);

		//
		tabbedPane.addTab("Appointments", null, p4, "Lists Appointments");
		tabbedPane.setMnemonicAt(3, KeyEvent.VK_4);
		p1.setPreferredSize(new Dimension(500, 500));
		p2.setPreferredSize(new Dimension(500, 500));
		p3.setPreferredSize(new Dimension(500, 500));
		p4.setPreferredSize(new Dimension(500, 500));
		add(tabbedPane);
		
		
	}

}
