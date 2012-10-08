import javax.swing.JOptionPane;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;

public class CharacterCreation {

	protected Shell shell;
	private Text text;
	private int pointsAvailable = 15;
	private int traderUsed = 0;
	private int engineerUsed = 0;
	private int pilotUsed = 0;
	private int fighterUsed = 0;
	protected boolean status = true;
	
	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			final CharacterCreation window = new CharacterCreation();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Open the window.
	 */
	public void open() {
		final Display display = Display.getDefault();
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
	protected void createContents() {
		shell = new Shell();
		
		final Spinner spinner = new Spinner(shell, SWT.BORDER);
		final Spinner spinner_1 = new Spinner(shell, SWT.BORDER);
		final Spinner spinner_2 = new Spinner(shell, SWT.BORDER);
		final Spinner spinner_3 = new Spinner(shell, SWT.BORDER);
		final Label label = new Label(shell, SWT.NONE);

		shell.setSize(468, 515);
		shell.setText("Create a Character");
		
		final Label lblCreateAPlayer = new Label(shell, SWT.NONE);
		lblCreateAPlayer.setBounds(180, 10, 85, 15);
		lblCreateAPlayer.setText("Create a Player");
		
		final Label lblEnterThePlayer = new Label(shell, SWT.NONE);
		lblEnterThePlayer.setBounds(70, 47, 118, 15);
		lblEnterThePlayer.setText("Enter the player name:");
		
		text = new Text(shell, SWT.BORDER);
		text.setBounds(250, 44, 127, 21);
		
		spinner.setMaximum(15);
		spinner.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) 
			{
				traderUsed = Integer.parseInt(spinner.getText());
				status = canAddMorePoints();
				spinner.setEnabled(status);
				spinner_1.setEnabled(status);
				spinner_2.setEnabled(status);
				spinner_3.setEnabled(status);
				label.setText(Integer.toString(calculatePoints()));
			}
		});
		spinner.setBounds(250, 83, 47, 22);
		
		spinner_1.setMaximum(15);
		spinner_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				engineerUsed = Integer.parseInt(spinner_1.getText());
				status = canAddMorePoints();
				spinner.setEnabled(status);
				spinner_1.setEnabled(status);
				spinner_2.setEnabled(status);
				spinner_3.setEnabled(status);
				label.setText(Integer.toString(calculatePoints()));
			}
		});
		spinner_1.setBounds(250, 111, 47, 22);
		
		spinner_2.setMaximum(15);
		spinner_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) 
			{
				pilotUsed = Integer.parseInt(spinner_2.getText());
				status = canAddMorePoints();
				spinner.setEnabled(status);
				spinner_1.setEnabled(status);
				spinner_2.setEnabled(status);
				spinner_3.setEnabled(status);
				label.setText(Integer.toString(calculatePoints()));
			}
		});
		spinner_2.setBounds(250, 139, 47, 22);
		
		spinner_3.setMaximum(15);
		spinner_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) 
			{
				fighterUsed = Integer.parseInt(spinner_3.getText());
				status = canAddMorePoints();
				spinner.setEnabled(status);
				spinner_1.setEnabled(status);
				spinner_2.setEnabled(status);
				spinner_3.setEnabled(status);
				label.setText(Integer.toString(calculatePoints()));
			}
		});
		spinner_3.setBounds(250, 167, 47, 22);
		
		Label lblTrader = new Label(shell, SWT.NONE);
		lblTrader.setBounds(149, 86, 39, 15);
		lblTrader.setText("Trader");
		
		Label lblExplorer = new Label(shell, SWT.NONE);
		lblExplorer.setBounds(149, 114, 47, 15);
		lblExplorer.setText("Engineer");
		
		Label lblPilot = new Label(shell, SWT.NONE);
		lblPilot.setBounds(149, 142, 55, 15);
		lblPilot.setText("Pilot");
		
		Label lblFighter = new Label(shell, SWT.NONE);
		lblFighter.setBounds(149, 170, 55, 15);
		lblFighter.setText("Fighter");
		
		Label lblPointsAvailable = new Label(shell, SWT.NONE);
		lblPointsAvailable.setBounds(98, 208, 90, 15);
		lblPointsAvailable.setText("Points Available :");
		
		label.setBounds(250, 208, 55, 15);
		label.setText(Integer.toString(calculatePoints()));

		Button btnRadioButton = new Button(shell, SWT.RADIO);
		btnRadioButton.setBounds(180, 275, 90, 16);
		btnRadioButton.setText("Easy");
		
		Button btnMedium = new Button(shell, SWT.RADIO);
		btnMedium.setBounds(180, 297, 90, 16);
		btnMedium.setText("Normal");
		
		Button btnHard = new Button(shell, SWT.RADIO);
		btnHard.setBounds(180, 319, 90, 16);
		btnHard.setText("Hard");
	
		
		Button btnStartGame = new Button(shell, SWT.NONE);
		btnStartGame.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseDown(MouseEvent e) 
			{
				status = canAddMorePoints();
				if(status)
				{
					JOptionPane.showMessageDialog(null, "You have not assigned all of your skill points", "Unused Skill Points", 2);
				}
				else
				{
					Driver driver = new Driver();
					driver.createPlayer(text.getText(), traderUsed, engineerUsed, pilotUsed, fighterUsed);
					MainApplication main = new MainApplication();
					shell.close();
					main.open();
				}
			}
		});
		btnStartGame.setBounds(113, 389, 75, 25);
		btnStartGame.setText("Start Game");
		
		Button btnResetSkillPoints = new Button(shell, SWT.NONE);
		btnResetSkillPoints.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseDown(MouseEvent e) 
			{
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
			}
		});
		btnResetSkillPoints.setBounds(250, 389, 100, 25);
		btnResetSkillPoints.setText("Reset Skill Points");
		
		Button btnBeginner = new Button(shell, SWT.RADIO);
		btnBeginner.setBounds(180, 253, 90, 16);
		btnBeginner.setText("Beginner");
		
		Button btnImpossible = new Button(shell, SWT.RADIO);
		btnImpossible.setBounds(180, 341, 90, 16);
		btnImpossible.setText("Impossible");
	}

	/**
	 * This method will tell the program whether or not all the skill
	 * points have been used.
	 * @return boolean which states whether all the points have been used
	 * or not.
	 */
	protected boolean canAddMorePoints() {
		// TODO Auto-generated method stub
		int totalPoints = traderUsed + engineerUsed + pilotUsed + fighterUsed;
		if(totalPoints <= 14)
		{
			return true;
		}
		return false;
	}
	
	/**
	 * This method just takes the points from trader, explorer, pilot, 
	 * and adds them together.
	 * @return int that is the number of points left to add to the skillset.
	 */
	
	protected int calculatePoints()
	{
		int totalPoints = traderUsed + engineerUsed + pilotUsed + fighterUsed;
		return pointsAvailable - totalPoints;
	}
}