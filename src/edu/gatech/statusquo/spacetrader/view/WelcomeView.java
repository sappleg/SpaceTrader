package edu.gatech.statusquo.spacetrader.view;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

public class WelcomeView {
	protected Shell shell;
	protected Display display;

	/**
	 * Launch the application.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			WelcomeView wv = new WelcomeView();
			wv.openLoader();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	private void openLoader() {
		display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	private void createContents() {
		shell = new Shell(display, SWT.TITLE | SWT.CLOSE);
		shell.setSize(381, 253);
		shell.setText("Space Trader - CS 2340");
		shell.setLayout(null);

		final Button btnStartGame_1 = new Button(shell, SWT.NONE);
		final Button btnLoadGame = new Button(shell, SWT.NONE);
		final Label lblWelcomeToSpace = new Label(shell, SWT.NONE);

		btnStartGame_1.addMouseListener(new MouseAdapter() {
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
				btnStartGame_1.setVisible(false);
				btnLoadGame.setVisible(false);
				lblWelcomeToSpace.setVisible(false);
				// need to return to driver to signify need to create other view
//				createCharacterCreationScreen();
			}
		});
		btnStartGame_1.setBounds(10, 180, 75, 25);
		btnStartGame_1.setText("Start Game");

		btnLoadGame.setBounds(280, 180, 75, 25);
		btnLoadGame.setText("Load Game");

		lblWelcomeToSpace.setBounds(108, 35, 142, 15);
		lblWelcomeToSpace.setText("Welcome to Space Trader");

	}
}
