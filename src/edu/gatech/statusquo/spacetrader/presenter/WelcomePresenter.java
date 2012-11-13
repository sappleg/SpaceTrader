package edu.gatech.statusquo.spacetrader.presenter;

import edu.gatech.statusquo.spacetrader.model.Player;
import edu.gatech.statusquo.spacetrader.view.*;
import edu.gatech.statusquo.spacetrader.driver.*;

import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;

public class WelcomePresenter {
	private WelcomeView welcomeView;
	private Driver driver;
	
	/**
	 * class constructor using listed parameters
	 * @param d
	 * @param wv
	 */
	public WelcomePresenter(Driver d, WelcomeView wv) {
		this.driver = d;
		this.welcomeView = wv;
		
		setListeners();
		
		while (!welcomeView.shell.isDisposed()) {
			if (!welcomeView.display.readAndDispatch()) {
				welcomeView.display.sleep();
			}
		}
	}
	
	/**
	 * sets listeners
	 */
	private void setListeners() {
		welcomeView.btnStartGame.addMouseListener(new MouseAdapter() {
			@Override
			/*
			 * (non-Javadoc)
			 * 
			 * @see
			 * org.eclipse.swt.events.MouseAdapter#mouseDown(org.eclipse.swt
			 * .events.MouseEvent) So this is where the mousedown event happens.
			 * Notice I set the visibility of all the parts of the first window
			 * to false, and then I ran the method that would create the
			 * CharacterCreationScreen in the same shell. -Shawn
			 */
			public void mouseDown(MouseEvent e) {
				welcomeView.btnStartGame.setVisible(false);
				welcomeView.btnLoadGame.setVisible(false);
				welcomeView.lblWelcomeToSpace.setVisible(false);
				// need to return to driver to signify need to create next view
				//createCharacterCreationScreen();
				welcomeView.shell.dispose();
				Driver.Player = new Player();
				driver.generateCreatePlayer();
		    
                Driver.generateUniverse();

		        int startLocation = (int) (Math.random()*150);
		        Driver.Player.setPlayerX(Driver.PositionX.get(startLocation));
		        Driver.Player.setPlayerY(Driver.PositionY.get(startLocation));
		        Driver.CurrentSystem = Driver.Player.findSystem(Driver.Player.getPlayerX(),Driver.Player.getPlayerY());
                driver.generateMainGame();
				
			}
		});
		
		welcomeView.btnLoadGame.addMouseListener(new MouseAdapter() {
			public void mouseDown(MouseEvent e) {
				welcomeView.btnStartGame.setVisible(false);
				welcomeView.btnLoadGame.setVisible(false);
				welcomeView.lblWelcomeToSpace.setVisible(false);
				welcomeView.shell.dispose();
				driver.loadGame();
				driver.generateMainGame();
			}
		});

	}
}
