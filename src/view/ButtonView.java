/**
 * 
 */
package view;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.*;

/**
 * @author Frank J. Mitropoulos
 *
 */
public class ButtonView extends JPanel {

	 
	/**
	 * Simple button view that contains a New Game button and a levelSelector combo box.
	 * Only the NewGame button listener is currently implemented.
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton newGameButton;
	private JComboBox levelSelector;
	private JLabel levelLabel;

	private String selectedMatch; // Sheldon implemented
	private JButton hintButton; // Sheldon implemented
	
	public ButtonView(ActionListener gameButtonListener,
					  ActionListener levelSelectorListener,
					  ActionListener hintButtonListener) {
		
		levelLabel = new JLabel();
		levelLabel.setText("Min Matches: ");
		add(levelLabel);
		
		levelSelector = new JComboBox();
		levelSelector.addItem("3");
		levelSelector.addItem("4");
		levelSelector.addItem("5");

		// Sheldon implemented
		levelSelector.addActionListener(levelSelectorListener);

		add(levelSelector);
		
		newGameButton = new JButton();
		newGameButton.setText("New Game");
		newGameButton.addActionListener(gameButtonListener);
		add(newGameButton);

		// Sheldon implemented
		hintButton = new JButton();
		hintButton.setText("Hint");
		hintButton.addActionListener(hintButtonListener);
		add(hintButton);
		

	}

	// Sheldon implemented
	public void setSelectedMatch(ActionEvent e) {
		JComboBox levelSelector = (JComboBox)e.getSource();
		selectedMatch = (String) levelSelector.getSelectedItem();
	}

	public int getSelectedMatch() {
		if (selectedMatch == null)
			return 3;
		else
			return Integer.parseInt(selectedMatch);
	}
}
