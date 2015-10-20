package GUI;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JPasswordField;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;

public class HSPTab4 extends JPanel {
	private JTable table;

	/**
	 * Create the panel.
	 */
	public HSPTab4() {
		setLayout(null);
		
		JLabel lblHowDoU = new JLabel("how do u want this to look i dont really know");
		lblHowDoU.setBounds(81, 84, 277, 14);
		add(lblHowDoU);
		
		JLabel lblThisIsFor = new JLabel("This is for the listing appointments screen, honestly can be done with a lot of things");
		lblThisIsFor.setBounds(10, 132, 430, 14);
		add(lblThisIsFor);
		

		

	}

}
