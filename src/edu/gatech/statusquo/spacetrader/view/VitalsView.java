package edu.gatech.statusquo.spacetrader.view;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.TableCursor;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;

import edu.gatech.statusquo.spacetrader.model.*;

public class VitalsView {
	Shell shell;
	Player player;
	Label lblVitals;
	Label lblCargoBay;
	public Table table_2;
	TableColumn tblclmnCurrency;
	TableColumn tblclmnFuel;
	TableCursor tableCursor_2;
	public TableItem tableItem;
	public List cargoList;
	
	/**
	 * Shell s
	 * Player p
	 * @param s
	 * @param p
	 */
	public VitalsView(Shell s, Player p) {
		this.shell = s;
		this.player = p;
		lblVitals = new Label(shell, SWT.NONE);
		lblCargoBay = new Label(shell, SWT.NONE);
		table_2 = new Table(shell, SWT.BORDER | SWT.FULL_SELECTION);
		tblclmnCurrency = new TableColumn(table_2, SWT.CENTER);
		tblclmnFuel = new TableColumn(table_2, SWT.CENTER);
		tableCursor_2 = new TableCursor(table_2, SWT.NONE);
		tableItem = new TableItem(table_2, SWT.NONE);
		cargoList = new List(shell, SWT.BORDER);
		
		try {
			createView();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Creates view for player and ship vitals to be displayed in
	 */
	public void createView() {
		lblVitals.setAlignment(SWT.CENTER);
		lblVitals.setBounds(903, 0, 55, 15);
		lblVitals.setText("Vitals");

		table_2.setBounds(855, 21, 143, 90);
		table_2.setHeaderVisible(true);
		table_2.setLinesVisible(true);

		tblclmnCurrency.setWidth(70);
		tblclmnCurrency.setText("Currency");

		tblclmnFuel.setWidth(69);
		tblclmnFuel.setText("Fuel");

		String[] playerState = {"0","0"};
		tableItem.setText(playerState);
		
		lblCargoBay.setAlignment(SWT.CENTER);
		lblCargoBay.setBounds(903, 120, 55, 15);
		lblCargoBay.setText("Cargo Bay");

		cargoList.setBounds(855, 140, 143, 215);
	}
}
