package edu.gatech.statusquo.spacetrader.presenter;


import edu.gatech.statusquo.spacetrader.view.*;
import edu.gatech.statusquo.spacetrader.driver.*;

import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;

public class WelcomePresenter {
	private WelcomeView welcomeView;
	private Driver driver;
	
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
				driver.generateCreatePlayer();
			}
		});
	}
}
