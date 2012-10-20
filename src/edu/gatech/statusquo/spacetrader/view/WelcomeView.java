package edu.gatech.statusquo.spacetrader.view;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

public class WelcomeView {
	//figure out why shawn wanted these protected. Ask TA/Waters if it is ok to have everything public to communicate
	public Shell shell;
	public Display display;
	public Button btnStartGame; //= new Button(shell, SWT.NONE);
	public Button btnLoadGame; //= new Button(shell, SWT.NONE);
	public Label lblWelcomeToSpace; //= new Label(shell, SWT.NONE);
	
	public WelcomeView() {
		display = Display.getDefault();
		shell = new Shell(display, SWT.TITLE | SWT.CLOSE);
		btnStartGame = new Button(shell, SWT.NONE);
		btnLoadGame = new Button(shell, SWT.NONE);
		lblWelcomeToSpace = new Label(shell, SWT.NONE);
		
		try {
			createView();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create contents of the window.
	 */
	private void createView() {
		shell.open();
		shell.layout();
		shell.setSize(381, 253);
		shell.setText("Space Trader - CS 2340");
		shell.setLayout(null);

		btnStartGame.setBounds(10, 180, 75, 25);
		btnStartGame.setText("Start Game");

		btnLoadGame.setBounds(280, 180, 75, 25);
		btnLoadGame.setText("Load Game");

		lblWelcomeToSpace.setBounds(108, 35, 142, 15);
		lblWelcomeToSpace.setText("Welcome to Space Trader");
	}
}
