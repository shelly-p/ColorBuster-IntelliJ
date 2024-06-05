/**
 * 
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import view.GameView;
import view.TileView;

/**
 * @author Frank J. Mitropoulos
 *
 */
public class GameController {
	// These aren't used, but could be depending on your gme and what you want to do
	private int score;
	private int gameStatus;
	private int rows;
	private int cols;
	private int threshold = 3; // Sheldon implemented
	
	private int moveNumber = 0;
	
	private GameView gameView;
	
	

	/**
	 * Create the GameView and pass in the appropriate listeners
	 */
	public GameController() {
		super();		
		
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {

				// Sheldon changed Title to ColorBuster
				gameView = new GameView("ColorBuster",6,6, threshold,null
						,new NewGameListener(), new TileTouchedListener(),
						new LevelSelectorListener(), new HintListener()); //Sheldon implemented
				gameView.setVisible(true);	
				
			}
		});
		
	}
	
	// Listener used to process touches on TileView
	
	class TileTouchedListener implements ActionListener {
		@Override 
		public void actionPerformed(ActionEvent event) {
			TileView tv = (TileView) event.getSource();
			System.out.println("Tile touched..." + tv.toString());



			// delegate to GameView!
			gameView.processTouchedTile(tv); // Sheldon implemented
			
			
			//System.out.println("Not implemented yet");
			
			
			
			// If no move is available display a message
			
			if (!gameView.isMoveAvailable()) {
				JOptionPane.showMessageDialog(gameView,
					    "No more moves...");
			}
		}
		
	}
	
	// Listener used to process click on New Game Button
	
	class NewGameListener implements ActionListener {
		@Override 
		public void actionPerformed(ActionEvent event) {
			System.out.println("Starting new game...");
			//System.out.println("Not yet implemented..");

			

			// You implement this method. Delegate to GameView!
			gameView.newGame(); // Sheldon implemented
		}
		
	}

	// Sheldon implemented
	class LevelSelectorListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			gameView.getLevel(e);
		}
	}

	class HintListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			gameView.getHint();
		}
	}
}
