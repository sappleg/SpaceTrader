package edu.gatech.statusquo.spacetrader.view;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.TableCursor;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;

import edu.gatech.statusquo.spacetrader.model.*;

public class VitalsView {
	Shell shell;
	Player player;
	Label lblVitals;
	Table table_2;
	TableColumn tblclmnCurrency;
	TableColumn tblclmnWeight;
	TableCursor tableCursor_2;
	TableItem tableItem;
	Table table_3;
	TableCursor tableCursor_3;
	TableColumn tblclmnCargo;
	TableColumn tblclmnWeight_1;
	
	public VitalsView(Shell s, Player p) {
		this.shell = s;
		this.player = p;
		lblVitals = new Label(shell, SWT.NONE);
		table_2 = new Table(shell, SWT.BORDER | SWT.FULL_SELECTION);
		tblclmnCurrency = new TableColumn(table_2, SWT.CENTER);
		tblclmnWeight = new TableColumn(table_2, SWT.CENTER);
		tableCursor_2 = new TableCursor(table_2, SWT.NONE);
		tableItem = new TableItem(table_2, SWT.NONE);
		table_3 = new Table(shell, SWT.BORDER | SWT.FULL_SELECTION);
		tableCursor_3 = new TableCursor(table_3, SWT.NONE);
		tblclmnCargo = new TableColumn(table_3, SWT.CENTER);
		tblclmnWeight_1 = new TableColumn(table_3, SWT.CENTER);
		
		try {
			createView();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void createView() {
		lblVitals.setAlignment(SWT.CENTER);
		lblVitals.setBounds(903, 0, 55, 15);
		lblVitals.setText("Vitals");

		table_2.setBounds(855, 21, 143, 90);
		table_2.setHeaderVisible(true);
		table_2.setLinesVisible(true);

		tblclmnCurrency.setWidth(70);
		tblclmnCurrency.setText("Currency");

		tblclmnWeight.setWidth(69);
		tblclmnWeight.setText("Fuel");

		tableItem.setText(Integer.toString(Player.getCurrency()));

		table_3.setBounds(855, 119, 143, 480);
		table_3.setHeaderVisible(true);
		table_3.setLinesVisible(true);


		tblclmnCargo.setWidth(68);
		tblclmnCargo.setText("Cargo");

		tblclmnWeight_1.setWidth(71);
		tblclmnWeight_1.setText("Weight");
	}
}
