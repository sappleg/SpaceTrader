package edu.gatech.statusquo.spacetrader.presenter;

import javax.swing.JOptionPane;

import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;

import edu.gatech.statusquo.spacetrader.driver.*;
import edu.gatech.statusquo.spacetrader.model.*;
import edu.gatech.statusquo.spacetrader.view.*;

public class CreatePlayerPresenter {
	private Driver driver;
	private CreatePlayerView createPlayerView;
	private Player player;
	public boolean status;
	public int pointsAvailable;
	public int traderUsed;
	public int engineerUsed;
	public int pilotUsed;
	public int fighterUsed;
	
	public CreatePlayerPresenter(Driver d, CreatePlayerView cpv, Player p) {
		this.driver = d;
		this.createPlayerView = cpv;
		this.player = p;
		pointsAvailable = 15;
		traderUsed = 0;
		engineerUsed = 0;
		pilotUsed = 0;
		fighterUsed = 0;
		status = true;
		
		setListeners();
		
		while (!createPlayerView.shell.isDisposed()) {
			if (!createPlayerView.display.readAndDispatch()) {
				createPlayerView.display.sleep();
			}
		}
	}
	
	private void setListeners() {

		createPlayerView.traderSpinner.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				traderUsed = Integer.parseInt(createPlayerView.traderSpinner.getText());
				setSpinners();
			}
		});

		createPlayerView.traderSpinner.addKeyListener(new KeyListener() {
			@Override
			public void keyPressed(KeyEvent e) {

			}

			@Override
			public void keyReleased(KeyEvent e) {
				if (createPlayerView.traderSpinner.getText().equals("")) {

				} else {
					traderUsed = Integer.parseInt(createPlayerView.traderSpinner.getText());
					setSpinners();
				}
			}

		});

		createPlayerView.engineerSpinner.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				engineerUsed = Integer.parseInt(createPlayerView.engineerSpinner.getText());
				setSpinners();
			}
		});

		createPlayerView.engineerSpinner.addKeyListener(new KeyListener() {
			@Override
			public void keyPressed(KeyEvent e) {

			}

			@Override
			public void keyReleased(KeyEvent e) {
				if (createPlayerView.engineerSpinner.getText().equals("")) {

				} else {
					engineerUsed = Integer.parseInt(createPlayerView.engineerSpinner.getText());
					setSpinners();
				}
			}

		});

		createPlayerView.pilotSpinner.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				pilotUsed = Integer.parseInt(createPlayerView.pilotSpinner.getText());
				setSpinners();
			}
		});

		createPlayerView.pilotSpinner.addKeyListener(new KeyListener() {
			@Override
			public void keyPressed(KeyEvent e) {

			}

			@Override
			public void keyReleased(KeyEvent e) {
				if (createPlayerView.pilotSpinner.getText().equals("")) {

				} else {
					pilotUsed = Integer.parseInt(createPlayerView.pilotSpinner.getText());
					setSpinners();
				}
			}
		});

		createPlayerView.fighterSpinner.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				fighterUsed = Integer.parseInt(createPlayerView.fighterSpinner.getText());
				setSpinners();
			}
		});

		createPlayerView.fighterSpinner.addKeyListener(new KeyListener() {
			@Override
			public void keyPressed(KeyEvent e) {
				
			}

			@Override
			public void keyReleased(KeyEvent e) {
				if (createPlayerView.fighterSpinner.getText().equals("")) {

				} else {
					fighterUsed = Integer.parseInt(createPlayerView.fighterSpinner.getText());
					setSpinners();
				}
			}
		});

		createPlayerView.resetSkillPointsButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				pointsAvailable = 15;
				traderUsed = 0;
				engineerUsed = 0;
				pilotUsed = 0;
				fighterUsed = 0;
				status = true;
				createPlayerView.traderSpinner.setEnabled(status);
				createPlayerView.engineerSpinner.setEnabled(status);
				createPlayerView.pilotSpinner.setEnabled(status);
				createPlayerView.fighterSpinner.setEnabled(status);
				createPlayerView.traderSpinner.setValues(0, 0, 15, 0, 1, 1);
				createPlayerView.engineerSpinner.setValues(0, 0, 15, 0, 1, 1);
				createPlayerView.pilotSpinner.setValues(0, 0, 15, 0, 1, 1);
				createPlayerView.fighterSpinner.setValues(0, 0, 15, 0, 1, 1);
				createPlayerView.setPointsAvailableLabel(Integer.toString(calculatePoints()));
				player.setTraderSkills(Integer.parseInt(createPlayerView.traderSpinner.getText()));
				player.setEngineerSkills(Integer.parseInt(createPlayerView.engineerSpinner.getText()));
				player.setPilotSkills(Integer.parseInt(createPlayerView.pilotSpinner.getText()));
				player.setFighterSkills(Integer.parseInt(createPlayerView.fighterSpinner.getText()));
			}
		});

		createPlayerView.startGameButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				player.setName(createPlayerView.text.getText());
				if (canAddMorePoints()) {
					JOptionPane.showMessageDialog(null,
							"You have not assigned all of your skill points",
							"Unused Skill Points", 2);
				} else if (Player.getName().equals("")) {
					JOptionPane.showMessageDialog(null,
							"Please enter a player name.");
				} else if(calculatePoints() < 0) {
				    checkValidityOfPoints();
				} else {
//					text.setVisible(false);
//					traderSpinner.setVisible(false);
//					engineerSpinner.setVisible(false);
//					spinner_2.setVisible(false);
//					spinner_3.setVisible(false);
//					pointsAvailableLabel.setVisible(false);
//					enterPlayerLabel.setVisible(false);
//					lblNewLabel.setVisible(false);
//					skillPointsLabel.setVisible(false);
//					fighterLabel.setVisible(false);
//					traderlabel.setVisible(false);
//					engineerLabel.setVisible(false);
//					pilotLabel.setVisible(false);
//					selectDifficultyLabel.setVisible(false);
//					beginnerButton.setVisible(false);
//					easyButton.setVisible(false);
//					normalButton.setVisible(false);
//					hardButton.setVisible(false);
//					impossibleButton.setVisible(false);
//					skillPointsLeftLabel.setVisible(false);
//					startGameButton.setVisible(false);
//					resetSkillPointsButton.setVisible(false);
//					createMainApplicationWindow();
					player.setTraderSkills(Integer.parseInt(createPlayerView.traderSpinner.getText()));
					player.setEngineerSkills(Integer.parseInt(createPlayerView.engineerSpinner.getText()));
					player.setPilotSkills(Integer.parseInt(createPlayerView.pilotSpinner.getText()));
					player.setFighterSkills(Integer.parseInt(createPlayerView.fighterSpinner.getText()));
					createPlayerView.shell.dispose();
					driver.generateMainGame();
				}
			}
		});
	}

	/**
	 * This method will tell the program whether or not all the skill points
	 * have been used.
	 * 
	 * @return boolean which states whether all the points have been used or
	 *         not.
	 */
	private boolean canAddMorePoints() {
		int totalPoints = traderUsed 
				+ engineerUsed 
				+ pilotUsed 
				+ fighterUsed;
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
		int totalPoints = Integer.parseInt(createPlayerView.traderSpinner.getText()) 
				+ Integer.parseInt(createPlayerView.engineerSpinner.getText()) 
				+ Integer.parseInt(createPlayerView.pilotSpinner.getText()) 
				+ Integer.parseInt(createPlayerView.fighterSpinner.getText());
		return pointsAvailable - totalPoints;
	}
	
	
	/**
	 * This will check the validity of the points and reset them if an
	 * inconsistency is detected for example, if the points are over 15.
	 */
	private void checkValidityOfPoints() {
		if (calculatePoints() < 0) {
			JOptionPane.showMessageDialog(null, "Invalid entries detected. Resetting all skill points.");
			pointsAvailable = 15;
			traderUsed = 0;
			engineerUsed = 0;
			pilotUsed = 0;
			fighterUsed = 0;
			status = true;
			createPlayerView.traderSpinner.setEnabled(status);
			createPlayerView.engineerSpinner.setEnabled(status);
			createPlayerView.pilotSpinner.setEnabled(status);
			createPlayerView.fighterSpinner.setEnabled(status);
			createPlayerView.traderSpinner.setValues(0, 0, 15, 0, 1, 1);
			createPlayerView.engineerSpinner.setValues(0, 0, 15, 0, 1, 1);
			createPlayerView.pilotSpinner.setValues(0, 0, 15, 0, 1, 1);
			createPlayerView.fighterSpinner.setValues(0, 0, 15, 0, 1, 1);
			createPlayerView.setPointsAvailableLabel(Integer.toString(calculatePoints()));
		} else {
			createPlayerView.setPointsAvailableLabel(Integer.toString(calculatePoints()));
		}
	}
	
	private void setSpinners() {
		createPlayerView.traderSpinner.setEnabled(status);
		createPlayerView.engineerSpinner.setEnabled(status);
		createPlayerView.pilotSpinner.setEnabled(status);
		createPlayerView.fighterSpinner.setEnabled(status);
		checkValidityOfPoints();
		status = canAddMorePoints();
	}
	
	public int getPointsAvailable() {
		return pointsAvailable;
	}
}
