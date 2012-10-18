package edu.gatech.statusquo.spacetrader.view;

import java.io.IOException;

import javax.swing.JOptionPane;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.widgets.Text;

import edu.gatech.statusquo.spacetrader.driver.Driver;

public class CreatePlayerView {
	public Display display;
	public Shell shell;
	
	//temporary shit
	private int pointsAvailable = 15;
	private int traderUsed = 0;
	private int engineerUsed = 0;
	private int pilotUsed = 0;
	private int fighterUsed = 0;
	protected boolean status = true;
	private Text text;

	Spinner spinner;
	Spinner spinner_1;
	Spinner spinner_2;
	Spinner spinner_3;
	Label label;
	String name;
	
	public CreatePlayerView() {
		createCharacterCreationScreen();
	}

	/**
	 * Create contents of the window.
	 */
	private void createCharacterCreationScreen() {

		/*
		 * Declare some stuff. - Shawn
		 */
		spinner = new Spinner(shell, SWT.BORDER);
		spinner_1 = new Spinner(shell, SWT.BORDER);
		spinner_2 = new Spinner(shell, SWT.BORDER);
		spinner_3 = new Spinner(shell, SWT.BORDER);

		label = new Label(shell, SWT.NONE);
		label.setText(Integer.toString(pointsAvailable));
		/*
		 * Settings bounds for all the spinners. - Shawn
		 */
		spinner.setBounds(203, 109, 47, 22);
		spinner_1.setBounds(203, 137, 47, 22);
		spinner_2.setBounds(203, 192, 47, 22);
		spinner_3.setBounds(203, 164, 47, 22);

		/*
		 * Set maximums for all the spinners.
		 */
		spinner.setMaximum(15);
		spinner_1.setMaximum(15);
		spinner_2.setMaximum(15);
		spinner_3.setMaximum(15);

		/*
		 * Set the spinners to be un-editable - Shawn
		 */

		shell.setSize(400, 500);

		final Label lblNewLabel = new Label(shell, SWT.NONE);
		lblNewLabel.setBounds(143, 10, 104, 15);
		lblNewLabel.setText("Create New Player");

		text = new Text(shell, SWT.BORDER);
		text.setBounds(203, 43, 104, 21);

		final Label lblEnterAPlayer = new Label(shell, SWT.NONE);
		lblEnterAPlayer.setBounds(70, 46, 116, 15);
		lblEnterAPlayer.setText("Enter a Player Name");

		/*
		 * These are all the listeners - Shawn
		 */
		spinner.addMouseListener(new MouseAdapter() {
			/*
			 * (non-Javadoc)
			 * 
			 * @see
			 * org.eclipse.swt.events.MouseAdapter#mouseDown(org.eclipse.swt
			 * .events.MouseEvent) So incase you are wondering the reason this
			 * is here is so that we can see the amount of points in the spinner
			 * and then we can check to see with canAddMorePoints() if there can
			 * be more points added. Afterwards it will set the spinners to
			 * enabled or disabled depending on whether or not the status is
			 * true or false. - Shawn
			 * 
			 * Edit: I changed to mouseUp due to a bug that would allow a player
			 * to be created with over 15 points.
			 */
			@Override
			public void mouseUp(MouseEvent e) {
				traderUsed = Integer.parseInt(spinner.getText());
				status = canAddMorePoints();
				spinner.setEnabled(status);
				spinner_1.setEnabled(status);
				spinner_2.setEnabled(status);
				spinner_3.setEnabled(status);
				checkValidityOfPoints();
			}
		});

		spinner.addKeyListener(new KeyListener() {

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				if (spinner.getText() == "") {

				} else {
					traderUsed = Integer.parseInt(spinner.getText());
					status = canAddMorePoints();
					spinner.setEnabled(status);
					spinner_1.setEnabled(status);
					spinner_2.setEnabled(status);
					spinner_3.setEnabled(status);
					checkValidityOfPoints();
				}
			}

		});

		spinner_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				engineerUsed = Integer.parseInt(spinner_1.getText());
				status = canAddMorePoints();
				spinner.setEnabled(status);
				spinner_1.setEnabled(status);
				spinner_2.setEnabled(status);
				spinner_3.setEnabled(status);
				checkValidityOfPoints();
			}
		});

		spinner_1.addKeyListener(new KeyListener() {

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				if (spinner_1.getText() == "") {

				} else {
					engineerUsed = Integer.parseInt(spinner_1.getText());
					status = canAddMorePoints();
					spinner.setEnabled(status);
					spinner_1.setEnabled(status);
					spinner_2.setEnabled(status);
					spinner_3.setEnabled(status);
					checkValidityOfPoints();
				}
			}

		});

		spinner_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				pilotUsed = Integer.parseInt(spinner_2.getText());
				status = canAddMorePoints();
				spinner.setEnabled(status);
				spinner_1.setEnabled(status);
				spinner_2.setEnabled(status);
				spinner_3.setEnabled(status);
				checkValidityOfPoints();
			}
		});

		spinner_2.addKeyListener(new KeyListener() {

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				if (spinner_2.getText() == "") {

				} else {
					pilotUsed = Integer.parseInt(spinner_2.getText());
					status = canAddMorePoints();
					spinner.setEnabled(status);
					spinner_1.setEnabled(status);
					spinner_2.setEnabled(status);
					spinner_3.setEnabled(status);
					checkValidityOfPoints();
				}
			}
		});

		spinner_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				fighterUsed = Integer.parseInt(spinner_3.getText());
				status = canAddMorePoints();
				spinner.setEnabled(status);
				spinner_1.setEnabled(status);
				spinner_2.setEnabled(status);
				spinner_3.setEnabled(status);
				label.setText(Integer.toString(calculatePoints()));
			}
		});

		spinner_3.addKeyListener(new KeyListener() {

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				if (spinner_3.getText() == "") {

				} else {
					fighterUsed = Integer.parseInt(spinner_3.getText());
					status = canAddMorePoints();
					spinner.setEnabled(status);
					spinner_1.setEnabled(status);
					spinner_2.setEnabled(status);
					spinner_3.setEnabled(status);
					checkValidityOfPoints();
				}
			}
		});

		final Label lblAllocateSkillPoints = new Label(shell, SWT.NONE);
		lblAllocateSkillPoints.setBounds(143, 88, 104, 15);
		lblAllocateSkillPoints.setText("Allocate Skill Points");

		final Label lblFighter = new Label(shell, SWT.NONE);
		lblFighter.setBounds(131, 195, 43, 15);
		lblFighter.setText("Fighter");

		final Label lblTrader = new Label(shell, SWT.NONE);
		lblTrader.setBounds(131, 116, 55, 15);
		lblTrader.setText("Trader");

		final Label lblEngineer = new Label(shell, SWT.NONE);
		lblEngineer.setBounds(131, 146, 55, 15);
		lblEngineer.setText("Engineer");

		final Label lblPilot = new Label(shell, SWT.NONE);
		lblPilot.setBounds(131, 169, 24, 15);
		lblPilot.setText("Pilot");

		final Label lblSelectADifficulty = new Label(shell, SWT.NONE);
		lblSelectADifficulty.setBounds(143, 280, 104, 15);
		lblSelectADifficulty.setText("Select a Difficulty");

		final Button btnBeginner = new Button(shell, SWT.RADIO);
		btnBeginner.setBounds(143, 301, 90, 16);
		btnBeginner.setText("Beginner");
		btnBeginner.setSelection(true);

		final Button btnEasy = new Button(shell, SWT.RADIO);
		btnEasy.setBounds(143, 323, 90, 16);
		btnEasy.setText("Easy");

		final Button btnNormal = new Button(shell, SWT.RADIO);
		btnNormal.setBounds(143, 345, 90, 16);
		btnNormal.setText("Normal");

		final Button btnHard = new Button(shell, SWT.RADIO);
		btnHard.setBounds(143, 367, 90, 16);
		btnHard.setText("Hard");

		final Button btnImpossible = new Button(shell, SWT.RADIO);
		btnImpossible.setBounds(143, 389, 90, 16);
		btnImpossible.setText("Impossible");

		final Button btnStartGame = new Button(shell, SWT.NONE);
		btnStartGame.setBounds(10, 427, 75, 25);
		btnStartGame.setText("Start Game");

		final Button btnResetSkillPoints = new Button(shell, SWT.NONE);
		btnResetSkillPoints.setBounds(270, 427, 104, 25);
		btnResetSkillPoints.setText("Reset Skill Points");

		btnResetSkillPoints.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				pointsAvailable = 15;
				traderUsed = 0;
				engineerUsed = 0;
				pilotUsed = 0;
				fighterUsed = 0;
				status = true;
				spinner.setEnabled(status);
				spinner_1.setEnabled(status);
				spinner_2.setEnabled(status);
				spinner_3.setEnabled(status);
				spinner.setValues(0, 0, 15, 0, 1, 1);
				spinner_1.setValues(0, 0, 15, 0, 1, 1);
				spinner_2.setValues(0, 0, 15, 0, 1, 1);
				spinner_3.setValues(0, 0, 15, 0, 1, 1);
				label.setText(Integer.toString(calculatePoints()));
			}
		});

		final Label lblSkillPointsLeft = new Label(shell, SWT.NONE);
		lblSkillPointsLeft.setBounds(96, 230, 90, 15);
		lblSkillPointsLeft.setText("Points Available:");

		btnStartGame.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				status = canAddMorePoints();
				name = text.getText();
				if (status) {
					JOptionPane.showMessageDialog(null,
							"You have not assigned all of your skill points",
							"Unused Skill Points", 2);
				} else if (name == "") {
					JOptionPane.showMessageDialog(null,
							"Please enter a player name.");
				} 
				else if(calculatePoints() < 0)
				{
				    checkValidityOfPoints();
				}
				else {

					// ***********TRY CATCH**********
					Driver driver = null;
					try {
						driver = new Driver();
					} catch (IOException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					driver.createPlayer(name, pilotUsed, fighterUsed,
							traderUsed, engineerUsed);
					try {
						Driver.generateUniverse();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					// ********************************

					/*
					 * old code presenter.Driver driver = new
					 * presenter.Driver(); driver.createPlayer(name, pilotUsed,
					 * fighterUsed, traderUsed, engineerUsed);
					 * driver.generateUniverse();
					 */

					text.setVisible(false);
					spinner.setVisible(false);
					spinner_1.setVisible(false);
					spinner_2.setVisible(false);
					spinner_3.setVisible(false);
					label.setVisible(false);
					lblEnterAPlayer.setVisible(false);
					lblNewLabel.setVisible(false);
					lblAllocateSkillPoints.setVisible(false);
					lblFighter.setVisible(false);
					lblTrader.setVisible(false);
					lblEngineer.setVisible(false);
					lblPilot.setVisible(false);
					lblSelectADifficulty.setVisible(false);
					btnBeginner.setVisible(false);
					btnEasy.setVisible(false);
					btnNormal.setVisible(false);
					btnHard.setVisible(false);
					btnImpossible.setVisible(false);
					btnStartGame.setVisible(false);
					btnResetSkillPoints.setVisible(false);
					lblSkillPointsLeft.setVisible(false);
//					createMainApplicationWindow();
				}
			}
		});

		label.setBounds(205, 230, 55, 15);
	}

	/**
	 * This method will tell the program whether or not all the skill points
	 * have been used.
	 * 
	 * @return boolean which states whether all the points have been used or
	 *         not.
	 */
	private boolean canAddMorePoints() {
		// TODO Auto-generated method stub
		int totalPoints = traderUsed + engineerUsed + pilotUsed + fighterUsed;
		if (totalPoints <= 14) {
			return true;
		}
		return false;
	}

	/**
	 * This method just takes the points from trader, explorer, pilot, and adds
	 * them together.
	 * 
	 * @return int that is the number of points left to add to the skillset.
	 */

	private int calculatePoints() {
		int totalPoints = Integer.parseInt(spinner.getText()) + Integer.parseInt(spinner_1.getText()) + Integer.parseInt(spinner_2.getText()) + Integer.parseInt(spinner_3.getText());
		return pointsAvailable - totalPoints;
	}

	/**
	 * This will check the validity of the points and reset them if an
	 * inconsistency is detected for example, if the points are over 15.
	 */
	private void checkValidityOfPoints() {
		if (calculatePoints() < 0) {
			JOptionPane.showMessageDialog(null,
					"Invalid entries detected. Resetting all skill points.");
			pointsAvailable = 15;
			traderUsed = 0;
			engineerUsed = 0;
			pilotUsed = 0;
			fighterUsed = 0;
			status = true;
			spinner.setEnabled(status);
			spinner_1.setEnabled(status);
			spinner_2.setEnabled(status);
			spinner_3.setEnabled(status);
			spinner.setValues(0, 0, 15, 0, 1, 1);
			spinner_1.setValues(0, 0, 15, 0, 1, 1);
			spinner_2.setValues(0, 0, 15, 0, 1, 1);
			spinner_3.setValues(0, 0, 15, 0, 1, 1);
			label.setText(Integer.toString(calculatePoints()));
		} else {
			label.setText(Integer.toString(calculatePoints()));
		}
	}

	/*
	 * Again, this is a big copy and paste. Sorry if it gets a little rough
	 * here.
	 */
}
