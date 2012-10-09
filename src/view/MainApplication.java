package view;
import java.util.ArrayList;
import java.util.Arrays;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.custom.TableCursor;
import org.eclipse.swt.widgets.TableItem;


public class MainApplication {

	protected Shell shell;
	private Table table;
	private Table table_1;
	private Table table_2;
	private Table table_3;
	private TableColumn tblclmnNewColumn;
	private List list_2;
	private TableColumn tblclmnAttribute;
	private TableColumn tblclmnQuantity;
	private TableColumn tblclmnCurrency;
	private TableColumn tblclmnWeight;
	private TableCursor tableCursor;
	private TableCursor tableCursor_1;
	private TableCursor tableCursor_2;
	private TableCursor tableCursor_3;
	private TableColumn tblclmnCargo;
	private TableColumn tblclmnWeight_1;
	private Label lblNotifications;
	private Label lblLocalPlanets;
	private presenter.Driver driver;
	private TableItem tableItem;
	private Table table_4;
	private TableItem tableItem_1;
	private TableItem tableItem_2;
	
	/**
	 * Launch the application.
	 * @param args
	 */
	
	public static void main(String[] args) {
		try {
			MainApplication main = new MainApplication();
			main.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public MainApplication(presenter.Driver dr){
	    driver = dr;
	}
	
	public MainApplication() 
	{
	    
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
		shell.setSize(1024, 768);
		shell.setText("Space Trader");
		shell.setLayout(null);
		
		Label lblShipStatistics = new Label(shell, SWT.NONE);
		lblShipStatistics.setAlignment(SWT.CENTER);
		lblShipStatistics.setBounds(53, 0, 77, 15);
		lblShipStatistics.setText("Ship Statistics");
		
		table = new Table(shell, SWT.BORDER | SWT.FULL_SELECTION);
		table.setBounds(0, 21, 190, 198);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		tblclmnAttribute = new TableColumn(table, SWT.CENTER);
		tblclmnAttribute.setWidth(89);
		tblclmnAttribute.setText("Attribute");
		
		tblclmnQuantity = new TableColumn(table, SWT.CENTER);
		tblclmnQuantity.setWidth(97);
		tblclmnQuantity.setText("Quantity");
		
		tableCursor = new TableCursor(table, SWT.NONE);
		
		Label lblTeamStatistics = new Label(shell, SWT.NONE);
		lblTeamStatistics.setBounds(53, 231, 94, 15);
		lblTeamStatistics.setText("Team Statistics");
		
		table_4 = new Table(shell, SWT.BORDER | SWT.FULL_SELECTION);
		table_4.setBounds(0, 252, 190, 165);
		table_4.setHeaderVisible(true);
		table_4.setLinesVisible(true);
		
		TableColumn tblclmnAttribute_1 = new TableColumn(table_4, SWT.NONE);
		tblclmnAttribute_1.setWidth(85);
		tblclmnAttribute_1.setText("Attribute");
		
		TableColumn tblclmnPoints = new TableColumn(table_4, SWT.NONE);
		tblclmnPoints.setWidth(87);
		tblclmnPoints.setText("Points");
		
		/*
		 * Get the player skills, the skills are in the order 
		 * located inside the player class.
		 */
		
		ArrayList<Integer> skills = model.Player.getSkills();
		
		
		tableItem_1 = new TableItem(table_4, SWT.NONE);
		String[] traderArray = {"Trader", skills.get(2).toString()};
		tableItem_1.setText(traderArray);
		
		tableItem_2 = new TableItem(table_4, SWT.NONE);
		String[] engineerArray = {"Engineer", skills.get(3).toString()};
		tableItem_2.setText(engineerArray);
		
		TableItem tableItem_3 = new TableItem(table_4, SWT.NONE);
		String[] pilotArray = {"Pilot", skills.get(0).toString()};
		tableItem_3.setText(pilotArray);
		
		TableItem tableItem_4 = new TableItem(table_4, SWT.NONE);
		String[] fighterArray = {"Fighter", skills.get(1).toString()};
		tableItem_4.setText(fighterArray);
		
		Label lblNewLabel = new Label(shell, SWT.NONE);
		lblNewLabel.setBounds(53, 423, 94, 15);
		lblNewLabel.setText("Solar System List");
		
		List list = new List(shell, SWT.BORDER | SWT.V_SCROLL);
		list.setBounds(0, 444, 190, 286);
		
		Label label = new Label(shell, SWT.NONE);
		label.setAlignment(SWT.CENTER);
		label.setText("Trade Goods");
		label.setBounds(485, 0, 77, 15);
		
		table_1 = new Table(shell, SWT.BORDER | SWT.FULL_SELECTION);
		table_1.setBounds(196, 21, 653, 579);
		table_1.setHeaderVisible(true);
		table_1.setLinesVisible(true);
		
		TableColumn tblclmnItems = new TableColumn(table_1, SWT.NONE);
		tblclmnItems.setWidth(521);
		tblclmnItems.setText("Item");
		
		TableColumn tblclmnPrice = new TableColumn(table_1, SWT.NONE);
		tblclmnPrice.setWidth(64);
		tblclmnPrice.setText("Price");
		
		tblclmnNewColumn = new TableColumn(table_1, SWT.NONE);
		tblclmnNewColumn.setWidth(63);
		tblclmnNewColumn.setText("Quantity");
		
		tableCursor_1 = new TableCursor(table_1, SWT.NONE);
		
		Label lblVitals = new Label(shell, SWT.NONE);
		lblVitals.setAlignment(SWT.CENTER);
		lblVitals.setBounds(903, 0, 55, 15);
		lblVitals.setText("Vitals");
		
		table_2 = new Table(shell, SWT.BORDER | SWT.FULL_SELECTION);
		table_2.setBounds(855, 21, 143, 90);
		table_2.setHeaderVisible(true);
		table_2.setLinesVisible(true);
		
		tblclmnCurrency = new TableColumn(table_2, SWT.CENTER);
		tblclmnCurrency.setWidth(70);
		tblclmnCurrency.setText("Currency");
		
		
		
		tblclmnWeight = new TableColumn(table_2, SWT.CENTER);
		tblclmnWeight.setWidth(69);
		tblclmnWeight.setText("Fuel");
		
		tableCursor_2 = new TableCursor(table_2, SWT.NONE);
		
		tableItem = new TableItem(table_2, SWT.NONE);
		tableItem.setText(Integer.toString(model.Player.getCurrency()));
		
		table_3 = new Table(shell, SWT.BORDER | SWT.FULL_SELECTION);
		table_3.setBounds(855, 119, 143, 480);
		table_3.setHeaderVisible(true);
		table_3.setLinesVisible(true);
		
		tableCursor_3 = new TableCursor(table_3, SWT.NONE);
		
		tblclmnCargo = new TableColumn(table_3, SWT.CENTER);
		tblclmnCargo.setWidth(68);
		tblclmnCargo.setText("Cargo");
		
		tblclmnWeight_1 = new TableColumn(table_3, SWT.CENTER);
		tblclmnWeight_1.setWidth(71);
		tblclmnWeight_1.setText("Weight");
		
		lblNotifications = new Label(shell, SWT.NONE);
		lblNotifications.setAlignment(SWT.CENTER);
		lblNotifications.setBounds(485, 604, 77, 15);
		lblNotifications.setText("Notifications");
		
		List list_1 = new List(shell, SWT.BORDER);
		list_1.setBounds(196, 628, 653, 96);
		list_1.add("Welcome to Space Trader " + model.Player.getName());
		
		lblLocalPlanets = new Label(shell, SWT.NONE);
		lblLocalPlanets.setBounds(891, 604, 77, 15);
		lblLocalPlanets.setText("Local Planets");
		
		list_2 = new List(shell, SWT.BORDER);
		list_2.setBounds(855, 625, 143, 99);
	}
	
	public void setDriver(presenter.Driver driver)
	{
	    
	    return ;
	}
}
