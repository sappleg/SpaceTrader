package edu.gatech.statusquo.spacetrader.view;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.widgets.Text;

public class CreatePlayerView {
	
	public Display display;
	public Shell shell;
	public Text text;
	public Spinner traderSpinner;
	public Spinner engineerSpinner;
	public Spinner pilotSpinner;
	public Spinner fighterSpinner;
	public Label pointsAvailableLabel;
	private final Label createPlayerLabel;
	private final Label enterPlayerLabel;
	private final Label skillPointsLabel;
	private final Label fighterLabel;
	private final Label traderlabel;
	private final Label engineerLabel;
	private final Label pilotLabel;
	private final Label selectDifficultyLabel;
	private final Label skillPointsLeftLabel;
	public final Button beginnerButton;
	public final Button easyButton;
	public final Button normalButton;
	public final Button hardButton;
	public final Button impossibleButton;
	public final Button startGameButton;
	public final Button resetSkillPointsButton;
	
	public CreatePlayerView() {
		display = Display.getDefault();
		shell = new Shell(display, SWT.TITLE | SWT.CLOSE);
		traderSpinner = new Spinner(shell, SWT.BORDER);
		engineerSpinner = new Spinner(shell, SWT.BORDER);
		pilotSpinner = new Spinner(shell, SWT.BORDER);
		fighterSpinner = new Spinner(shell, SWT.BORDER);
		pointsAvailableLabel = new Label(shell, SWT.NONE);
		text = new Text(shell, SWT.BORDER);
		createPlayerLabel = new Label(shell, SWT.NONE);
		enterPlayerLabel = new Label(shell, SWT.NONE);
		skillPointsLabel = new Label(shell, SWT.NONE);
		fighterLabel = new Label(shell, SWT.NONE);
		traderlabel = new Label(shell, SWT.NONE);
		engineerLabel = new Label(shell, SWT.NONE);
		pilotLabel = new Label(shell, SWT.NONE);
		selectDifficultyLabel = new Label(shell, SWT.NONE);
		beginnerButton = new Button(shell, SWT.RADIO);
		easyButton = new Button(shell, SWT.RADIO);
		normalButton = new Button(shell, SWT.RADIO);
		hardButton = new Button(shell, SWT.RADIO);
		impossibleButton = new Button(shell, SWT.RADIO);
		skillPointsLeftLabel = new Label(shell, SWT.NONE);
		startGameButton = new Button(shell, SWT.NONE);
		resetSkillPointsButton = new Button(shell, SWT.NONE);

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
		
		//open shell
		shell.open();
		shell.layout();

		//set label to show amount of points left to initial value
		pointsAvailableLabel.setText("15");
		pointsAvailableLabel.setBounds(205, 230, 55, 15);
		
		//settings bounds for all the spinners
		traderSpinner.setBounds(203, 109, 47, 22);
		engineerSpinner.setBounds(203, 137, 47, 22);
		pilotSpinner.setBounds(203, 192, 47, 22);
		fighterSpinner.setBounds(203, 164, 47, 22);

		/*
		 * Set maximums for all the spinners.
		 */
		traderSpinner.setMaximum(15);
		engineerSpinner.setMaximum(15);
		pilotSpinner.setMaximum(15);
		fighterSpinner.setMaximum(15);

		//set shell size
		shell.setSize(400, 500);

		//create label for top of window
		createPlayerLabel.setBounds(143, 10, 104, 15);
		createPlayerLabel.setText("Create New Player");

		//set bounds of the player name text field
		text.setBounds(203, 43, 104, 21);

		//create label for player name
		enterPlayerLabel.setBounds(70, 46, 116, 15);
		enterPlayerLabel.setText("Enter a Player Name");

		//create label telling player to allocate skill points
		skillPointsLabel.setBounds(143, 88, 104, 15);
		skillPointsLabel.setText("Allocate Skill Points");

		//create fighter label
		fighterLabel.setBounds(131, 195, 43, 15);
		fighterLabel.setText("Fighter");

		//create trader label
		traderlabel.setBounds(131, 116, 55, 15);
		traderlabel.setText("Trader");

		//create engineer label
		engineerLabel.setBounds(131, 146, 55, 15);
		engineerLabel.setText("Engineer");

		//create pilot label
		pilotLabel.setBounds(131, 169, 24, 15);
		pilotLabel.setText("Pilot");

		//create select difficulty label
		selectDifficultyLabel.setBounds(143, 280, 104, 15);
		selectDifficultyLabel.setText("Select a Difficulty");

		//create beginner button
		beginnerButton.setBounds(143, 301, 90, 16);
		beginnerButton.setText("Beginner");
		beginnerButton.setSelection(true);

		//create easy button
		easyButton.setBounds(143, 323, 90, 16);
		easyButton.setText("Easy");

		normalButton.setBounds(143, 345, 90, 16);
		normalButton.setText("Normal");

		//create hard button
		hardButton.setBounds(143, 367, 90, 16);
		hardButton.setText("Hard");

		//create impossible button
		impossibleButton.setBounds(143, 389, 90, 16);
		impossibleButton.setText("Impossible");

		//create skill points left label
		skillPointsLeftLabel.setBounds(96, 230, 90, 15);
		skillPointsLeftLabel.setText("Points Available:");

		//create start game button
		startGameButton.setBounds(10, 427, 75, 25);
		startGameButton.setText("Start Game");

		//create reset skill points button
		resetSkillPointsButton.setBounds(270, 427, 104, 25);
		resetSkillPointsButton.setText("Reset Skill Points");
	}
}