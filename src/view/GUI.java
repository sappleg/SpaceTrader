package view;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;


public class GUI {

	protected Shell shell;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			GUI UI = new GUI();
			UI.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
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
		shell.setSize(381, 253);
		shell.setText("Space Trader - CS 2340");
		shell.setLayout(null);
		
		Label lblWelcomeToSpace = new Label(shell, SWT.NONE);
		lblWelcomeToSpace.setBounds(126, 85, 135, 15);
		lblWelcomeToSpace.setText("Welcome to Space Trader");
		
		Button btnNewButton = new Button(shell, SWT.NONE);
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) 
			{
				shell.close();
				CharacterCreation characterCreator = new CharacterCreation();
				characterCreator.open();
				
			}
		});
		btnNewButton.setBounds(5, 185, 70, 25);
		btnNewButton.setText("New Game");
		
		Button btnLoadGame = new Button(shell, SWT.NONE);
		btnLoadGame.setBounds(289, 185, 72, 25);
		btnLoadGame.setText("Load Game");

	}

}
